package de.glamazon.tests;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import de.glamazon.services.ArticleService;
import de.glamazon.services.BookingService;
import de.glamazon.services.CategoryService;
import de.glamazon.services.CustomerService;
import de.glamazon.services.EmployeeService;
import de.glamazon.services.ShoppingCartService;
import de.glamazon.util.DatabaseManager;

public class Testrange {

	public static void main(String[] args) {
//		DatabaseManager dbm = DatabaseManager.getInstance();
//		System.out.println(dbm.select("Employee", new String[] {"username","password"}, new String[] {"id","4","="}));
		
		EmployeeService es = new EmployeeService();
		CategoryService cs = new CategoryService();
		ArticleService as = new ArticleService();
		CustomerService cus = new CustomerService();
		ShoppingCartService scs = new ShoppingCartService();
		BookingService bs = new BookingService();
		
		
  
		try{			
			Connection conn = DatabaseManager.getInstance().getConnection();			
			String sql ="UPDATE Article SET image=? WHERE id=5";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			String file = "C:\\images\\nachttisch.jpg";
			preparedStatement.setBytes(1, readFile(file));
			
			if(preparedStatement.executeUpdate() > 0) {
				conn.commit();
			}
			preparedStatement.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			//System.out.println(cus.getCustomerById(1));
			
//			Customer cust = new Customer("Musk", "Elon", "Teslastraße 1", 34567, "Teslahausen", "nix", "+49 179 885 556 25");
//			System.out.println(cust);
//			ShoppingCart cart = new ShoppingCart();
//			
//			cart.addArticle(as.getArticleById(1));
//			cart.addArticle(as.getArticleById(2));
//			cart.addArticle(as.getArticleById(1));
//			cart.addArticle(as.getArticleById(1));
//			cart.addArticle(as.getArticleById(3));
//			System.out.println(cart);
//			
//			Booking booking = new Booking(cart, cust);
//			
//			System.out.println(bs.checkout(booking));
			
//			Configuration config = Configuration.getInstance();
//			System.out.println(config);
//			config.setLanguage("EN");
//			System.out.println(config);
						
//			cart.removeSingleArticle(cart.getSingleArticleByIndex(0));
//			System.out.println(cart);
//			cart.removeAllOfArticle(cart.getSingleArticleByIndex(0));
//			System.out.println(cart);
			//System.out.println(scs.addShoppingCart(cart));
			
			//System.out.println(cart.getSameArticleCount(cart.getSingleArticleByIndex(1)));
			
			//System.out.println(scs.addShoppingCart(cart));
			
//			List<Employee> employees = es.getAllEmployees();
//			
//			for (Employee employee : employees) {
//				System.out.println(employee.toString());
//			}
//			Employee e1 = es.getEmployeeById(3);
//			System.out.println(e1.getPassword());
//			e1.setPassword("dudeldum");
//			if(es.login(e1)) {
//				System.out.println("eingelogged alta");
//			}
//			else {
//				System.out.println("nope... nochmal ran du noob :P");
//			}
//			
			
//			e1 = es.getEmployeeById(3);
//			System.out.println(e1.getPassword());
			
//			Employee e1 = new Employee("User4","meinPW");
//			if(es.addEmployee(e1) != null) {
//				System.out.println(e1);
//			}
//			else {
//				System.out.println("failed du noob...");
//			}
			
//			Category cat1 = cs.getCategoryByName("NonFood");
//			
//			if(cs.deleteCategory(cat1)) {
//				System.out.println("jup");
//			}
//			else {
//				System.out.println("nope... du noob");
//			}
//			System.out.println(cat1 == null);
			
//			List<Category> cats = cs.getAllCategories();
//			//cats.remove(0);
//			System.out.println(cats);
//			
//			Article art = new Article();
//			art.setArtnum("DEL884834");
//			art.setCategories(cats);
//			art.setDescription("Artikel zum löschen \"Wegwerfer\"");
//			art.setPrice(49.9);
//			art.setStock(10);
//			art.setTitle("Kann direkt in die Tonne"); 
//			
//			System.out.println(art);
//			
//			System.out.println(art = as.addArticle(art));
			
			//System.out.println(cs.getCategoryById(9));
			
//			System.out.println(as.getArticleById(6));
//			Article art = as.getArticleById(7);
//			System.out.println(art);
//			if(as.deleteArticle(art)) {
//				art = as.getArticleById(7);
//				if(art != null) {
//					System.out.println(art);
//				}
//			}
			
//			Category cat = cs.getCategoryById(1);
//			
//			List<Article> articles = as.getArticlesWithCategory(cat);
//			for (Article article : articles) {
//				System.out.println(article);
//			}
			
			
			
			
			
			
			
//			if((cat1 = cs.addCategory(cat1)) != null) {
//				
//				System.out.println(cat1);
//			}
//			else {
//				System.out.println("failed du noob...");
//			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
    }
}
