package de.glamazon.services;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.glamazon.pojo.Customer;

public final class CustomerService extends Services {
	
	public Customer addCustomer(Customer customer) throws SQLException {	
		int rowID = super.dbm.insert("Customer", 
				new String[] {"name","firstname","street","zip","city","addressadd","phone"},
				new String[] {customer.getName(),customer.getFirstname(),customer.getStreet(),
						String.valueOf(customer.getZip()),customer.getCity(),customer.getAddressadd(),
						customer.getPhone()
				}
		 );
		if( rowID > 0) {
			customer.setId(rowID);
		}
		return customer;
	}
	
	public Customer getCustomerById(int id) throws SQLException {
		Customer customer;
		ResultSet rs = super.dbm.select("Customer", 
				new String[] {"id","name","firstname","street","zip","city","addressadd","phone"}, 
				new String[] {"id",String.valueOf(id),"="}
		);
		
		if(rs.next()) {
			customer = new Customer(
				id,
				rs.getString("name"),
				rs.getString("firstname"),
				rs.getString("street"),
				rs.getInt("zip"),
				rs.getString("city"),
				rs.getString("addressadd"),
				rs.getString("phone")	
			);
		}
		else {
			customer = new Customer();
		}
		return customer;
	}
}
