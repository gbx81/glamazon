package de.glamazon.views.shop;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class CheckoutView extends JPanel {
	
	/**
	 * Panel for Checkout
	 */
	private static final long serialVersionUID = 4725731496072780483L;
	private JTextField tfName;
	private JTextField tfFirstname;
	private JTextField tfStreet;
	private JTextField tfZip;
	private JTextField tfCity;
	private JTextField tfAddressadd;
	private JTextField tfPhone;
	private JScrollPane spCartList;
	private JButton btnSendOrder;
	private JLabel lblTotalAmount;
	private JButton btnBack2Cart;
	private JCheckBox cbxAgree;
	private CheckoutCartView checkoutCartPanel;
	
	public CheckoutCartView getCheckoutCartPanel() {
		return checkoutCartPanel;
	}

	public void setCheckoutCartPanel(CheckoutCartView checkoutCartPanel) {
		this.checkoutCartPanel = checkoutCartPanel;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}

	public JTextField getTfFirstname() {
		return tfFirstname;
	}

	public void setTfFirstname(JTextField tfFirstname) {
		this.tfFirstname = tfFirstname;
	}

	public JTextField getTfStreet() {
		return tfStreet;
	}

	public void setTfStreet(JTextField tfStreet) {
		this.tfStreet = tfStreet;
	}

	public JTextField getTfZip() {
		return tfZip;
	}

	public void setTfZip(JTextField tfZip) {
		this.tfZip = tfZip;
	}

	public JTextField getTfCity() {
		return tfCity;
	}

	public void setTfCity(JTextField tfCity) {
		this.tfCity = tfCity;
	}

	public JTextField getTfAddressadd() {
		return tfAddressadd;
	}

	public void setTfAddressadd(JTextField tfAddressadd) {
		this.tfAddressadd = tfAddressadd;
	}

	public JTextField getTfPhone() {
		return tfPhone;
	}

	public void setTfPhone(JTextField tfPhone) {
		this.tfPhone = tfPhone;
	}

	public JScrollPane getSpCartList() {
		return spCartList;
	}

	public void setSpCartList(JScrollPane spCartList) {
		this.spCartList = spCartList;
	}

	public JButton getBtnSendOrder() {
		return btnSendOrder;
	}

	public void setBtnSendOrder(JButton btnSendOrder) {
		this.btnSendOrder = btnSendOrder;
	}

	public JLabel getLblTotalAmount() {
		return lblTotalAmount;
	}

	public void setLblTotalAmount(String totalAmount) {
		this.lblTotalAmount.setText(totalAmount);
	}

	public JButton getBtnBack2Cart() {
		return btnBack2Cart;
	}

	public void setBtnBack2Cart(JButton btnBack2Cart) {
		this.btnBack2Cart = btnBack2Cart;
	}

	public JCheckBox getCbxAgree() {
		return cbxAgree;
	}

	public void setCbxAgree(JCheckBox cbxAgree) {
		this.cbxAgree = cbxAgree;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CheckoutView() {
		this.setLayout(null);
		this.setBackground(new Color(255, 250, 250));
		
		JLabel lblHeadline = new JLabel(" Adressdaten");
		lblHeadline.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		lblHeadline.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		lblHeadline.setOpaque(true);
		lblHeadline.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHeadline.setBounds(63, 10, 660, 32);
		this.add(lblHeadline);
		
		spCartList = new JScrollPane();
		spCartList.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		spCartList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spCartList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spCartList.setBounds(61, 282, 660, 133);
		this.add(spCartList);
		
		checkoutCartPanel = new CheckoutCartView();
		spCartList.setViewportView(checkoutCartPanel);
		
		btnSendOrder = new JButton("Kaufen");
		btnSendOrder.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSendOrder.setBackground(new Color(255, 160, 122));
		btnSendOrder.setBounds(636, 448, 85, 21);
		this.add(btnSendOrder);
		
		JLabel lblTotalTitle = new JLabel("Gesamtbetrag: ");
		lblTotalTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalTitle.setBounds(526, 425, 86, 13);
		this.add(lblTotalTitle);
		
		lblTotalAmount = new JLabel("0,00 \u20AC");
		lblTotalAmount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalAmount.setBounds(622, 425, 81, 13);
		this.add(lblTotalAmount);
		
		JLabel lblHeadline2 = new JLabel(" Artikelliste");
		lblHeadline2.setOpaque(true);
		lblHeadline2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHeadline2.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		lblHeadline2.setBackground(SystemColor.menu);
		lblHeadline2.setBounds(61, 216, 660, 32);
		this.add(lblHeadline2);
		
		tfName = new JTextField();
		tfName.setBounds(63, 68, 297, 26);
		this.add(tfName);
		tfName.setColumns(10);
		
		JLabel lbl4tfName = new JLabel("Name");
		lbl4tfName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl4tfName.setBounds(63, 52, 114, 13);
		this.add(lbl4tfName);
		
		tfFirstname = new JTextField();
		tfFirstname.setColumns(10);
		tfFirstname.setBounds(424, 68, 297, 26);
		this.add(tfFirstname);
		
		JLabel lbl4tfFirstname = new JLabel("Vorname");
		lbl4tfFirstname.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl4tfFirstname.setBounds(424, 52, 114, 13);
		this.add(lbl4tfFirstname);
		
		tfStreet = new JTextField();
		tfStreet.setColumns(10);
		tfStreet.setBounds(63, 120, 297, 26);
		this.add(tfStreet);
		
		JLabel lbl4tfStreet = new JLabel("Stra\u00DFe & Nr.");
		lbl4tfStreet.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl4tfStreet.setBounds(63, 104, 114, 13);
		this.add(lbl4tfStreet);
		
		tfZip = new JTextField();
		tfZip.setColumns(10);
		tfZip.setBounds(426, 120, 78, 26);
		this.add(tfZip);
		
		JLabel lbl4tfZip = new JLabel("PLZ");
		lbl4tfZip.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl4tfZip.setBounds(428, 104, 73, 13);
		this.add(lbl4tfZip);
		
		tfCity = new JTextField();
		tfCity.setColumns(10);
		tfCity.setBounds(514, 120, 207, 26);
		this.add(tfCity);
		
		JLabel lbl4tfCity = new JLabel("Ort");
		lbl4tfCity.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl4tfCity.setBounds(516, 104, 207, 13);
		this.add(lbl4tfCity);
		
		tfAddressadd = new JTextField();
		tfAddressadd.setColumns(10);
		tfAddressadd.setBounds(63, 172, 297, 26);
		this.add(tfAddressadd);
		
		JLabel lbl4tfAddressadd = new JLabel("Adresszusatz (optional)");
		lbl4tfAddressadd.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl4tfAddressadd.setBounds(63, 156, 114, 13);
		this.add(lbl4tfAddressadd);
		
		tfPhone = new JTextField();
		tfPhone.setColumns(10);
		tfPhone.setBounds(424, 172, 297, 26);
		this.add(tfPhone);
		
		JLabel lbl4tfPhone = new JLabel("Telefon (optional)");
		lbl4tfPhone.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl4tfPhone.setBounds(424, 156, 114, 13);
		this.add(lbl4tfPhone);
		
		btnBack2Cart = new JButton("Zur\u00FCck zum Warenkorb");
		btnBack2Cart.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnBack2Cart.setBounds(471, 448, 153, 21);
		this.add(btnBack2Cart);
		
		cbxAgree = new JCheckBox("Ich habe die AGB gelesen und akzeptiert.");
		cbxAgree.setBackground(new Color(255, 250, 250));
		cbxAgree.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbxAgree.setBounds(63, 422, 247, 21);
		this.add(cbxAgree);
		
		JLabel lbl4ArticleNum = new JLabel("Artikelnr.");
		lbl4ArticleNum.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl4ArticleNum.setBounds(61, 268, 95, 14);
		add(lbl4ArticleNum);
		
		JLabel lbl4ArticleTitle = new JLabel("Artikelbezeichnung");
		lbl4ArticleTitle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl4ArticleTitle.setBounds(161, 269, 315, 14);
		add(lbl4ArticleTitle);
		
		JLabel lbl4ArticleCount = new JLabel("Anzahl");
		lbl4ArticleCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl4ArticleCount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl4ArticleCount.setBounds(479, 269, 65, 14);
		add(lbl4ArticleCount);
		
		JLabel lbl4ArticlePrice = new JLabel("St\u00FCckpreis");
		lbl4ArticlePrice.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl4ArticlePrice.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl4ArticlePrice.setBounds(552, 268, 67, 14);
		add(lbl4ArticlePrice);
		
		JLabel lbl4ArticleTotalAmount = new JLabel("Gesamt");
		lbl4ArticleTotalAmount.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl4ArticleTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbl4ArticleTotalAmount.setBounds(624, 269, 76, 14);
		add(lbl4ArticleTotalAmount);
	}
}
