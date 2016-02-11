package Model;

import drone.IDrone;

public class Drone implements IDrone {

	private int posX = -1;
	private int posY = -1;
	private boolean doingSomething = false;
	private int turnsImmobilized = 0;

	public Drone(int posX, int posY) {
		this.setPosX(posX);
		this.setPosY(posY);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public boolean isAtWarehouse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAtOrder() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Warehouse getWarehouse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Destination getClosestWarehouseThatNeedsEmptyDrones() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void go(Destination w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void go(Order w) {
		// TODO Auto-generated method stub
		
	}

}
