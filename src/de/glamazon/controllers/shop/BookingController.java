package de.glamazon.controllers.shop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import de.glamazon.models.shop.BookingModel;
import de.glamazon.views.shop.BookingView;
import de.glamazon.views.shop.LandingPageView;

public class BookingController {
	 private BookingModel bm;
	 private BookingView bv;
	 private JPanel ShopPanel;
	 
	 public BookingController(BookingModel bm, BookingView bv, JPanel shopPanel) {
		 this.setBm(bm);
		 this.setBv(bv);
		 this.setShopPanel(shopPanel);
		 
		 this.getBv().getBtnBack2Shop().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getShopPanel().remove(1);
				getShopPanel().add(new LandingPageView());
				getShopPanel().validate();
			}
			 
		 });
	 }

	public BookingModel getBm() {
		return bm;
	}

	public void setBm(BookingModel bm) {
		this.bm = bm;
	}

	public BookingView getBv() {
		return bv;
	}

	public void setBv(BookingView bv) {
		this.bv = bv;
	}

	public JPanel getShopPanel() {
		return ShopPanel;
	}

	public void setShopPanel(JPanel shopPanel) {
		ShopPanel = shopPanel;
	}
}
