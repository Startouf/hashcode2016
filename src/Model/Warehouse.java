package Model;

import java.util.ArrayList;

import drone.IDrone;
import warehouse.IMarket;

public class Warehouse extends Destination implements IMarket {

	private ArrayList<Product> products = new ArrayList<Product>();

	public Warehouse(int posX, int posY, ArrayList<Product> products) {
		setPosX(posX);
		setPosY(posY);
		setProducts(products);
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	@Override
	public void decideAndTransferProductsForDrone(IDrone d) {
		// TODO Auto-generated method stub
		
	}

}
