package Model;

import java.util.ArrayList;
import java.util.List;

import drone.Cargo;
import drone.ICargo;
import drone.IDrone;
import tools.Distance;
import tools.Todo;

public class Drone implements IDrone {

	private boolean doingSomething = false;
	private int turnsImmobilized = 0;
	private Destination currentDestination;
	private ICargo cargo;

	public Drone(Destination d) {
		this.currentDestination = d;
	}

	@Override
	public boolean isAtWarehouse() {
		return (this.currentDestination instanceof Warehouse);
	}

	@Override
	public boolean isAtOrder() {
		return (currentDestination instanceof Order);
	}

	@Override
	public Warehouse getWarehouse() {
		return (Warehouse) this.currentDestination;
	}

	@Override
	public Order getOrder() {
		return (Order)currentDestination;
	}

	@Override
	public IWarehouse getClosestWarehouseThatNeedsEmptyDrones() {
		return Environment.getRandomWarehouse();
	}

	@Override
	public void go(Destination w) {
		int t = Distance.calculateDistance(this.currentDestination, w);
		this.doingSomething = true;
		this.turnsImmobilized = t;
		currentDestination.notifyLeavingDrone(this);
		w.notifyIncomingDrone(this);
		this.currentDestination = w;
	}

	@Override
	public void performTurn() {
		if(doingSomething){
			if(turnsImmobilized ==0){
				
				// Unload all cargo by default!
				if(cargo != null){
					unloadAll();
				} else{
					this.doingSomething = false;
				}
			}
			this.turnsImmobilized--;
		}
	}

	@Override
	public Warehouse getClosestWarehouseThatCanTrade() {
		List<Warehouse> wT = Environment.getWarehousesThatCanTrade();
		return (Warehouse) Distance.getShortestDestination(this.currentDestination, wT);
	}

	@Override
	public void waitTurn() {
		// :-)
	}

	@Override
	public void loadAndGo(Destination w, ICargo c) {
		this.cargo = c;
		go(w);
		//Need extra turn to load cargo
		turnsImmobilized++;
	}

	@Override
	public void unload(ICargo c) {
		Todo.crash("implement unloading part of cargo");
	}

	@Override
	public void unloadAll() {
		// TODO Auto-generated method stub
		currentDestination.receiveCargoNextTurn(cargo);
		this.doingSomething = true;
		this.turnsImmobilized++;
		this.cargo = null;
		
	}

}
