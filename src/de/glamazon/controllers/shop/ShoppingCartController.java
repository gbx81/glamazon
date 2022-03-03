package de.glamazon.controllers.shop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.glamazon.models.shop.CheckoutModel;
import de.glamazon.models.shop.ShoppingCartModel;
import de.glamazon.pojo.Article;
import de.glamazon.views.shop.CheckoutView;
import de.glamazon.views.shop.ShoppingCartView;

public class ShoppingCartController {
	private ShoppingCartModel scm;
	private ShoppingCartView scv;
	private JPanel shopPanel;
	
	public ShoppingCartController(ShoppingCartModel scm, ShoppingCartView scv, JPanel shopPanel) {
		this.setScm(scm);
		this.setScv(scv);
		this.setShopPanel(shopPanel);
		List<Article> cart = this.getScm().getCart().getCart();
		if(cart.size() > 0) {
			List<Article> articlesAdded = new ArrayList<Article>();
			this.generateView(cart, articlesAdded);
			this.addButtonListeners(cart, articlesAdded);
		}
	}
	
	public ShoppingCartModel getScm() {
		return scm;
	}
	public void setScm(ShoppingCartModel scm) {
		this.scm = scm;
	}
	public ShoppingCartView getScv() {
		return scv;
	}
	public void setScv(ShoppingCartView scv) {
		this.scv = scv;
	}
	
	private void generateView(List<Article> cart, List<Article> articlesAdded) {
		int i = 0;
		for (Article article : cart) {
			boolean b = false;
			for(Article addedArticle : articlesAdded) {
				if(article.equals(addedArticle)) {
					b = true;
					break;
				}
			}
			if(!b) {
				int sac = this.getScm().getCart().getSameArticleCount(article);
				this.getScv().getArticlesView().addShoppingCartArticle(
						i, 
						article.getArtnum(), 
						article.getTitle(), 
						String.valueOf(sac), 
						String.format("%,.2f",article.getPrice()), 
						String.format("%,.2f",article.getPrice()*sac), 
						String.valueOf(article.getId()));
				articlesAdded.add(article);
				i++;
			}
		}
		this.getScv().setTotalAmount(String.format("%,2.2f", scm.getCart().getTotalAmount()) + " \u20AC");
	}
	
	public void addButtonListeners(List<Article> cart, List<Article> articlesAdded) {
		// increase articlecount buttons
		for (JButton button : this.getScv().getArticlesView().getPlusButtons()) {
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (Article article : cart) {
						if(article.getId() == Integer.parseInt(button.getActionCommand())) {
							getScm().getCart().addArticle(article);
							for (int i = 0; i < articlesAdded.size(); i++) {
								if(article.equals(articlesAdded.get(i))) {
									JLabel count = getScv().getArticlesView().getArticleCounts().get(i);
									count.setText(String.valueOf(Integer.parseInt(count.getText()) + 1));
									JLabel total = getScv().getArticlesView().getArticleTotalAmounts().get(i);
									total.setText(String.format("%,.2f",Integer.parseInt(count.getText())*article.getPrice()) + " \u20AC");
									break;
								}
							}
							getScv().setTotalAmount(String.format("%,.2f",scm.getCart().getTotalAmount()) + " \u20AC");
							break;
						}
					}
				}
			});
		}
		// decrease articlecount buttons
		for (JButton button : this.getScv().getArticlesView().getMinusButtons()) {
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (Article article : cart) {
						if(article.getId() == Integer.parseInt(button.getActionCommand())) {
							if(scm.getCart().getSameArticleCount(article) > 1) {
								for (int i = 0; i < articlesAdded.size(); i++) {
									if(article.equals(articlesAdded.get(i))) {
										JLabel count = getScv().getArticlesView().getArticleCounts().get(i);
										count.setText(String.valueOf(Integer.parseInt(count.getText()) - 1));
										JLabel total = getScv().getArticlesView().getArticleTotalAmounts().get(i);
										total.setText(String.format("%,.2f",Integer.parseInt(count.getText())*article.getPrice()) + " \u20AC");
										getScm().getCart().removeSingleArticle(article);
										break;
									}
								}
								getScv().setTotalAmount(String.format("%,.2f",scm.getCart().getTotalAmount()) + " \u20AC");
							}
							break;
						}
					}
				}
			});
		}
		
		// delete product from cart on button click
		for(JButton button : this.getScv().getArticlesView().getDeleteButtons()) {
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (Article article : cart) {
						if(article.getId() == Integer.parseInt(button.getActionCommand())) {
							getScm().getCart().removeSingleArticle(article);
							setScv(new ShoppingCartView());
							new ShoppingCartController(getScm(),getScv(),getShopPanel());
							getShopPanel().remove(1);
							getShopPanel().add(getScv());
							getShopPanel().validate();
							break;
						}
					}
				}
				
			});
		}
		
		// checkout button
		getScv().getBtnToCheckout().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CheckoutModel cm = new CheckoutModel();
				CheckoutView cv = new CheckoutView();
				new CheckoutController(cm,cv,shopPanel);
				getShopPanel().remove(1);
				getShopPanel().add(cv);
				getShopPanel().validate();
			}
			
		});
	}

	public JPanel getShopPanel() {
		return shopPanel;
	}

	public void setShopPanel(JPanel shopPanel) {
		this.shopPanel = shopPanel;
	}
}
