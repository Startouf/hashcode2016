package warehouse;

import drone.IDrone;

public interface IMarket {

	/**
	 * Given a drone, perform a merchandise exchange with another warehouse, 
	 * depending on what that other warehouse needs
	 * @param d drone
	 */
	void decideAndTransferProductsForDrone(IDrone d);

}
