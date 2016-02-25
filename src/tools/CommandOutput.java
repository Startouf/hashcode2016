package tools;

import Model.Destination;
import drone.Drone;

/**
 * Class responsible for writing the output class
 * @author Cyril
 *
 */

public class CommandOutput {
	
	private static void writeOutput(String[] commandArgs){
		String out = new String();
		for(String s : commandArgs){
			out += (s+" ");
		}
		// TODO
		
	}
	
	public static void load(Drone d, Destination dest, ProductBulk b){
		loadOrUnload(d, "L", dest, b);
	}
	
	public static void unload(Drone d, Destination dest, ProductBulk b){
		loadOrUnload(d, "U", dest, b);
	}
	
	private static void loadOrUnload(Drone d, String command, Destination dest, ProductBulk b){
		loadOrUnload(d.getID(), command, dest.getID(), b.productID, b.quantity);
	}
	
	private static void loadOrUnload(int droneID, String command, int warehouseID, int productID, int quantity){
		writeOutput(new String[] {
				Integer.toString(droneID),
				command, 
				Integer.toString(warehouseID),
				Integer.toString(productID),
				Integer.toString(quantity)
			});
	}
}
