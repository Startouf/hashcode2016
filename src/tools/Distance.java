package tools;

import java.util.HashMap;
import java.util.List;

import Model.Destination;

public class Distance {
	
	private static HashMap<Destination, Destination> distances;
	
	public static double getDistance(Destination d, Destination p){
		
		
		return Math.sqrt(
				(d.getPosY()-p.getPosY())*(d.getPosY()-p.getPosY())
				+(d.getPosX()-p.getPosX())*(d.getPosX()-p.getPosX())
				);
		
	}
	
	/**
	 * Returns shortest destination amongst the list of dests
	 * Currently O(dst)
	 * @param start
	 * @param dst
	 * @return
	 */
	public static Destination getShortestDestination(Destination start, List<Destination> dst){
		double minCost = Double.MAX_VALUE;
		Destination minDest = null;
		double currentCost;
		for(Destination d : dst){
			currentCost = getDistance(start, d);
			if(currentCost < minCost){
				minCost = currentCost;
				minDest = d;
			}
		}
		return minDest;
	}

}
