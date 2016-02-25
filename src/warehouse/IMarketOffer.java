package warehouse;

import Model.Destination;

public interface IMarketOffer {
	
	public Destination getDestination();
	public int getDistanceTo(Destination d);

}
