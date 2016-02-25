package warehouse;

import Model.Destination;
import Model.Environment;
import tools.ProductBulk;

/**
 * Modelises a market offer to exchange products
 * @author Cyril
 *
 */

public abstract class MarketOffer implements IMarketOffer {
	
	private Destination destination;
	private ProductBulk products;
	private final int dronesNeeded;

	public MarketOffer(Destination d, ProductBulk b){
		this.destination = d;
		this.products = b;
		this.dronesNeeded = (int)Math.ceil(((double)b.productWeight*(double)b.quantity)/(double)Environment.PAYLOAD);
	}
	
	public ProductBulk getProducts(){
		return products;
	}

}
