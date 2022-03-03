package de.glamazon.views.shop;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class Search extends JPanel {
	/**
	 * View of Search Results
	 */
	private static final long serialVersionUID = -2641633711906855512L;
	private JTextField textField;
	
	public Search() {
		this.setLayout(null);
		this.setBackground(new Color(255, 250, 250));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Search.class.getResource("/assets/glmz_logo_138.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setBounds(10, 10, 138, 46);
		this.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(321, 14, 303, 26);
		this.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("suchen");
		btnNewButton.setBounds(630, 13, 91, 26);
		this.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kategorie 1", "Kategorie 2", "Kategorie 3", "Kategorie 4"}));
		comboBox.setBounds(171, 13, 131, 26);
		this.add(comboBox);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setMinimumSize(new Dimension(40, 40));
		btnNewButton_1.setMaximumSize(new Dimension(40, 40));
		btnNewButton_1.setPreferredSize(new Dimension(40, 40));
		btnNewButton_1.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 250, 250));
		btnNewButton_1.setIcon(new ImageIcon(Search.class.getResource("/assets/icons8-shopping-cart-40.png")));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(731, 2, 40, 40);
		this.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel(" Suche nach \"XYZ\"");
		lblNewLabel_1.setBorder(new LineBorder(UIManager.getColor("Button.shadow")));
		lblNewLabel_1.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(63, 82, 660, 32);
		this.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(63, 124, 658, 384);
		this.add(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{128, 390, 116, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_3 = new JLabel("Image");
		lblNewLabel_3.setPreferredSize(new Dimension(128, 128));
		lblNewLabel_3.setMaximumSize(new Dimension(28, 28));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(new Color(95, 158, 160));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Artikelname XY");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("ansehen");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 0;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
	}
}
