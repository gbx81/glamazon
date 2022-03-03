package de.glamazon.controllers.shop;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import de.glamazon.models.shop.BookingModel;
import de.glamazon.models.shop.CheckoutModel;
import de.glamazon.models.shop.ShoppingCartModel;
import de.glamazon.pojo.Article;
import de.glamazon.pojo.Booking;
import de.glamazon.pojo.Customer;
import de.glamazon.pojo.ShoppingCart;
import de.glamazon.services.ServiceFactory;
import de.glamazon.views.shop.BookingView;
import de.glamazon.views.shop.CheckoutView;
import de.glamazon.views.shop.ShoppingCartView;

public class CheckoutController {
	private CheckoutModel cm;
	private CheckoutView cv;
	private JPanel shopPanel;
	
	public CheckoutController(CheckoutModel cm, CheckoutView cv, JPanel shopPanel) {
		this.setCm(cm);
		this.setCv(cv);
		this.setShopPanel(shopPanel);
		
		this.generateView();
		this.addButtonListeners();
	}

	public CheckoutModel getCm() {
		return cm;
	}

	public void setCm(CheckoutModel cm) {
		this.cm = cm;
	}

	public CheckoutView getCv() {
		return cv;
	}

	public void setCv(CheckoutView cv) {
		this.cv = cv;
	}

	public JPanel getShopPanel() {
		return shopPanel;
	}

	public void setShopPanel(JPanel shopPanel) {
		this.shopPanel = shopPanel;
	}
	
	private void generateView() {
		ShoppingCart cart = this.getCm().getCart();
		List<Article> articlesAdded = new ArrayList<Article>();
		if(this.getCm().getCart().getCart().size() > 0) {
			int i = 0;
			for (Article article : cart.getCart()) {
				boolean b = false;
				for(Article addedArticle : articlesAdded) {
					if(article.equals(addedArticle)) {
						b = true;
						break;
					}
				}
				if(!b) {
					int sac = this.getCm().getCart().getSameArticleCount(article);
					this.getCv().getCheckoutCartPanel().addArticleView(
							i, 
							article.getArtnum(), 
							article.getTitle(), 
							String.valueOf(sac), 
							String.format("%,.2f",article.getPrice()), 
							String.format("%,.2f",article.getPrice()*sac));
					articlesAdded.add(article);
					i++;
				}
			}
			this.getCv().setLblTotalAmount(String.format("%,2.2f", cart.getTotalAmount()) + " \u20AC");
		}
	}
	
	public void addButtonListeners() {
		// back to cart button
		this.getCv().getBtnBack2Cart().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShoppingCartModel scm = new ShoppingCartModel();
				ShoppingCartView scv = new ShoppingCartView();
				new ShoppingCartController(scm,scv,getShopPanel());
				getShopPanel().remove(1);
				getShopPanel().add(scv);
				getShopPanel().validate();
			}			
		});
		
		// buy button
		this.getCv().getBtnSendOrder().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = getCv().getTfName().getText();
				String firstname = getCv().getTfFirstname().getText();
				String street = getCv().getTfStreet().getText();
				String zip = getCv().getTfZip().getText();
				String city = getCv().getTfCity().getText();
				String addressadd = getCv().getTfAddressadd().getText();
				String phone = getCv().getTfPhone().getText();;
				if(!name.isBlank() 
						&& !firstname.isBlank()
						&& !street.isBlank()
						&& !zip.isBlank()
						&& !city.isBlank()
						&& getCv().getCbxAgree().isSelected()
						) {
					Customer customer = new Customer(name,firstname,street,Integer.parseInt(zip),city,addressadd,phone);
					Booking booking = new Booking(getCm().getCart(),customer);
					ServiceFactory svc = ServiceFactory.getInstance();
					try {
						booking = svc.getBookingService().checkout(booking);
						if(booking.getId() > 0) {
							String totalAmount = String.format("%,.2f",booking.getCart().getTotalAmount());
							String bookingId = String.valueOf(booking.getId());
							BookingModel bm = new BookingModel(booking);
							BookingView bv = new BookingView(bookingId, totalAmount);
							new BookingController(bm,bv,getShopPanel());
							
							getCm().getCart().emptyCart();
							
							getShopPanel().remove(1);
							getShopPanel().add(bv);
							getShopPanel().validate();
							
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
			
		});
	}
}
