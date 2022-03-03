package de.glamazon.models.shop;

import de.glamazon.pojo.ShoppingCart;

public class ShoppingCartModel {
	private ShoppingCart cart;
	
	public ShoppingCartModel() {
		this.setCart(ShoppingCart.getInstance());
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
}
