package de.glamazon;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import de.glamazon.controllers.shop.HeaderController;
import de.glamazon.controllers.shop.LandingPageController;
import de.glamazon.models.shop.HeaderModel;
import de.glamazon.models.shop.LandingPageModel;
import de.glamazon.views.shop.HeaderView;
import de.glamazon.views.shop.LandingPageView;

public class Prototype {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prototype window = new Prototype();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Prototype() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel shopPanel = new JPanel();
		shopPanel.setLayout(new BorderLayout());
		
		HeaderView hv = new HeaderView();
		HeaderModel hm = new HeaderModel();
		new HeaderController(hm, hv, shopPanel);
		
		LandingPageModel lpm = new LandingPageModel();
		LandingPageView lpv = new LandingPageView();
		LandingPageController lpc = new LandingPageController(lpm, lpv, shopPanel);
		
		shopPanel.add(hv, BorderLayout.NORTH);
		shopPanel.add(lpc.getLpv(), BorderLayout.CENTER);	
		
		JPanel adminPanel = new JPanel();
		adminPanel.setLayout(null);
		adminPanel.setVisible(false);
		
		frame.add(adminPanel);
		frame.add(shopPanel);
	}
}
