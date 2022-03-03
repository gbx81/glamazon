package de.glamazon.models.shop;

import de.glamazon.pojo.Booking;
import de.glamazon.pojo.Customer;
import de.glamazon.pojo.ShoppingCart;

public class CheckoutModel {
	private ShoppingCart cart;
	private Customer customer;
	private Booking booking;
	
	public CheckoutModel() {
		this.setCart(ShoppingCart.getInstance());
		this.setCustomer(new Customer());
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

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
}
