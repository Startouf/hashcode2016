package tools;

import Model.Environment;

public class ProductBulk implements Comparable<ProductBulk>{
	public int productID;
	public int quantity;
	public final int productWeight;
	
	public ProductBulk(int x, int y) {
		this.productID=x;this.quantity=y;
		this.productWeight = Environment.getWeight(x);
		}
	// depending on your use case, equals? hashCode?  More methods?
	@Override
	public int compareTo(ProductBulk o) {
		return productWeight-o.productWeight;
	}
	public boolean noMoreAfterRemoving(int count) {
		quantity -= count;
		if(quantity < 0){
			System.err.println("Ouch removing more products a ProductBulk has");
			System.exit(1);
		}
		return quantity == 0;
	}
}
