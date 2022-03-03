package de.glamazon.views.shop;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BookingView extends JPanel{
	/**
	 * page viewed after booking done
	 */
	private static final long serialVersionUID = 8964751785015306633L;
	
	private JButton btnBack2Shop;

	public JButton getBtnBack2Shop() {
		return btnBack2Shop;
	}

	public BookingView(String bookingId, String totalAmount) {
		this.setLayout(null);
		this.setBackground(new Color(255, 250, 250));
		
		JLabel lblThx = new JLabel("VIELEN DANK!");
		lblThx.setHorizontalAlignment(SwingConstants.CENTER);
		lblThx.setForeground(new Color(0, 153, 51));
		lblThx.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblThx.setBounds(158, 57, 457, 54);
		add(lblThx);
		
		JLabel lblNewLabel = new JLabel("Wir bedanken uns f\u00FCr Ihr Vertrauen, dass wir ganz bestimmt missbrauchen werden.");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(128, 136, 516, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Der von Ihnen bestellte Schrott wird Ihnen zugesandt, sobald wir Lust darauf haben.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(167, 175, 438, 13);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ihre Bestellnummer: ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(308, 229, 107, 13);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel(bookingId);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(410, 229, 107, 13);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Bitte halten Sie den Gesamtbetrag in H\u00F6he von " + totalAmount + "\u20AC bei der Zustellung bereit.");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(167, 274, 438, 13);
		add(lblNewLabel_1_2);
		
		btnBack2Shop = new JButton("zur\u00FCck zur Startseite");
		btnBack2Shop.setBounds(312, 324, 149, 21);
		add(btnBack2Shop);
	}
}
