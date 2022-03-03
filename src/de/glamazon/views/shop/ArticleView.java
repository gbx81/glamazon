package de.glamazon.views.shop;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class ArticleView extends JPanel {
	
	/**
	 * Detailed view of an article
	 */
	private static final long serialVersionUID = 8240787304739526977L;
	private JButton btnBack2Category;
	private JButton btnArticleToCart;
	
	public ArticleView(String articleId, String categoryTitle, String articleTitle, String articleDescription, String articlePrice ) {
		this.setLayout(null);
		this.setBackground(new Color(255, 250, 250));
		
		JLabel lblArticleHeadline = new JLabel(" " + articleTitle);
		lblArticleHeadline.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		lblArticleHeadline.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		lblArticleHeadline.setOpaque(true);
		lblArticleHeadline.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArticleHeadline.setBounds(63, 10, 660, 32);
		this.add(lblArticleHeadline);
		
		JLabel lblArticleImage = new JLabel("");
		lblArticleImage.setOpaque(true);
		lblArticleImage.setBackground(Color.GRAY);
		lblArticleImage.setBounds(63, 72, 200, 240);
		this.add(lblArticleImage);
		
		JTextPane txtpnArticleDescription = new JTextPane();
		txtpnArticleDescription.setEditable(false);
		txtpnArticleDescription.setMargin(new Insets(6, 6, 6, 6));
		txtpnArticleDescription.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpnArticleDescription.setText(articleDescription);
		txtpnArticleDescription.setBorder(new LineBorder(new Color(192, 192, 192)));
		txtpnArticleDescription.setBounds(273, 72, 448, 240);
		this.add(txtpnArticleDescription);
		
		btnArticleToCart = new JButton("In den Warenkorb");
		btnArticleToCart.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnArticleToCart.setBounds(556, 356, 165, 21);
		btnArticleToCart.setActionCommand(articleId);
		this.add(btnArticleToCart);
		
		JLabel lblArticlePriceLabel = new JLabel("Preis: ");
		lblArticlePriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblArticlePriceLabel.setBounds(607, 322, 45, 13);
		this.add(lblArticlePriceLabel);
		
		JLabel lblArticlePrice = new JLabel(articlePrice + " \u20AC");
		lblArticlePrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblArticlePrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblArticlePrice.setBounds(650, 322, 71, 13);
		this.add(lblArticlePrice);
		
		btnBack2Category = new JButton("zur\u00FCck zu " + categoryTitle);
		btnBack2Category.setBounds(63, 356, 239, 21);
		btnBack2Category.setActionCommand(categoryTitle);
		this.add(btnBack2Category);
	}

	public JButton getBtnBack2Category() {
		return btnBack2Category;
	}
	
	public JButton getBtnArticleToCart() {
		return btnArticleToCart;
	}
}
