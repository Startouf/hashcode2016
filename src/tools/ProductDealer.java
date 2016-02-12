package tools;

public interface ProductDealer {

	/**
	 * Returns best product bulk that can fit remaining space
	 * @param maxWeight
	 * @return
	 */
	ProductBulk dealBestProductBulk(int maxWeight);
	
	/**
	 * Still products to fit ?
	 * @return
	 */
	boolean hasProducts();

}