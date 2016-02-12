package tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class AdvancedProductDealer {

	private ArrayList<ProductBulk> prods = new ArrayList<ProductBulk>();
	
	public AdvancedProductDealer(HashMap<Integer, Integer> products){
		for(Integer productID : products.keySet()){
			prods.add(new ProductBulk(productID, products.get(productID)));
		}
		// Assume sorted from highest weight to lowest
		Collections.sort(prods);
	}
	
	public ProductBulk dealBestProductBulk(int maxWeight){
		int top = prods.size();
		int bot = 0;
		int splitterIndex = prods.size()/2;
		int splitter = prods.get(splitterIndex).productWeight;
		boolean found = false;
		while(!found){
			if(splitter > maxWeight){
				top = splitterIndex;
				splitterIndex = (top-bot)/2;
				splitter = prods.get(splitterIndex).productWeight;
			} else if(splitter == maxWeight) {
				return dealProductBulk(splitterIndex, maxWeight);
			} else{
				bot = splitterIndex;
				splitterIndex = (top-bot)/2;
				//TODO
			}
		}
		return null;
	}

	private ProductBulk dealProductBulk(int splitterIndex, int maxWeight) {
		return null;
	}
}
