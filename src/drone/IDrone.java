package drone;

import Model.Order;
import Model.Warehouse;

public interface IDrone {
	
	public boolean isAtWarehouse();
	public boolean isAtOrder();
	public Warehouse getWarehouse();
	public Order getOrder();
	public Warehouse getClosestWarehouseThatNeedsEmptyDrones();
	public void go(Warehouse w);
	public void go(Order w);

}
