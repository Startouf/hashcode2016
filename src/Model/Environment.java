package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

import drone.Drone;
import drone.IDrone;
import warehouse.IWarehouse;
import warehouse.Warehouse;

public class Environment {
	public static int ROWS = -1;
	public static int COLUMNS = -1;
	public static int TURNS = -1;
	public static int PAYLOAD = -1;
	public static Random r;
	
	public static ArrayList<Order> ORDERS = new ArrayList<Order>();
	public static ArrayList<Drone> DRONES = new ArrayList<Drone>();
	public static ArrayList<Warehouse> WAREHOUSES = new ArrayList<Warehouse>();
	public static HashMap<Integer,Integer> PRODUCT = new HashMap<Integer,Integer>();
	
	public static ArrayList<IDrone> getAllFreeDrones() {
		// TODO Auto-generated method stub
		return null;
	}
	public static ArrayList<Warehouse> getWarehousesWithDrones() {
		// TODO Auto-generated method stub
		return null;
	}
	public static ArrayList<Warehouse> getAllWarehouses() {
		return WAREHOUSES;
	}
	
	/**
	 * 
	 * @param productID
	 * @return weightOfProduct
	 */
	public static int getWeight(int productID){
		return PRODUCT.get(productID);
	}
	
	public static IWarehouse getRandomWarehouse(){
		return WAREHOUSES.get(r.nextInt(WAREHOUSES.size()));
	}
	public static ArrayList<Warehouse> getWarehousesThatCanTrade() {
		ArrayList<Warehouse> wT = new ArrayList(WAREHOUSES);
		Collections.shuffle(wT);
		return (ArrayList<Warehouse>) wT.subList(0, wT.size()/3);
	}
	public static ArrayList<Drone> getAllDrones() {
		return DRONES;
	}
}
