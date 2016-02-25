package tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import warehouse.SellOffer;

public class SimpleProductDealer implements ProductDealer {
private ArrayList<ProductBulk> prods = new ArrayList<ProductBulk>();
	
	public SimpleProductDealer(HashMap<Integer, Integer> products){
		for(Integer productID : products.keySet()){
			prods.add(new ProductBulk(productID, products.get(productID)));
		}
		// Assume sorted from highest weight to lowest
		Collections.sort(prods);
	}
	
	public SimpleProductDealer(ArrayList<SellOffer> sellOffers) {
		this(sellOffersToHash(sellOffers));
	}

	private static HashMap<Integer, Integer> sellOffersToHash(ArrayList<SellOffer> sellOffers) {
		HashMap<Integer, Integer> products = new HashMap<Integer, Integer>();
		for(SellOffer s : sellOffers){
			int pID = s.getProducts().productID;
			int qty = s.getProducts().quantity;
			products.put(pID, products.getOrDefault(pID, 0)+qty);
		}
		return products;
	}

	/* (non-Javadoc)
	 * @see tools.ProductDealer#dealBestProductBulk(int)
	 */
	@Override
	public ProductBulk dealBestProductBulk(int maxWeight){
		Iterator<ProductBulk> iter = prods.iterator();
		while(iter.hasNext()){
			ProductBulk b = iter.next();
			if(b.productWeight<=maxWeight){
				int count = maxWeight/b.productWeight;
				if(b.noMoreAfterRemoving(count)){
					iter.remove();
					/// OMG is Iterator magic or is a problem happening here ?
					return b;
				}
				return new ProductBulk(b.productID, count);
			}
		}
		return null;
	}

	@Override
	public boolean hasProducts() {
		return !prods.isEmpty();
	}
}