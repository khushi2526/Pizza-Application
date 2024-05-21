package Model;

public enum PizzaSize {
	SMALL(7.00),
	MEDIUM(10.00),
	LARGE(13.00),
	EXTRA_LARGE(15.00);
	
	private double price;
	
	PizzaSize(double price) {
		this.setPrice(price);
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
