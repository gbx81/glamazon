package de.glamazon.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.glamazon.pojo.Article;
import de.glamazon.pojo.ShoppingCart;

public final class ShoppingCartService extends Services {
	
	/**
	 * Method first creates ShoppingCart ID to table ShoppingCart and then inserts all articles from cart 
	 * into table ShoppingCart_Articles with ShoppingCart ID, article ID and article count. Will perform
	 * a rollback on fail of any SQL transaction.
	 * @param cart:
	 * accepts only object of ShoppingCart
	 * @return
	 * returns ShoppingCart ID, 0 if any SQL transaction fails
	 * @throws SQLException
	 */
	public int addShoppingCart(ShoppingCart cart) throws SQLException {
		int cartID = dbm.nocommitInsert("shoppingcart", new String[] {"id"}, new String[] {null});
		if(cartID > 0) {
			List<Article> insArt = new ArrayList<Article>();
			for (Article cArticle : cart.getCart()) {
				boolean b = false;
				for(Article iArticle : insArt) {
					if(cArticle.equals(iArticle)) {
						b = true;
						break;
					}
				}
				if(b) {
					continue;
				}
				else {
					insArt.add(cArticle);
					int artCount = cart.getSameArticleCount(cArticle);					
					int rowID = dbm.nocommitInsert("ShoppingCart_Articles", 
							new String[] {"ShoppingCartID", "ArticleID", "ArticleCount", "ArticlePrice"}, 
							new String[] {
									String.valueOf(cartID), 
									String.valueOf(cArticle.getId()), 
									String.valueOf(artCount),
									String.valueOf(cArticle.getPrice())
							}
					);
					if(rowID == 0) {
						cartID = 0;
						break;
					}
				}
			}
			if(cartID == 0) {
				dbm.rollback();
			}
			else {
				dbm.commit();
			}
		}
		return cartID;
	}
}
