package de.glamazon.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.glamazon.pojo.Category;

public class CategoryService extends Services {
	
	public Category addCategory(Category category) throws SQLException {	
		int rowID = super.dbm.insert("Category", 
				new String[] {"title","description"},
				new String[] {category.getTitle(), category.getDescription()}
		 );
		if( rowID > 0) {
			category.setId(rowID);
		}
		else {
			category = null;
		}
		return category;
	}
	
	public boolean updateCategory(Category category) throws SQLException {
		return super.dbm.update("Category", 
				new String[] {"title","description"}, 
				new String[] {category.getTitle(), category.getDescription()}, 
				new String[] {"id",Integer.toString(category.getId()),"="}
		);
	}
	
	public boolean deleteCategory(Category category) throws SQLException {
		return super.dbm.delete("Category", new String[] {"id",Integer.toString(category.getId()),"="});
	}
	
	public Category getCategoryById(int id) throws SQLException {
		Category category = new Category();
		ResultSet rs = super.dbm.select("Category", 
				new String[] {"title", "description"}, 
				new String[] {"id",Integer.toString(id),"="}
		);
		try {
			if(rs.next()) {
				category.setId(id);
				category.setTitle(rs.getString("title"));
				category.setDescription(rs.getString("description"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return category;
	}
	
	public Category getCategoryByName(String title) throws SQLException {
		Category category = new Category();
		ResultSet rs = super.dbm.select("Category", 
				new String[] {"id", "description"}, 
				new String[] {"title",title,"="}
		);
		
		try {
			if(rs.next()) {
				category.setId(rs.getInt("id"));
				category.setTitle(title);
				category.setDescription(rs.getString("description"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return category;
	}
	
	public List<Category> getAllCategories() throws SQLException {
		List<Category> categories = new ArrayList<Category>();
		ResultSet rs = super.dbm.select("Category", 
				new String[] {"id", "title", "description"}, 
				null
		);
		if(rs.next()) {
			do {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				categories.add(new Category(id,title,description));
			} while(rs.next());
		}
		return categories;
	}
	
	
}
