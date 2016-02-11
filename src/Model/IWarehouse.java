package Model;

import java.util.ArrayList;

import drone.IDrone;

public interface IWarehouse {

	/**
	 * Fill all possible orders given the available drones
	 */
	public void fillOrdersWithAvailableDrones();
	
	/**
	 * Returns list of drones currently without actions
	 * @return
	 */
	public ArrayList<IDrone> getFreeDrones();
	
	/**
	 * Update Warehouses knowing drones have arrived
	 * * Update products received
	 * * Update canFillOrder
	 * * Update needsDrones
	 */
	public void update();
	
	/**
	 * Knowing that a drone d is incoming, perform appropriate changes
	 * (add to list of arriving drones, etc.)
	 */
	public void notifyIncomingDrone(IDrone d);
	
}
