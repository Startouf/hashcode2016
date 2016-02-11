package Model;

public class Product {
	private int id = -1;
	private int weight = -1;

	public Product(int id, int weight) {
		setId(id);
		setId(weight);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
