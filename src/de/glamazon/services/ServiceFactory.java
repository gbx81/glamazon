package de.glamazon.services;

public final class ServiceFactory {
	private final static ServiceFactory instance = new ServiceFactory();
	
	private ArticleService articleService;
	private BookingService bookingService;
	private CategoryService categoryService;
	private CustomerService customerService;
	private EmployeeService employeeService;
	private ShoppingCartService shoppingCartService;	
	
	private ServiceFactory() {
		this.setArticleService(new ArticleService());
		this.setBookingService(new BookingService());
		this.setCategoryService(new CategoryService());
		this.setCustomerService(new CustomerService());
		this.setEmployeeService(new EmployeeService());
		this.setShoppingCartService(new ShoppingCartService());
	}
		
	public ArticleService getArticleService() {
		return articleService;
	}

	private void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public BookingService getBookingService() {
		return bookingService;
	}

	private void setBookingService(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	private void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	private void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	private void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}

	private void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	public static ServiceFactory getInstance() {
		return instance;
	}
}
