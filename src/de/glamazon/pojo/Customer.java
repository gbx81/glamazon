package de.glamazon.pojo;

public class Customer {
	int id;
	String name;
	String firstname;
	String street;
	int zip;
	String city;
	String addressadd;
	String phone;
	
	public Customer() {
		super();
	}
	
	public Customer(String name, String firstname, String street, int zip, String city, String adressadd, String phone) {
		this.setId(0);
		this.setName(name);
		this.setFirstname(firstname);
		this.setStreet(street);
		this.setZip(zip);
		this.setCity(city);
		this.setAddressadd(adressadd);
		this.setPhone(phone);
	}
	
	public Customer(int id, String name, String firstname, String street, int zip, String city, String addressadd, String phone) {
		this(name, firstname, street, zip, city, addressadd, phone);
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressadd() {
		return addressadd;
	}

	public void setAddressadd(String addressadd) {
		this.addressadd = addressadd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String toString() {
		return "ID: " + this.getId() + 
				"; Name: " + this.getName() +
				"; Firstname: " + this.getFirstname() +
				"; Street: " + this.getStreet() +
				"; ZIP: " + this.getZip() +
				"; City: " + this.getCity() +
				"; Add: " + this.getAddressadd() + 
				"; Phone: " + this.getPhone()
		;
	}
}
