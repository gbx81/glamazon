package de.glamazon.pojo;

import java.util.ArrayList;
import java.util.List;


public class Article {
	private int id;
	private String title;
	private int stock;
	private double price;
	private List<Category> categories;
	private String description;
	private String artnum;
	private byte[] image;
	
	public Article() {
		this.setCategories(new ArrayList<Category>());
	}
	
	public Article(int id, String title, int stock, double price, ArrayList<Category> categories, String description, byte[] image) {
		this.setId(id);
		this.setTitle(title);
		this.setStock(stock);
		this.setPrice(price);
		this.setCategories(categories);
		this.setDescription(description);
		this.setImage(image);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
		
	public String getArtnum() {
		return artnum;
	}

	public void setArtnum(String artnum) {
		this.artnum = artnum;
	}
	
	public void addCategory(Category category) {
		this.categories.add(category);
	}
	
	public void removeCategory(Category category) {
		this.categories.remove(category);
	}

	@Override
	public String toString() {
		String cats = "{ ";
		for (int i = 0; i < this.getCategories().size();i++) {
			cats += this.getCategories().get(i).getTitle();
			if(i < this.getCategories().size() - 1) {
				cats += ", ";
			}
		}
		cats += " }";
		return "ID: " + this.getId() + "; " 
				+ "Title: " + this.getTitle() + "; " 
				+ "Stock: " + this.getStock() + "; " 
				+ "Price: " + this.getPrice() + "; " 
				+ "Categories: " + cats + "; "
				+ "Description: " + this.getDescription() + "; ";
	}
	
	public boolean equals(Article article) {
		return this.getId() == article.getId() && 
				this.getPrice() == article.getPrice();
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}

