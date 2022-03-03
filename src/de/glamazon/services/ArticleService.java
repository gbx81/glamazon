package de.glamazon.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.glamazon.pojo.Article;
import de.glamazon.pojo.Category;

public class ArticleService extends Services {
	
	public Article addArticle(Article article) throws SQLException {	
		int rowID = super.dbm.nocommitInsert("Article", 
				new String[] {"title", "price", "stock", "artnum", "description"},
				new String[] {article.getTitle(), 
						String.valueOf(article.getPrice()), 
						String.valueOf(article.getStock()), 
						article.getArtnum(), 
						article.getDescription()}
		);
		boolean err = false;
		if( rowID > 0) {
			article.setId(rowID);
			for (Category category : article.getCategories()) {
				int ins = super.dbm.nocommitInsert("Article_Categories", 
						new String[] {"ArticleID","CategoryID"}, 
						new String[] {String.valueOf(rowID), String.valueOf(category.getId())});
				if(ins == 0) {
					err = true;
					break;
				}
			}
		}
		else {
			err = true;
		}
		if(err) {
			article = null;
			super.dbm.rollback();
		}
		else {
			super.dbm.commit();
		}
		return article;
	}
	
	public boolean updateArticle(Article article) throws SQLException {
		boolean er = false;
		boolean upd = super.dbm.nocommitUpdate("Article", 
				new String[] {"title", "price", "stock", "artnum", "description"},
				new String[] {article.getTitle(), 
						String.valueOf(article.getPrice()), 
						String.valueOf(article.getStock()), 
						article.getArtnum(), 
						article.getDescription()},
				new String[] {"ID",String.valueOf(article.getId()),"="}
				);
		if(!upd) {
			er = true;
		}
		else {
			if(!super.dbm.nocommitDelete("Article_Categories", new String[] {"ArticleID", String.valueOf(article.getId()), "="})) {
				er = true;
			}
			for (Category category : article.getCategories()) {
				int ins = super.dbm.nocommitInsert("Article_Categories", 
						new String[] {"ArticleID","CategoryID"}, 
						new String[] {String.valueOf(article.getId()), String.valueOf(category.getId())});
				if( ins == 0) {
					er = true;
					break;
				}
			}			
		}
		if(er) {
			super.dbm.rollback();
		}
		else {
			super.dbm.commit();
		}
		return !er;
	}

	public boolean deleteArticle(Article article) throws SQLException {
		boolean r = false;
		boolean delart = super.dbm.nocommitDelete("Article", new String[] {"id",String.valueOf(article.getId()),"="});
		boolean delcats = super.dbm.nocommitDelete("Article_Categories", new String[] {"ArticleID",String.valueOf(article.getId()),"="});
		if(delart && delcats) {
			super.dbm.commit();
			article = null;
			r = true;
		}
		else {
			super.dbm.rollback();
		}
		return r;
	}
	
	public Article getArticleById(int id) throws SQLException {
		Article article = new Article();
		ResultSet rs = super.dbm.select("Article", 
				new String[] {"id", "title", "price", "stock", "artnum", "description", "image"},
				new String[] {"id",String.valueOf(id)}
		);
		
		if(rs.next()) {
			article.setId(rs.getInt("id"));
			article.setTitle(rs.getString("title"));
			article.setPrice(rs.getDouble("price"));
			article.setStock(rs.getInt("stock"));
			article.setArtnum(rs.getString("artnum"));
			article.setDescription(rs.getString("description"));
			article.setImage(rs.getBytes("image"));
			
			rs = super.dbm.select("Article_Categories", 
					new String[] {"CategoryID"}, 
					new String[] {"ArticleID",String.valueOf(article.getId())}
			);
			if(rs.next()) {
				do {
					CategoryService cs = new CategoryService();
					article.getCategories().add(cs.getCategoryById(rs.getInt("CategoryID")));
					
				} while(rs.next());
			}
		}
		return article;
	}
	
	public List<Article> getArticlesWithCategory(Category category) throws SQLException {
		List<Article> articles = new ArrayList<Article>();
		ResultSet rs = super.dbm.select("Article_Categories", 
				new String[] {"ArticleID"}, 
				new String[] {"CategoryID",String.valueOf(category.getId())}
		);
		
		if(rs.next()) {
			do {
				articles.add(this.getArticleById(rs.getInt("ArticleID")));
			} while(rs.next());
		}
		return articles;
	}	
}
