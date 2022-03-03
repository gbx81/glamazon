package de.glamazon.views.shop;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class CategoryView extends JPanel {
	
	/**
	 * Articles in Category
	 */
	private static final long serialVersionUID = -7931098672272287869L;
	private JLabel lblHeadline;
	private CategoryArticlesView panelArticleList;
	
	public CategoryView() {
		this.setLayout(null);
		this.setBackground(new Color(255, 250, 250));
				
		lblHeadline = new JLabel(" Kategorie XY");
		lblHeadline.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		lblHeadline.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		lblHeadline.setOpaque(true);
		lblHeadline.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHeadline.setBounds(63, 10, 660, 32);
		this.add(lblHeadline);
		
		JScrollPane spArticles = new JScrollPane();
		spArticles.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spArticles.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spArticles.setBounds(63, 52, 658, 384);
		this.add(spArticles);
		
		panelArticleList = new CategoryArticlesView();
		spArticles.setViewportView(panelArticleList);
	}

	public JLabel getLblHeadline() {
		return lblHeadline;
	}
	
	public void setLblHeadline(String lblHeadline) {
		this.getLblHeadline().setText(lblHeadline);
	}

	public CategoryArticlesView getPanelArticleList() {
		return panelArticleList;
	}

	public void setPanelArticleList(CategoryArticlesView panelArticleList) {
		this.panelArticleList = panelArticleList;
	}
	
}
