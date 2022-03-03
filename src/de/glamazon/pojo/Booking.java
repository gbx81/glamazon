package de.glamazon.pojo;

public class Booking {
	private int id;
	private ShoppingCart cart;
	private Customer customer;
		
	public Booking(ShoppingCart cart, Customer customer) {
		this.setId(0);
		this.setCart(cart);
		this.setCustomer(customer);
	}
	
	public Booking(int id, ShoppingCart cart, Customer customer) {
		this.setId(id);
		this.setCart(cart);
		this.setCustomer(customer);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "Booking ID: " + this.getId() + System.lineSeparator() + 
				customer.toString() + System.lineSeparator() + 
				cart.toString()
		;
	}
}
