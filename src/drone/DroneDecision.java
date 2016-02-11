package drone;

import Model.Order;
import warehouse.IMarket;

public class DroneDecision {
	
	public void decideAndSendDroneToWarehouse(IDrone d){
		
		if (d.isAtWarehouse()){
			IMarket w = (IMarket) d.getWarehouse();
			w.decideAndTransferProductsForDrone(d);
			
		} else{
			Order o = d.getOrder();
			d.go(d.getClosestWarehouseThatNeedsEmptyDrones());
		}
		
	}

}
