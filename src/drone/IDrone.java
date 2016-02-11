package drone;

import Model.Destination;
import Model.Order;
import Model.Warehouse;

public interface IDrone {
	
	public boolean isAtWarehouse();
	public boolean isAtOrder();
	public Warehouse getWarehouse();
	public Order getOrder();
	public Destination getClosestWarehouseThatNeedsEmptyDrones();
	
	/**
	 * Set a drone to go to the destination
	 * The destination is NOT warned a drone is incoming
	 * @param w
	 */
	public void go(Destination w);
	public void go(Order w);
	
	/**
	 * Perform turn, store in environment the warehouses which have received a new drone
	 */
	public void performTurn();
	
	/**
	 * Drone decides : either at an order and need to go to closest warehouse
	 * OR at a warehouse but cannot fill any order, then needs to trade !
	 */
	public void decideAndGoSomewhere();

}
