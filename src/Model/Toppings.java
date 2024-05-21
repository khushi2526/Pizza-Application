package Model;

public enum Toppings {
	EXTRA_CHEESE(1.10),
	TOMATOES(1.10),
	JALAPENO(1.10),
	GREEN_PAPER(1.10),
	ROASTED_GARLIC(1.10);

	private double price;
	
	Toppings(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}
}
