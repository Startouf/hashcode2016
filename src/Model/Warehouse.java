package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import drone.ICargo;
import drone.IDrone;
import tools.Fitting;
import tools.ProductBulk;
import warehouse.IMarket;
import warehouse.MarketOffer;

public class Warehouse extends Destination implements IMarket, IWarehouse {

	private int posX = -1;
	private int posY = -1;
	
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<Order> ordersToFill;
	private LinkedList<IDrone> freeDrones;
	private ArrayList<IDrone> incomingDrones;
	
	private boolean needDrones = true;
	private boolean canTrade = false;

	public Warehouse(int posX, int posY, HashMap<Integer, Integer> products) {
		super(posX, posY, 0, products);
		setPosX(posX);
		setPosY(posY);
		setProducts(products);
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
		this.ordersToFill = (ArrayList<Order>) orders.clone();
		Collections.sort(ordersToFill);
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}

	@Override
	public void tradeAllYouCan() {
		// TODO Auto-generated method stub
	}

	@Override
	public void fillOrdersWithAvailableDrones() {
		Iterator<Order> iter = ordersToFill.iterator();
		while(iter.hasNext() && !freeDrones.isEmpty()){
			Order o = iter.next();
			int cost = numberOfDronesToFill(o);
			if(cost != -1){
				if(cost > freeDrones.size())
					this.needDrones = true;
				else{
					fillOrder(o);
				}
			}
		}
	}

	private void fillOrder(Order o) {
		for(ICargo c : Fitting.createCargoesFrom(o.getProducts())){
			IDrone d = freeDrones.get(0);
			d.loadAndGo((Destination)o, c);
		};
		
	}

	/**
	 * 
	 * @param o
	 * @return an approximation of the number of drones needed, or -1 if can't
	 */
	private int numberOfDronesToFill(Order o) {
		int cost = 0;
		HashMap<Integer, Integer> needs = o.getProducts();
		for(Integer product : needs.keySet()){
			if(!haveEnough(product, needs.get(product))){
				return -1;
			}
			cost += Math.ceil((double)(needs.get(product)*Environment.getWeight(product))/(double)Environment.PAYLOAD);
		}
		return cost;
	}
	
	private boolean haveEnough(int product, int quantity){
		return this.products.get(product)>=quantity;
	}

	@Override
	public List<IDrone> getFreeDrones() {
		return freeDrones;
	}

	@Override
	public void update() {
	}

	@Override
	public void notifyIncomingDrone(IDrone d) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * At creation of a drone, it belongs to somewhere
	 * @param d
	 */
	public void addDrone(Drone d) {
		this.freeDrones.add(d);
		
	}

	@Override
	public void notifyLeavingDrone(IDrone d) {
		this.freeDrones.remove(d);
	}

	@Override
	public List<MarketOffer> postOffers() {
		ArrayList<MarketOffer> offers = new ArrayList<MarketOffer>();
		HashMap<Integer, Integer> delta = (HashMap<Integer, Integer>) this.products.clone(); 
		
		// Buy requests
		for(Order o : ordersToFill){
			HashMap<Integer, Integer> products = o.getProducts();
			for(Integer productID : products.keySet()){
				int ours = delta.get(productID);
				int needed = products.get(productID);
				// If the warehouse doesn't have this product
				if(ours<=0){
					offers.add(new PurchaseOffer(this, new ProductBulk(productID, needed)))
				} else if (ours<needed){
					delta.put(productID, -1);
					offers.add(new PurchaseOffer(this, new ProductBulk(productID, needed-ours)))
				} else {
					delta.put(productID, ours-needed);
				}
					
			}
		}
		
		// Sell offers
		for(Integer productID : delta.keySet()){
			int ours = delta.get(productID);
			if(ours > 0){
				offers.add(new SellOffer(this, new ProductBulk(productID, ours)))
			}
		}
	}

}
