package Model;

import java.util.ArrayList;
<<<<<<< HEAD
import java.util.HashMap;
=======

import drone.IDrone;

public class Environment {
	public static int ROWS = -1;
	public static int COLUMNS = -1;
	public static int TURNS = -1;
	public static int PAYLOAD = -1;
	
	public static ArrayList<Order> ORDERS = new ArrayList<Order>();
	public static ArrayList<Drone> DRONES = new ArrayList<Drone>();
	public static ArrayList<Warehouse> WAREHOUSES = new ArrayList<Warehouse>();
	public static HashMap<Integer,Integer> PRODUCT = new HashMap<Integer,Integer>();
	
	public static ArrayList<IDrone> getAllDrones() {
		// TODO Auto-generated method stub
		return null;
	}
	public static ArrayList<IDrone> getAllFreeDrones() {
		// TODO Auto-generated method stub
		return null;
	}
	public static ArrayList<Warehouse> getWarehousesWithDrones() {
		// TODO Auto-generated method stub
		return null;
	}
	public static ArrayList<Warehouse> getAllWarehouses() {
		// TODO Auto-generated method stub
		return null;
	}
}
