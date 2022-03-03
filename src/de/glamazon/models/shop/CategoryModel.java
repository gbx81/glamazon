package de.glamazon.models.shop;

import java.sql.SQLException;
import java.util.List;

import de.glamazon.pojo.Article;
import de.glamazon.pojo.Category;
import de.glamazon.services.ServiceFactory;

public class CategoryModel {
	private Category category;
	private List<Article> articles;
	
	public CategoryModel(Category category) {
		this.setCategory(category);
		this.setArticles();
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles() {
		ServiceFactory svc = ServiceFactory.getInstance();
		try {
			this.articles = svc.getArticleService().getArticlesWithCategory(this.category);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
