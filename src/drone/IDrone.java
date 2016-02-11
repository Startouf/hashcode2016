package drone;

import Model.Destination;
import Model.Order;

public interface IDrone {
	
	public boolean isAtWarehouse();
	public boolean isAtOrder();
	public Destination getWarehouse();
	public Order getOrder();
	public Destination getClosestWarehouseThatNeedsEmptyDrones();
	public void go(Destination w);
	public void go(Order w);

}
