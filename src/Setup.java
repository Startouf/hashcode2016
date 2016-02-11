import java.util.ArrayList;

import Model.Destination;
import Model.Order;
import Model.Warehouse;

public class Setup {

	public static void assignWarehousesToOrders(ArrayList<Warehouse> warehouses, ArrayList<Order> orders) {
		for (Order order : orders) {
			Destination nearestWarehouse = null;
			int distanceToNearestWarehouse = Integer.MAX_VALUE;
			for (Destination warehouse : warehouses) {
				int distance = (int) Math.ceil(Math.sqrt(Math.pow(Math.abs(order.getPosX() - warehouse.getPosX()),2) + Math.pow(Math.abs(order.getPosY() - warehouse.getPosY()),2)));
				if (distance < distanceToNearestWarehouse) {
					nearestWarehouse = warehouse;
					distanceToNearestWarehouse = distance;
				}
			}
			if (nearestWarehouse != null) {
				order.setWarehouse(nearestWarehouse);
			} else {
				System.out.println("No warehoues in input - this should not happen");
			}
		}
	}	
}
