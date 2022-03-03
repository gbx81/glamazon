package de.glamazon.controllers.shop;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JPanel;

import de.glamazon.models.shop.ArticleModel;
import de.glamazon.models.shop.CategoryModel;
import de.glamazon.models.shop.ShoppingCartModel;
import de.glamazon.pojo.Category;
import de.glamazon.services.ServiceFactory;
import de.glamazon.views.shop.ArticleView;
import de.glamazon.views.shop.CategoryView;
import de.glamazon.views.shop.ShoppingCartView;

public class ArticleController {
	ArticleModel articleModel;
	ArticleView articleView;
	
	public ArticleController(ArticleModel articleModel, ArticleView articleView, JPanel shopPanel) {
		this.setArticleModel(articleModel);
		this.setArticleView(articleView);
		this.getArticleView().getBtnBack2Category().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Category category = new Category();
				ServiceFactory svc = ServiceFactory.getInstance();
				try {
					category = svc.getCategoryService().getCategoryByName(getArticleView().getBtnBack2Category().getActionCommand());
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
				CategoryModel cm = new CategoryModel(category);
				CategoryView cv = new CategoryView();
				new CategoryController(cm,cv,shopPanel);
				
				shopPanel.remove(1);
				shopPanel.add(cv, BorderLayout.CENTER);
				shopPanel.validate();
			}
		});
		this.getArticleView().getBtnArticleToCart().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ShoppingCartModel scm = new ShoppingCartModel();
				scm.getCart().addArticle(articleModel.getArticle());
				ShoppingCartView scv = new ShoppingCartView();
				new ShoppingCartController(scm,scv,shopPanel);
				
				shopPanel.remove(1);
				shopPanel.add(scv, BorderLayout.CENTER);
				shopPanel.validate();
			}
			
		});
	}

	public ArticleModel getArticleModel() {
		return articleModel;
	}

	public void setArticleModel(ArticleModel articleModel) {
		this.articleModel = articleModel;
	}

	public ArticleView getArticleView() {
		return articleView;
	}

	public void setArticleView(ArticleView articleView) {
		this.articleView = articleView;
	}	
}
