package de.glamazon.controllers.shop;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import de.glamazon.models.shop.ArticleModel;
import de.glamazon.models.shop.CategoryModel;
import de.glamazon.pojo.Article;
import de.glamazon.pojo.Category;
import de.glamazon.services.ServiceFactory;
import de.glamazon.views.shop.ArticleView;
import de.glamazon.views.shop.CategoryView;

public class CategoryController {
	private CategoryModel categoryModel;
	private CategoryView categoryView;
	private JPanel shopPanel;
	
	public CategoryController(CategoryModel categoryModel, CategoryView categoryView, JPanel pShopPanel) {
		this.setCategoryModel(categoryModel);
		this.setCategoryView(categoryView);
		this.setShopPanel(pShopPanel);
		this.setTitle();
		this.createArticleView();
		for (JButton button : this.getCategoryView().getPanelArticleList().getArticleButtons()) {
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ArticleModel am = new ArticleModel(Integer.parseInt(e.getActionCommand()));
					Article article = am.getArticle();
					Category category = getCategoryModel().getCategory();
					ArticleView av = new ArticleView(
							String.valueOf(article.getId()), 
							category.getTitle(), 
							article.getTitle(), 
							article.getDescription(), 
							String.format("%2.2f",article.getPrice())
							);
					new ArticleController(am,av,getShopPanel());
					
					getShopPanel().remove(1);
					getShopPanel().add(av, BorderLayout.CENTER);
					getShopPanel().validate();
				}
			});
		}
		
	}

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public CategoryView getCategoryView() {
		return categoryView;
	}

	public void setCategoryView(CategoryView categoryView) {
		this.categoryView = categoryView;
	}

	public JPanel getShopPanel() {
		return shopPanel;
	}

	public void setShopPanel(JPanel shopPanel) {
		this.shopPanel = shopPanel;
	}
	
	public void setTitle() {
		this.getCategoryView().setLblHeadline(" " + this.getCategoryModel().getCategory().getTitle());
	}
	
	public void createArticleView() {
		ServiceFactory svc = ServiceFactory.getInstance();
		List<Article> articles;
		try {
			articles = svc.getArticleService().getArticlesWithCategory(this.getCategoryModel().getCategory());
			for (int i = 0; i < articles.size(); i++) {
				this.getCategoryView().getPanelArticleList().addArticleToView(
						i, 
						articles.get(i).getTitle(), 
						String.format("%,.2f",articles.get(i).getPrice()), 
						articles.get(i).getId()
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
