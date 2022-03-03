package de.glamazon.pojo;

//import java.util.ArrayList;

public class Category {
	private int id;
	private String title;
	private String description;
	
	public Category() {
		super();
	}
	
	public Category(String title, String description) {
		this.setTitle(title);
		this.setDescription(description);
	}
	
	public Category(int id, String title, String description) {
		this.setTitle(title);
		this.setDescription(description);
		this.setId(id);
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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
//	public String toString() {
//		return "ID: " + this.getId() + "; " 
//				+ "Title: " + this.getTitle() + "; " 
//				+ "Description: " + this.getDescription() + ";"
//				;
//	}
	public String toString() {
		return this.getTitle();
	}
	
	public boolean equals(Category category) {
		return this.getId() == category.getId();
	}
//	public ArrayList<Article> getArticlesInCat(ArrayList<Article> allArticles) { // returns list of articles in category
//		ArrayList<Article> articlesInCategory = new ArrayList<Article>();
//		for(int i=0; i < allArticles.size(); i++) {
//			Article article = allArticles.get(i);
//			ArrayList<Category> categories = article.getCategories();
//			for(int j=0; j < categories.size(); j++) {
//				if(categories.get(j).equals(this)) {
//					articlesInCategory.add(article);
//					break;
//				}
//			}
//		}
//		return articlesInCategory;
//	}
}
