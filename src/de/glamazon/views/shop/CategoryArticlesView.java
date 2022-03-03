package de.glamazon.views.shop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CategoryArticlesView extends JPanel {

	/**
	 * List of Products in a Category
	 */
	private static final long serialVersionUID = -3004767193172753560L;
	private List<JButton> articleButtons;
	
	public CategoryArticlesView() {
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[]{104, 270, 75, 182, 0};
		gbl.rowHeights = new int[]{0, 0, 0, 0};
		gbl.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl.rowWeights = new double[]{0.0,0.0,0.0, Double.MIN_VALUE};
		this.setLayout(gbl);
		articleButtons = new ArrayList<JButton>();
	}
	
	public List<JButton> getArticleButtons() {
		return articleButtons;
	}
	
	public void addArticleToView(int index, String title, String price, int articleId) {
//		JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
//		sep.setPreferredSize(new Dimension(200,3));
		
		JLabel lblArticleImg = new JLabel("");
		lblArticleImg.setPreferredSize(new Dimension(104, 104));
		lblArticleImg.setOpaque(true);
		lblArticleImg.setBackground(Color.GRAY);
		
		GridBagConstraints gbc_lblArticleImg = new GridBagConstraints();
		gbc_lblArticleImg.insets = new Insets(0, 0, 0, 5);
		gbc_lblArticleImg.fill = GridBagConstraints.BOTH;
		gbc_lblArticleImg.gridx = 0;
		gbc_lblArticleImg.gridy = 0 + index;

		this.add(lblArticleImg, gbc_lblArticleImg);
		
		JLabel lblArticleTitleDesc = new JLabel(title);
		lblArticleTitleDesc.setPreferredSize(new Dimension(250, 13));
		GridBagConstraints gbc_lblArticleTitleDesc = new GridBagConstraints();
		gbc_lblArticleTitleDesc.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblArticleTitleDesc.insets = new Insets(0, 0, 0, 5);
		gbc_lblArticleTitleDesc.gridx = 1;
		gbc_lblArticleTitleDesc.gridy = 0 + index;
		this.add(lblArticleTitleDesc, gbc_lblArticleTitleDesc);
		
		JLabel lblArticlePrice = new JLabel(price + " \u20AC ");
		GridBagConstraints gbc_lblArticlePrice = new GridBagConstraints();
		gbc_lblArticlePrice.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblArticlePrice.insets = new Insets(0, 0, 0, 5);
		gbc_lblArticlePrice.gridx = 2;
		gbc_lblArticlePrice.gridy = 0 + index;
		this.add(lblArticlePrice, gbc_lblArticlePrice);
		
		JButton btnShowArticle = new JButton("ansehen"); // eigenen JButton erstellen mit extends JButton Klasse
		btnShowArticle.setActionCommand(String.valueOf(articleId));
		articleButtons.add(btnShowArticle);
		GridBagConstraints gbc_btnToCart = new GridBagConstraints();
		gbc_btnToCart.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnToCart.gridx = 3;
		gbc_btnToCart.gridy = 0 + index;
		this.add(btnShowArticle, gbc_btnToCart);
	}
}
