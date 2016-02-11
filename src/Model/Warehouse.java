package Model;

import java.util.ArrayList;
import java.util.HashMap;

import drone.IDrone;
import warehouse.IMarket;

public class Warehouse extends Destination implements IMarket {

	private int posX = -1;
	private int posY = -1;
	private HashMap<Integer, Integer> products = new HashMap<Integer, Integer>();
	private ArrayList<Order> orders = new ArrayList<Order>();

	public Warehouse(int posX, int posY, HashMap<Integer, Integer> products) {
		setPosX(posX);
		setPosY(posY);
		setProducts(products);
	}

	public HashMap<Integer, Integer> getProducts() {
		return products;
	}

	public void setProducts(HashMap<Integer, Integer> products) {
		this.products = products;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}

	@Override
	public void decideAndTransferProductsForDrone(IDrone d) {
		// TODO Auto-generated method stub
		
	}

}
