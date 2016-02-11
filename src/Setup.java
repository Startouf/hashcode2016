import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Model.Environment;
import Model.Order;
import Model.Warehouse;

public class Setup {

	public static void assignWarehousesToOrders(ArrayList<Warehouse> warehouses, ArrayList<Order> orders) {
		for (Order order : orders) {
			Warehouse nearestWarehouse = null;
			int distanceToNearestWarehouse = Integer.MAX_VALUE;
			for (Warehouse warehouse : warehouses) {
				int distance = calculateDistance(warehouse.getPosX(), warehouse.getPosY(), order.getPosX(),
						order.getPosY());
				if (distance < distanceToNearestWarehouse) {
					nearestWarehouse = warehouse;
					distanceToNearestWarehouse = distance;
				}
			}
			if (nearestWarehouse != null) {
				order.setWarehouse(nearestWarehouse);
				nearestWarehouse.addOrder(order);
			} else {
				System.out.println("No warehoues in input - this should not happen");
			}
		}
	}

	public static int calculateDistance(int posX1, int posY1, int posX2, int posY2) {
		return (int) Math.ceil(Math.sqrt(Math.pow(Math.abs(posX1 - posX2), 2) + Math.pow(Math.abs(posY1 - posY2), 2)));
	}

	public static void sortOrders(Warehouse warehouse) {
		for (Order order : warehouse.getOrders()) {
			order.setRating(
					calculateDistance(order.getPosX(), order.getPosY(), warehouse.getPosX(), warehouse.getPosY())
							* order.getTotalWeight() / Environment.PAYLOAD);
		}

		Collections.sort(warehouse.getOrders(), new Comparator<Order>() {
			@Override
			public int compare(Order order1, Order order2) {
				return ((order1.getRating() < order2.getRating()) ? -1
						: ((order1.getRating() == order2.getRating()) ? 0 : 1));
			}
		});
	}
}
