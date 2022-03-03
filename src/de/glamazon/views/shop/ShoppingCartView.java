package de.glamazon.views.shop;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Component;

public class ShoppingCartView extends JPanel {
	
	/**
	 * Shopping Cart View (contains ShoppingCartArticlesView as JPanel in JScrollPane)
	 */
	private static final long serialVersionUID = -77904999272787231L;
	
	private JButton btnToCheckout;
	private ShoppingCartArticlesView articlesView;
	JLabel lblSCartTotalAmount;
	
	public ShoppingCartView() {
		this.setLayout(null);
		this.setBackground(new Color(255, 250, 250));
		
		JLabel lblSCartTitle = new JLabel(" Warenkorb");
		lblSCartTitle.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		lblSCartTitle.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		lblSCartTitle.setOpaque(true);
		lblSCartTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSCartTitle.setBounds(63, 10, 660, 32);
		this.add(lblSCartTitle);
		
		JScrollPane spSCart = new JScrollPane();
		spSCart.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spSCart.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spSCart.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spSCart.setBounds(63, 91, 658, 303);
		this.add(spSCart);
		articlesView = new ShoppingCartArticlesView();
		spSCart.setViewportView(articlesView);
		
		btnToCheckout = new JButton("Zur Kasse");
		btnToCheckout.setBounds(609, 427, 112, 21);
		this.add(btnToCheckout);
		
		JLabel lblSCartTotalLabel = new JLabel("Gesamtpreis: ");
		lblSCartTotalLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSCartTotalLabel.setBounds(547, 404, 73, 13);
		this.add(lblSCartTotalLabel);
		
		lblSCartTotalAmount = new JLabel("0,00 \u20AC");
		lblSCartTotalAmount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSCartTotalAmount.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSCartTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSCartTotalAmount.setBounds(630, 404, 73, 13);
		this.add(lblSCartTotalAmount);
		
		JLabel lblNewLabel = new JLabel("Artikelnr.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(63, 73, 73, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Artikelname");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(155, 73, 106, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Anzahl");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(344, 73, 62, 13);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Einzelpreis");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(551, 73, 73, 13);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Gesamt");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_4.setBounds(656, 73, 45, 13);
		add(lblNewLabel_4);
	}
	
	public JButton getBtnToCheckout() {
		return btnToCheckout;
	}
	
	public void setTotalAmount(String totalAmount) {
		this.lblSCartTotalAmount.setText(totalAmount);
	}
	
	public void setArticlesView(ShoppingCartArticlesView articlesView) {
		this.articlesView = articlesView;
	}

	public ShoppingCartArticlesView getArticlesView() {
		return articlesView;
	}
	
}
