package tools;

import java.util.ArrayList;

import warehouse.IMarketOffer;
import warehouse.IWarehouse;
import warehouse.PurchaseOffer;
import warehouse.SellOffer;

public class MarketMatcher{

	private ArrayList<PurchaseOffer> buys = new ArrayList<PurchaseOffer>();
	private ArrayList<SellOffer> sells = new ArrayList<SellOffer>();
	
	public MarketMatcher(ArrayList<IMarketOffer> deals){
		buys.ensureCapacity(deals.size());
		sells.ensureCapacity(deals.size());
		for(IMarketOffer deal : deals){
			if(deal instanceof SellOffer){
				sells.add((SellOffer) deal);
			} else{
				buys.add((PurchaseOffer) deal);
			}
		}
	}
	
	public static ArrayList<IMarketOffer> getBestMarketMatchesFor(IWarehouse w){
		w.get
	}

}
