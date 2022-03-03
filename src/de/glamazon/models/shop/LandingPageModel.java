package de.glamazon.models.shop;

import java.sql.SQLException;

import de.glamazon.pojo.Article;
import de.glamazon.services.ServiceFactory;

public class LandingPageModel {
	private Article featuredProduct1;
	private Article featuredProduct2;
	private Article featuredProduct3;
	
	public LandingPageModel() {
		ServiceFactory svc = ServiceFactory.getInstance();
		try {
			this.setFeaturedProduct1(svc.getArticleService().getArticleById(2));
			this.setFeaturedProduct2(svc.getArticleService().getArticleById(3));
			this.setFeaturedProduct3(svc.getArticleService().getArticleById(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Article getFeaturedProduct1() {
		return featuredProduct1;
	}

	public void setFeaturedProduct1(Article featuredProduct1) {
		this.featuredProduct1 = featuredProduct1;
	}

	public Article getFeaturedProduct2() {
		return featuredProduct2;
	}

	public void setFeaturedProduct2(Article featuredProduct2) {
		this.featuredProduct2 = featuredProduct2;
	}

	public Article getFeaturedProduct3() {
		return featuredProduct3;
	}

	public void setFeaturedProduct3(Article featuredProduct3) {
		this.featuredProduct3 = featuredProduct3;
	}
}
