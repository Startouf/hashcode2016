package drone;

import java.util.ArrayList;
import java.util.HashMap;

import tools.Fitting;
import tools.ProductBulk;

public interface ICargo {

	public int getFreeSpace();
	
	/**
	 * Fir productBulk to cargo
	 * @param b
	 * @throws NotEnoughRoomException
	 */
	public void fitProductBulk(ProductBulk b) throws NotEnoughRoomException;
	
	public void unloadAll();
	
	/**
	 * Unload specific cargo
	 * @param c
	 */
	public void unload(Cargo c) throws DoNotPossessCargoException;
	
	public static ArrayList<ICargo> createCargoesFrom(HashMap<Integer, Integer> products){
		return Fitting.createCargoesFrom(products);
	}
}
