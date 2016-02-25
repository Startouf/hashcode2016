package warehouse;

import java.util.List;

import Model.Destination;

public interface IMarket {
	
	/**
	 * Post all possible market offers and returns list of available offers
	 */
	public void postMarketOffers();
	
	/**
	 * 
	 * @return list of Purchase MarketOffer
	 */
	public List<IMarketOffer> getPostedBuys();
	
	/**
	 * 
	 * @return list of Sell MarketOffers
	 */
	public List<IMarketOffer> getPostedSells();
	
	

	/**
	 * Perform Merchandise exchange with another warehouse, 
	 * @param d drone
	 * depending on what that other warehouse needs and available drones
	 */
	public void tradewith(Destination d, SellOffer ownDeal);

}
