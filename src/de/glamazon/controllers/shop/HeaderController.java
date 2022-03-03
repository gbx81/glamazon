package de.glamazon.controllers.shop;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

import de.glamazon.models.shop.CategoryModel;
import de.glamazon.models.shop.HeaderModel;
import de.glamazon.models.shop.ShoppingCartModel;
import de.glamazon.pojo.Category;
import de.glamazon.services.ServiceFactory;
import de.glamazon.views.shop.CategoryView;
import de.glamazon.views.shop.HeaderView;
import de.glamazon.views.shop.ShoppingCartView;

public class HeaderController {
	private HeaderModel headerModel;
	private HeaderView headerView;
	private JPanel shopPanel;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HeaderController(HeaderModel headerModel,HeaderView headerView, JPanel shopPanel) {
		this.setHeaderModel(headerModel);
		this.setHeaderView(headerView);
		this.setShopPanel(shopPanel);
		this.getHeaderView().getCbCategories().setModel(new DefaultComboBoxModel(this.getHeaderModel().getCategories()));
		this.getHeaderView().getCbCategories().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String cat = String.valueOf(headerView.getCbCategories().getSelectedItem());
				if(cat != "Kategorie wählen") {
					Category category = new Category();
					ServiceFactory svc = ServiceFactory.getInstance();
					try {
						category = svc.getCategoryService().getCategoryByName(cat);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					CategoryModel cm = new CategoryModel(category);
					CategoryView cv = new CategoryView();
					new CategoryController(cm,cv,shopPanel);
					
					getShopPanel().remove(1);
					getShopPanel().add(cv, BorderLayout.CENTER);
					getShopPanel().validate();
				}
			}});
		
		this.getHeaderView().getBtnShoppingCart().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ShoppingCartModel scm = new ShoppingCartModel();
				ShoppingCartView scv = new ShoppingCartView();
				new ShoppingCartController(scm,scv,shopPanel);
				getShopPanel().remove(1);
				getShopPanel().add(scv, BorderLayout.CENTER);
				getShopPanel().validate();
			}
			
		});
	}
	
	public HeaderModel getHeaderModel() {
		return headerModel;
	}
	
	public void setHeaderModel(HeaderModel headerModel) {
		this.headerModel = headerModel;
	}
	
	public HeaderView getHeaderView() {
		return headerView;
	}
	
	public void setHeaderView(HeaderView headerView) {
		this.headerView = headerView;
	}

	public JPanel getShopPanel() {
		return shopPanel;
	}

	public void setShopPanel(JPanel shopPanel) {
		this.shopPanel = shopPanel;
	}
}
