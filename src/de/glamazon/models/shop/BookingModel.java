package de.glamazon.models.shop;

import de.glamazon.pojo.Booking;

public class BookingModel {
	private Booking booking;
	
	public BookingModel(Booking booking) {
		this.setBooking(booking);
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
}
