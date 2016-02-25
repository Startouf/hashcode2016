package warehouse;

import java.util.List;

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
	public List<IDrone> getFreeDrones();
	
	/**
	 * Update Warehouses knowing drones have arrived
	 * * Update products received
	 * * Update canFillOrder
	 * * Update needsDrones
	 */
	public void update();

	/**
	 * Notifies that a drone is incoming
	 * @param d
	 */
	public void notifyIncomingDrone(IDrone d);
	
	
	
}
