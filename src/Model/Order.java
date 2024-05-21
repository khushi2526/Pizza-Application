package Model;

import java.util.List;

public class Order {
	private PizzaSize size;
	private CrustType crust;
	private List<Toppings> toppings;
	private int quantity;
	
	public Order(PizzaSize size, CrustType crust, List<Toppings> toppings, int quantity) {
		this.size = size;
		this.crust = crust;
		this.toppings = toppings;
		this.quantity = quantity;
	}
	
	public PizzaSize getPizzaSize() {
		return size;
	}
	
	public CrustType getCrustType() {
		return crust;
	}
	
	public List<Toppings> getToppings() {
		return toppings;
	}
	
	public int getQuantity() {
		return quantity;
	}
}
