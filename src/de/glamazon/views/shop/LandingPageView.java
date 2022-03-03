package de.glamazon.views.shop;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import javax.swing.border.TitledBorder;
import java.awt.Cursor;

public class LandingPageView extends JPanel {
	/**
	 * Landing Page for Glamazon Shop
	 */
	private static final long serialVersionUID = -6130023472908686016L;
	private JLabel lblHeadline;
	private JLabel lblFeaturedProductImg1;
	private JLabel lblFeaturedProductImg2;
	private JLabel lblFeaturedProductImg3;
	
	public LandingPageView() {
		this.setLayout(null);
		this.setBackground(new Color(255, 250, 250));
		
		lblHeadline = new JLabel(" Featured Products");
		lblHeadline.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		lblHeadline.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		lblHeadline.setOpaque(true);
		lblHeadline.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHeadline.setBounds(63, 26, 660, 32);
		this.add(lblHeadline);
		
		lblFeaturedProductImg1 = new JLabel("");
		lblFeaturedProductImg1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFeaturedProductImg1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFeaturedProductImg1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeaturedProductImg1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFeaturedProductImg1.setOpaque(true);
		lblFeaturedProductImg1.setBackground(new Color(255, 250, 250));
		lblFeaturedProductImg1.setBounds(63, 68, 200, 228);
		this.add(lblFeaturedProductImg1);
		
		lblFeaturedProductImg2 = new JLabel("");		
		lblFeaturedProductImg2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFeaturedProductImg2.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFeaturedProductImg2.setOpaque(true);
		lblFeaturedProductImg2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFeaturedProductImg2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeaturedProductImg2.setBackground(new Color(255, 250, 250));
		lblFeaturedProductImg2.setBounds(523, 68, 200, 228);
		add(lblFeaturedProductImg2);
		
		lblFeaturedProductImg3 = new JLabel("");
		lblFeaturedProductImg3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblFeaturedProductImg3.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFeaturedProductImg3.setOpaque(true);
		lblFeaturedProductImg3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFeaturedProductImg3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeaturedProductImg3.setBackground(new Color(255, 250, 250));
		lblFeaturedProductImg3.setBounds(292, 68, 200, 228);
		add(lblFeaturedProductImg3);
	}
	
	public void createFeaturedProducts(String fpTitle1, byte[] fpImg1, String fpTitle2, byte[] fpImg2, String fpTitle3, byte[] fpImg3) {
		
		lblFeaturedProductImg1.setBorder(new TitledBorder(null, fpTitle1, TitledBorder.CENTER, TitledBorder.ABOVE_BOTTOM, null, null));
		ImageIcon icon = new ImageIcon(fpImg1);
		ImageIcon iconSized = new ImageIcon(icon.getImage().getScaledInstance(200, -1, 0));
		lblFeaturedProductImg1.setIcon(iconSized);
		
		lblFeaturedProductImg2.setBorder(new TitledBorder(null, fpTitle2, TitledBorder.CENTER, TitledBorder.ABOVE_BOTTOM, null, null));
		ImageIcon icon2 = new ImageIcon(fpImg2);
		ImageIcon iconSized2 = new ImageIcon(icon2.getImage().getScaledInstance(200, -1, 0));
		lblFeaturedProductImg2.setIcon(iconSized2);
		
		lblFeaturedProductImg3.setBorder(new TitledBorder(null, fpTitle3, TitledBorder.CENTER, TitledBorder.ABOVE_BOTTOM, null, null));
		ImageIcon icon3 = new ImageIcon(fpImg3);
		ImageIcon iconSized3 = new ImageIcon(icon3.getImage().getScaledInstance(200, -1, 0));
		lblFeaturedProductImg3.setIcon(iconSized3);
	}
}
