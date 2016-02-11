package drone;

import Model.Warehouse;

public class DroneDecision {
	
	public static void decideAndSendDroneToWarehouse(IDrone d){
		
		// First try to go to a closest warehouse that needs drones to deliver orders
		Warehouse w = d.getClosestWarehouseThatNeedsEmptyDrones();
		if(w != null){
			d.go(w);
			w.notifyIncomingDrone(d);
		}
		// If all orders filled, go to closest Warehouse that can trade
		else{
			w = d.getClosestWarehouseThatCanTrade();
			if(w != null){
				d.go(w);
				w.notifyIncomingDrone(d);
			} else{
				// Else if there is nothing to do : wait !!
				d.wait();
			}
		}
		
	}

}
