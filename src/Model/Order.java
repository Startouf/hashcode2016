package Model;

import java.util.HashMap;

import drone.IDrone;
import warehouse.Warehouse;

public class Order extends Destination implements Comparable<Order>{

	private static int nextID = 0;
	
	private final int ID;
	private Warehouse warehouse;
	
	private HashMap<Integer, Integer> products = new HashMap<Integer, Integer>();
	private int rating = Integer.MAX_VALUE;

	public Order(int posX, int posY,int totalWeight, HashMap<Integer, Integer> products) {
		super(posX, posY, totalWeight, products);
		this.ID = nextID;
		nextID++;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public HashMap<Integer, Integer> getProducts() {
		return products;
	}

	public void setProducts(HashMap<Integer, Integer> products) {
		this.products = products;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public int compareTo(Order o) {
		return (this.rating - o.rating);
	}
	
	public int getID(){
		return this.ID;
	}

	@Override
	public void notifyIncomingDrone(IDrone d) {
	}

	@Override
	public void notifyLeavingDrone(IDrone d) {
	}
}
