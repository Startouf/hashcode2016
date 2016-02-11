package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {

	private int posX = -1;
	private int posY = -1;
	private Warehouse warehouse;
	private int totalWeight = -1;
	private HashMap<Integer, Integer> products = new HashMap<Integer, Integer>();
	
	/* Code for parsin
	 * totalWeight += product.getWeight();
				int amountOfProducts = 0;
				if (products.containsKey(product.getId())) {
					amountOfProducts = products.get(product.getId());
				}
				products.put(product.getId(), amountOfProducts + 1);
	 * 
	 * 
	 */

	public Order(int posX, int posY, int totalWeight, HashMap<Integer,Integer> products, Warehouse warehouse) {
		setPosX(posX);
		setPosY(posY);
		setTotalWeight(totalWeight);
		setProducts(products);
		setWarehouse(warehouse);
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

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public int getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(int totalWeight) {
		this.totalWeight = totalWeight;
	}

	public HashMap<Integer, Integer> getProducts() {
		return products;
	}

	public void setProducts(HashMap<Integer, Integer> products) {
		this.products = products;
	}
}
