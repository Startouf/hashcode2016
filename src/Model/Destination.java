package Model;

import java.util.ArrayList;
import java.util.HashMap;

import drone.Cargo;
import drone.ICargo;
import drone.IDrone;

public abstract class Destination {

	private int posX = -1;
	private int posY = -1;
	private int totalWeight = -1;
	protected HashMap<Integer, Integer> products = new HashMap<Integer, Integer>();
	protected ArrayList<ICargo> cargoProcessedNextTurn = new ArrayList<ICargo>();

	public Destination(int posX, int posY, int totalWeight, HashMap<Integer, Integer> products) {
		setPosX(posX);
		setPosY(posY);
		setTotalWeight(totalWeight);
		setProducts(products);
	}
	
	public HashMap<Integer, Integer> getProducts() {
		return products;
	}

	public void setProducts(HashMap<Integer, Integer> products) {
		this.products = products;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public int getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(int totalWeight) {
		this.totalWeight = totalWeight;
	}
	
	/**
	 * Knowing that a drone d is incoming, perform appropriate changes
	 * (add to list of arriving drones, etc.)
	 */
	public abstract void notifyIncomingDrone(IDrone d);
	
	/**
	 * Notify warehouse a drone is leaving
	 * @param d
	 */
	public abstract void notifyLeavingDrone(IDrone d);

	/**
	 * Notifies destination that it will receive some cargo next turn
	 * @param c
	 */
	public void receiveCargoNextTurn(ICargo c){
		this.cargoProcessedNextTurn.add(c);
	}
	
	public void cargoReceived(){
		
	}
}