package tools;

/**
 * Interface for classes that help make cargoes for drones
 * Typically, dealers are instanciated with a HashMap of products, 
 * and they need to "fit" all that into a given cargo space
 * @author Cyril
 *
 */

public interface ProductDealer {

	/**
	 * Returns best product bulk that can fit remaining space, remove it from the list of deals
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