package de.glamazon.views.shop;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShoppingCartArticlesView extends JPanel {
	
	/**
	 * Panel for Articles in Shopping Cart
	 */
	private static final long serialVersionUID = -7762944462452993909L;
	
	private List<JButton> plusButtons;
	private List<JButton> minusButtons;
	private List<JButton> deleteButtons;
	private List<JLabel> articleCounts;
	private List<JLabel> articleTotalAmounts;

	public ShoppingCartArticlesView() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{91, 219, 35, 40, 0, 0, 80, 69, 0};
		gbl_panel.rowHeights = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		plusButtons = new ArrayList<JButton>();
		minusButtons = new ArrayList<JButton>();
		deleteButtons = new ArrayList<JButton>();
		articleCounts = new ArrayList<JLabel>();
		articleTotalAmounts = new ArrayList<JLabel>();
	}
	
	public List<JButton> getPlusButtons() {
		return plusButtons;
	}

	public List<JButton> getMinusButtons() {
		return minusButtons;
	}

	public List<JButton> getDeleteButtons() {
		return deleteButtons;
	}
	
	public List<JLabel> getArticleCounts() {
		return articleCounts;
	}

	public void addShoppingCartArticle(int index, String articleNum, String articleTitle, String articleCount, String articlePrice, String articleTotalAmount, String articleId) {
				
		JLabel lblArtnum = new JLabel(articleNum);
		lblArtnum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblArtnum = new GridBagConstraints();
		gbc_lblArtnum.anchor = GridBagConstraints.WEST;
		gbc_lblArtnum.insets = new Insets(0, 0, 0, 5);
		gbc_lblArtnum.gridx = 0;
		gbc_lblArtnum.gridy = 0 + index;
		this.add(lblArtnum, gbc_lblArtnum);
		
		JLabel lblArticleTitle = new JLabel(articleTitle);
		lblArticleTitle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblArticleTitle = new GridBagConstraints();
		gbc_lblArticleTitle.anchor = GridBagConstraints.WEST;
		gbc_lblArticleTitle.insets = new Insets(0, 0, 0, 5);
		gbc_lblArticleTitle.gridx = 1;
		gbc_lblArticleTitle.gridy = 0 + index;
		this.add(lblArticleTitle, gbc_lblArticleTitle);
		
		JLabel lblArticleCount = new JLabel(articleCount);
		lblArticleCount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		articleCounts.add(lblArticleCount);
		GridBagConstraints gbc_lblArticleCount = new GridBagConstraints();
		gbc_lblArticleCount.anchor = GridBagConstraints.EAST;
		gbc_lblArticleCount.insets = new Insets(0, 0, 0, 5);
		gbc_lblArticleCount.gridx = 2;
		gbc_lblArticleCount.gridy = 0 + index;
		this.add(lblArticleCount, gbc_lblArticleCount);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setActionCommand(articleId);
		plusButtons.add(btnPlus);
		btnPlus.setMargin(new Insets(0, 5, 0, 5));
		btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_btnPlus = new GridBagConstraints();
		gbc_btnPlus.anchor = GridBagConstraints.EAST;
		gbc_btnPlus.insets = new Insets(0, 0, 0, 5);
		gbc_btnPlus.gridx = 3;
		gbc_btnPlus.gridy = 0 + index;
		this.add(btnPlus, gbc_btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setActionCommand(articleId);
		minusButtons.add(btnMinus);
		btnMinus.setMargin(new Insets(0, 5, 0, 5));
		btnMinus.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_btnMinus = new GridBagConstraints();
		gbc_btnMinus.anchor = GridBagConstraints.EAST;
		gbc_btnMinus.insets = new Insets(0, 0, 0, 5);
		gbc_btnMinus.gridx = 4;
		gbc_btnMinus.gridy = 0 + index;
		this.add(btnMinus, gbc_btnMinus);
		
		JButton btnDelete = new JButton("l\u00F6schen");
		btnDelete.setActionCommand(articleId);
		deleteButtons.add(btnDelete);
		btnDelete.setMargin(new Insets(0, 14, 0, 14));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.anchor = GridBagConstraints.EAST;
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 5;
		gbc_btnDelete.gridy = 0 + index;
		this.add(btnDelete, gbc_btnDelete);
		
		JLabel lblSingleArticlePrice = new JLabel(articlePrice + " \u20AC");
		lblSingleArticlePrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblSingleArticlePrice = new GridBagConstraints();
		gbc_lblSingleArticlePrice.anchor = GridBagConstraints.EAST;
		gbc_lblSingleArticlePrice.insets = new Insets(0, 0, 0, 5);
		gbc_lblSingleArticlePrice.gridx = 6;
		gbc_lblSingleArticlePrice.gridy = 0 + index;
		this.add(lblSingleArticlePrice, gbc_lblSingleArticlePrice);
		
		JLabel lblArticleTotalPrice = new JLabel(articleTotalAmount + " \u20AC");
		lblArticleTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		articleTotalAmounts.add(lblArticleTotalPrice);
		GridBagConstraints gbc_lblArticleTotalPrice = new GridBagConstraints();
		gbc_lblArticleTotalPrice.anchor = GridBagConstraints.EAST;
		gbc_lblArticleTotalPrice.gridx = 7;
		gbc_lblArticleTotalPrice.gridy = 0 + index;
		this.add(lblArticleTotalPrice, gbc_lblArticleTotalPrice);
	}

	public List<JLabel> getArticleTotalAmounts() {
		return articleTotalAmounts;
	}
}
