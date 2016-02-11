package warehouse;

import drone.IDrone;

public interface IMarket {

	/**
	 * Perform Merchandise exchange with another warehouse, 
	 * depending on what that other warehouse needs and available drones
	 * @param d drone
	 */
	void tradeAllYouCan();

}
