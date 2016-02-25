package tools;

import java.util.ArrayList;
import java.util.HashMap;

import drone.Cargo;
import drone.ICargo;
import warehouse.SellOffer;

public class Fitting {

	public static ArrayList<ICargo> createCargoesFrom(HashMap<Integer, Integer> products) {
		ArrayList<ICargo> cargoes = new ArrayList<ICargo>();
		ProductDealer d = new SimpleProductDealer(products);
		while(d.hasProducts()){
			Cargo c = new Cargo();
			ProductBulk b = d.dealBestProductBulk(c.getFreeSpace());
			do{
				b = d.dealBestProductBulk(c.getFreeSpace());
			} while(b != null);
			cargoes.add(c);
		}
		return cargoes;
	}

	public static Object createCargoesFrom(ArrayList<SellOffer> sellOffers) {
		ArrayList<ICargo> cargoes = new ArrayList<ICargo>();
		ProductDealer d = new SimpleProductDealer(sellOffers);
		while(d.hasProducts()){
			Cargo c = new Cargo();
			ProductBulk b = d.dealBestProductBulk(c.getFreeSpace());
			do{
				b = d.dealBestProductBulk(c.getFreeSpace());
			} while(b != null);
			cargoes.add(c);
		}
		return cargoes;
	}

}
