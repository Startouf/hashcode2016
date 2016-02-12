package warehouse;

import java.util.List;

import tools.ProductBulk;

public interface IMarket {
	
	/**
	 * 
	 * @return a list of lists of product bulks needed to fill orders
	 */
	List<IMarketOffer> postMarketOffers();

	/**
	 * Perform Merchandise exchange with another warehouse, 
	 * depending on what that other warehouse needs and available drones
	 * @param d drone
	 */
	void tradeAllYouCan();

}
