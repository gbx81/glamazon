package de.glamazon.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton Class that can only be accessed by getInstance() method. 
 * Will create an object of itself on first invocation of getInstance().
 * 
 * @author Gernot Brixler
 *
 */

public final class ShoppingCart {
	private int id;
	private static ShoppingCart instance = new ShoppingCart();
	private List<Article> cart;
	
	private ShoppingCart() {
		cart = new ArrayList<Article>();
	}
	
	public static ShoppingCart getInstance() {
		return instance;
	}
	
	public List<Article> getCart() {
		return cart;
	}

	public void setCart(List<Article> cart) {
		this.cart = cart;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void addArticle(Article article) {
		cart.add(article);
	}
	
	public Article getSingleArticleByIndex(int i) {
		return cart.get(i);
	}
	
	public void removeSingleArticle(Article article) {
		for (int i = 0; i < this.cart.size(); i++) {
			if(cart.get(i).equals(article)) {
				cart.remove(i);
				break;
			}
		}
	}
	
	public void removeAllOfArticle(Article article) {
		for (int i = 0; i < this.cart.size(); i++) {
			if(cart.get(i).equals(article)) {
				cart.remove(i);
				i=-1;
			}
		}
	}
	
	public void emptyCart() {
		cart.clear();
	}
	
	public int getSameArticleCount(Article article) {
		int counter = 0;
		for (Article cArticle : cart) {
			if(cArticle.equals(article)) {
				counter ++;
			}
		}
		return counter;
	}
	
	public double getTotalAmount() {
		double totalAmount = 0;
		for (Article article : cart) {
			totalAmount += article.getPrice();
		}
		return totalAmount;
	}
	
	@Override
	public String toString() {
		String str = "Artikel im Einkaufswagen:" + System.lineSeparator() + "-------------"+ System.lineSeparator();
		for (Article article : cart) {
			str += article.toString() + System.lineSeparator() + "-------------"+ System.lineSeparator();
		}
		return str;
	}
}
