package de.glamazon.controllers.shop;

import javax.swing.JPanel;

import de.glamazon.models.shop.LandingPageModel;
import de.glamazon.views.shop.LandingPageView;

public class LandingPageController {
	private LandingPageModel lpm;
	private LandingPageView lpv;
	private JPanel shopPanel;
	
	public LandingPageController(LandingPageModel lpm, LandingPageView lpv, JPanel shopPanel) {
		this.setLpm(lpm);
		this.setLpv(lpv);
		this.setShopPanel(shopPanel);
		
		this.getLpv().createFeaturedProducts(
				this.getLpm().getFeaturedProduct1().getTitle(),
				this.getLpm().getFeaturedProduct1().getImage(),
				this.getLpm().getFeaturedProduct2().getTitle(),
				this.getLpm().getFeaturedProduct2().getImage(),
				this.getLpm().getFeaturedProduct3().getTitle(),
				this.getLpm().getFeaturedProduct3().getImage()
		);
	}

	public LandingPageModel getLpm() {
		return lpm;
	}

	public void setLpm(LandingPageModel lpm) {
		this.lpm = lpm;
	}

	public LandingPageView getLpv() {
		return lpv;
	}

	public void setLpv(LandingPageView lpv) {
		this.lpv = lpv;
	}

	public JPanel getShopPanel() {
		return shopPanel;
	}

	public void setShopPanel(JPanel shopPanel) {
		this.shopPanel = shopPanel;
	}
}
