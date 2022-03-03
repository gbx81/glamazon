package de.glamazon.views.shop;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import de.glamazon.Prototype;

public class HeaderView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4968075741164075812L;
	/**
	 * Header Panel for Glamazon Shop
	 */
	private JTextField tfSearch;
	private JButton btnSearch;
	private JComboBox<String[]> cbCategories;
	private JButton btnShoppingCart;
	
	public JTextField getTfSearch() {
		return tfSearch;
	}

	public void setTfSearch(JTextField tfSearch) {
		this.tfSearch = tfSearch;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}

	public JComboBox<String[]> getCbCategories() {
		return cbCategories;
	}

	public void setCbCategories(JComboBox<String[]> cbCategories) {
		this.cbCategories = cbCategories;
	}

	public JButton getBtnShoppingCart() {
		return btnShoppingCart;
	}

	public void setBtnShoppingCart(JButton btnShoppingCart) {
		this.btnShoppingCart = btnShoppingCart;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public HeaderView() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(800,60));
		this.setBackground(new Color(255, 250, 250));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Prototype.class.getResource("/assets/glmz_logo_138.png")));
		lblLogo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setOpaque(true);
		lblLogo.setBackground(Color.ORANGE);
		lblLogo.setBounds(10, 10, 138, 46);
		this.add(lblLogo);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(321, 14, 303, 26);
		this.add(tfSearch);
		tfSearch.setColumns(10);
		
		btnSearch = new JButton("suchen");
		btnSearch.setBounds(630, 13, 91, 26);
		this.add(btnSearch);
		
		cbCategories = new JComboBox<String[]>();
		cbCategories.setFont(new Font("Tahoma", Font.BOLD, 12));
		cbCategories.setModel(new DefaultComboBoxModel<String[]>());
		cbCategories.setBounds(171, 13, 131, 26);
		this.add(cbCategories);
		
		btnShoppingCart = new JButton("");
		btnShoppingCart.setMinimumSize(new Dimension(39, 39));
		btnShoppingCart.setMaximumSize(new Dimension(39, 39));
		btnShoppingCart.setPreferredSize(new Dimension(39, 39));
		btnShoppingCart.setMargin(new Insets(0, 0, 0, 0));
		btnShoppingCart.setBackground(new Color(255, 250, 250));
		btnShoppingCart.setIcon(new ImageIcon(Prototype.class.getResource("/assets/icons8-shopping-cart-40.png")));
		btnShoppingCart.setBorder(null);
		btnShoppingCart.setBounds(731, 2, 40, 40);
		this.add(btnShoppingCart);
	}
}
