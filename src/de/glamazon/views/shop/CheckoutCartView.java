package de.glamazon.views.shop;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CheckoutCartView extends JPanel{
	
	/**
	 * Panel for Checkout Cart
	 */
	private static final long serialVersionUID = -7049081694079018963L;


	public CheckoutCartView() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100, 320, 70, 72, 76, 0};
		gbl_panel.rowHeights = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);		
	}
	
	public void addArticleView(int index, String artnum, String title, String count, String price, String totalAmount) {
		JLabel lblArticleNum = new JLabel(artnum);
		lblArticleNum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblArticleNum = new GridBagConstraints();
		gbc_lblArticleNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArticleNum.insets = new Insets(0, 0, 0, 5);
		gbc_lblArticleNum.gridx = 0;
		gbc_lblArticleNum.gridy = 0 + index;
		this.add(lblArticleNum, gbc_lblArticleNum);
		
		JLabel lblArticleTitle = new JLabel(title);
		lblArticleTitle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblArticleTitle = new GridBagConstraints();
		gbc_lblArticleTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArticleTitle.insets = new Insets(0, 0, 0, 5);
		gbc_lblArticleTitle.gridx = 1;
		gbc_lblArticleTitle.gridy = 0 + index;
		this.add(lblArticleTitle, gbc_lblArticleTitle);
		
		JLabel lblArticleCount = new JLabel(count);
		lblArticleCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblArticleCount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblArticleCount = new GridBagConstraints();
		gbc_lblArticleCount.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArticleCount.insets = new Insets(0, 0, 0, 5);
		gbc_lblArticleCount.gridx = 2;
		gbc_lblArticleCount.gridy = 0 + index;
		this.add(lblArticleCount, gbc_lblArticleCount);
		
		JLabel lblArticlePrice = new JLabel(price + " \u20AC");
		lblArticlePrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lblArticlePrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblArticlePrice = new GridBagConstraints();
		gbc_lblArticlePrice.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArticlePrice.insets = new Insets(0, 0, 0, 5);
		gbc_lblArticlePrice.gridx = 3;
		gbc_lblArticlePrice.gridy = 0 + index;
		this.add(lblArticlePrice, gbc_lblArticlePrice);
		
		JLabel lblArticleTotalAmount = new JLabel(totalAmount + " \u20AC");
		lblArticleTotalAmount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblArticleTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblArticleTotalAmount = new GridBagConstraints();
		gbc_lblArticleTotalAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblArticleTotalAmount.gridx = 4;
		gbc_lblArticleTotalAmount.gridy = 0 + index;
		this.add(lblArticleTotalAmount, gbc_lblArticleTotalAmount);
	}
}
