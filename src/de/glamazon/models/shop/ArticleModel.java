package de.glamazon.models.shop;

import java.sql.SQLException;

import de.glamazon.pojo.Article;
import de.glamazon.services.ServiceFactory;

public class ArticleModel {
	private Article article;
	
	public ArticleModel(int articleId) {
		this.setArticle(articleId);
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(int articleId) {
		ServiceFactory svc = ServiceFactory.getInstance();
		Article article = new Article();
		try {
			article = svc.getArticleService().getArticleById(articleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.article = article;
	}
	
}
