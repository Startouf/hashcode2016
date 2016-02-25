import java.util.ArrayList;

import Model.Environment;
import drone.Drone;
import drone.DroneDecision;
import drone.IDrone;
import warehouse.Warehouse;

public class Solver {
	
	// TODO Setup the environment
	
	private ArrayList<Drone> allDrones;
	private ArrayList<Warehouse> allWarehouses;
	private int currentTurn = 0;
	private int totalTurns;
	
	public Solver(){
		allDrones = Environment.getAllDrones();
		allWarehouses = Environment.getAllWarehouses();
		totalTurns = Environment.TURNS;
	}
	
	public void solve(){
		while(currentTurn <= totalTurns){
			performDecisions();
			performTurn();
			
			currentTurn++;
		}
	}
	
	private void performDecisions(){
		
		//Fill Orders
		ArrayList<Warehouse> warehouses = Environment.getWarehousesWithDrones();
		for(Warehouse w : warehouses){
			w.fillOrdersWithAvailableDrones();
		}
		
		// Trade between Warehouses and send out remaining drones
		warehouses = Environment.getWarehousesWithDrones();
		for(Warehouse w : warehouses){
			w.tradeAllYouCan();
			for(IDrone d : w.getFreeDrones()){
				DroneDecision.decideAndSendDroneToWarehouse(d);
			}
		}
		
		// Send drones that are currently at Orders
		ArrayList<IDrone> freeDrones = Environment.getAllFreeDrones();
		for(IDrone d : freeDrones){
			DroneDecision.decideAndSendDroneToWarehouse(d);
		}
	}
	
	private void performTurn(){
		for(IDrone d : allDrones){
			d.performTurn();
		}
		ArrayList<Warehouse> warehousesWithChanges;
		for(Warehouse w : allWarehouses){
			// Update products received
			// Update canFillOrder
			// Update needsDrones
			w.update();
		}
	}

}
