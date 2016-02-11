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

}
