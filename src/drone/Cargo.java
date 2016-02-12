package drone;

import java.util.ArrayList;

import Model.Environment;
import tools.ProductBulk;

public class Cargo implements ICargo{
	
	private int space = Environment.PAYLOAD;
	private ArrayList<ProductBulk> products;
	
	public Cargo(){
	}

	@Override
	public void fitProductBulk(ProductBulk b) throws NotEnoughRoomException {
		products.add(b);
		int delta = b.productWeight*b.quantity;
		if((space-delta)<0)
			throw new NotEnoughRoomException();
		space -= delta;
	}

	@Override
	public void unloadAll() {
		this.products.clear();
	}

	@Override
	public void unload(Cargo c) throws DoNotPossessCargoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFreeSpace() {
		return space;
	}

}
