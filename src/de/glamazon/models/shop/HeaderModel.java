package de.glamazon.models.shop;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.glamazon.pojo.Article;
import de.glamazon.pojo.Category;
import de.glamazon.services.ServiceFactory;

public class HeaderModel {
	private String categories[];
	private String searchString;
	private List<Article> searchResult;
	
	public HeaderModel() {
		ServiceFactory svc = ServiceFactory.getInstance();
		searchResult = new ArrayList<Article>();
		try {
			setCategories(svc.getCategoryService().getAllCategories());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void setCategories(List<Category> categories){
		List<String> helper = new ArrayList<String>();
		boolean b = true;;
		for (Category category : categories) {
			if(b) {
				helper.add("Kategorie wählen");
				helper.add(category.getTitle());
				b = false;
			}
			else {
				helper.add(category.getTitle());
			}
		}
		this.categories = helper.toArray(String[]::new);		
	}
	
	public String[] getCategories() {
		return categories;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public List<Article> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(List<Article> searchResult) {
		this.searchResult = searchResult;
	}
}
