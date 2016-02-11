package Model;

import java.util.ArrayList;

public class Order {

	private int posX = -1;
	private int posY = -1;
	private ArrayList<Product> products = new ArrayList<Product>();
	private Destination warehouse;

	public Order(int posX, int posY, ArrayList<Product> products, Destination warehouse) {
		setPosX(posX);
		setPosY(posY);
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

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public Destination getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Destination warehouse) {
		this.warehouse = warehouse;
	}

}
