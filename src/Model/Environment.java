package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class Environment {
	public static int ROWS = -1;
	public static int COLUMNS = -1;
	public static int TURNS = -1;
	public static int PAYLOAD = -1;
	public static ArrayList<Order> ORDERS = new ArrayList<Order>();
	public static ArrayList<Drone> DRONES = new ArrayList<Drone>();
	public static ArrayList<Warehouse> WAREHOUSES = new ArrayList<Warehouse>();
	public static HashMap<Integer,Integer> PRODUCT = new HashMap<Integer,Integer>();
}
