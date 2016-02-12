package drone;

import Model.Destination;
import Model.IWarehouse;
import Model.Order;
import Model.Warehouse;

public interface IDrone {
	
	public boolean isAtWarehouse();
	public boolean isAtOrder();
	public Warehouse getWarehouse();
	public Order getOrder();
	public IWarehouse getClosestWarehouseThatNeedsEmptyDrones();
	
	/**
	 * Set a drone to go to the destination
	 * The destination is NOT warned a drone is incoming
	 * @param w
	 */
	public void go(Destination w);
	
	public void loadAndGo(Destination w, ICargo c);
	
	/**
	 * Unload the cargo at destination
	 * @param c
	 */
	public void unload(ICargo c);
	
	/**
	 * Unload all cargo
	 */
	public void unloadAll();
	
	/**
	 * Perform turn, store in environment the warehouses which have received a new drone
	 */
	public void performTurn();
	
	/**
	 * 
	 * @return closest Warehouse that has products to transfer to other warehouse
	 */
	public Warehouse getClosestWarehouseThatCanTrade();
	
	public void waitTurn();

}
