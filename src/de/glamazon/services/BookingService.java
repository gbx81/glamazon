package de.glamazon.services;

import java.sql.SQLException;

import de.glamazon.pojo.Booking;
import de.glamazon.pojo.Customer;
import de.glamazon.pojo.ShoppingCart;

public final class BookingService extends Services {
	
	public Booking checkout(Booking booking) throws SQLException {
		ShoppingCart cart = booking.getCart();
		Customer customer = booking.getCustomer();
		int bookingId;
		if(cart != null && customer != null && cart.getCart().size() > 0) {
			CustomerService cs = new CustomerService();
			if(cs.addCustomer(customer).getId() != 0) {
				ShoppingCartService scs = new ShoppingCartService();
				int cartID = scs.addShoppingCart(cart);
				if(cartID > 0) {
					bookingId = super.dbm.nocommitInsert(
							"Booking", 
							new String[]{"CustomerID","ShoppingCartID"}, 
							new String[] {String.valueOf(customer.getId()),String.valueOf(cartID)}
					);
					if(bookingId > 0) {
						booking.setId(bookingId);
					}
				}
			}
		}
		if(booking.getId() > 0) {
			super.dbm.commit();
		}
		else {
			super.dbm.rollback();
		}
		return booking;
	}
}
