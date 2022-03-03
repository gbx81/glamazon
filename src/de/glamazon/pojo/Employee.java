package de.glamazon.pojo;

public final class Employee {
	private String username;
	private String password;
	private int id;
	
	public Employee() {
		super();
	}
	public Employee(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		this.setId(0);
	}
	public Employee(int id, String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		this.setId(id);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		String edata = "ID: " + this.getId() + "; Uname: " + this.getUsername() + "; Pwd: " + this.getPassword() + ";";
		return edata;
	}
}
