package Model;

import java.util.HashMap;

import drone.IDrone;

public class Order extends Destination implements Comparable<Order>{

	private int posX = -1;
	private int posY = -1;
	private Warehouse warehouse;
	
	private HashMap<Integer, Integer> products = new HashMap<Integer, Integer>();
	private int rating = Integer.MAX_VALUE;

	public Order(int posX, int posY,int totalWeight, HashMap<Integer, Integer> products) {
		super(posX, posY, totalWeight, products);
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

	@Override
	public void notifyIncomingDrone(IDrone d) {
		
	}

	@Override
	public void notifyLeavingDrone(IDrone d) {
		
	}
}
