import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import Model.Drone;
import Model.Environment;
import Model.Order;
import Model.Warehouse;

public class Parser {

	private static String path = "C:/Users/Michael/Downloads/busy_day.in";

	public static void parse() {
		try {
			File file = new File(path);
			Scanner scanner = new Scanner(file);
			int amountOfLines = 0;
			int amountOfDrones = -1;
			while (scanner.hasNextLine()) {
				String[] line = scanner.nextLine().split("\\s+");
				int amountOfWarehouses = -1;
				int amountOfOrders = -1;

				if (amountOfLines == 0) {
					if (line.length != 5) {
						System.out.println("THIS SHOULD NOT HAPPEN THIS IS THE FIRST LINE AND MUST HAVE 5 WORDS");
					} else {
						Environment.ROWS = Integer.parseInt(line[0]);
						Environment.COLUMNS = Integer.parseInt(line[1]);
						amountOfDrones = Integer.parseInt(line[2]);
						Environment.TURNS = Integer.parseInt(line[3]);
						Environment.PAYLOAD = Integer.parseInt(line[4]);
					}
				} else if (amountOfLines == 1) {
					// Do nothing
				} else if (amountOfLines == 2) {
					int id = 0;
					for (String weight : line) {
						Environment.PRODUCT.put(id, Integer.parseInt(weight));
						id++;
					}
				} else if (amountOfLines == 3) {
					amountOfWarehouses = Integer.parseInt(line[0]);
					for (int i = 0; i < amountOfWarehouses; i++) {
						String[] warehousePosition = scanner.nextLine().split("\\s+");
						int posX = Integer.parseInt(warehousePosition[0]);
						int posY = Integer.parseInt(warehousePosition[1]);
						String[] warehouseProducts = scanner.nextLine().split("\\s+");
						HashMap<Integer, Integer> products = new HashMap<Integer, Integer>();
						int id = 0;
						for (String product : warehouseProducts) {
							products.put(id, Integer.parseInt(product));
							id++;
						}
						Warehouse w = new Warehouse(posX, posY, products);
						Environment.WAREHOUSES.add(w);
						if (i == 0) {
							//Parse Drones with known Warehouse 0 Position
							for (int a = 0; a < amountOfDrones; a++) {
								Drone d = new Drone(w);
								Environment.DRONES.add(d);
								w.addDrone(d);
							}
						}
					}
				} else {
					amountOfOrders = Integer.parseInt(line[0]);
					for (int i = 0; i < amountOfOrders; i++) {
						String[] orderPosition = scanner.nextLine().split("\\s+");
						int posX = Integer.parseInt(orderPosition[0]);
						int posY = Integer.parseInt(orderPosition[1]);
						scanner.nextLine().split("\\s+"); // skip
						String[] products = scanner.nextLine().split("\\s+");
						HashMap<Integer, Integer> productsHashMap = new HashMap<Integer, Integer>();
						int totalWeight = 0;
						for (String product : products) {
							int id = Integer.parseInt(product);
							if (productsHashMap.containsKey(id)) {
								productsHashMap.put(id, productsHashMap.get(id) + 1);
							} else {
								productsHashMap.put(id, 1);
							}
							totalWeight += Environment.PRODUCT.get(id);
						}
						Environment.ORDERS.add(new Order(posX, posY, totalWeight, productsHashMap));
					}
				}
				amountOfLines++;
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}