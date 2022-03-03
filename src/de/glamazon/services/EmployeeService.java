package de.glamazon.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import de.glamazon.pojo.Employee;

public final class EmployeeService extends Services {
	
	public Employee addEmployee(Employee employee) throws SQLException {	
		String hashedPassword = BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt(15));
		employee.setPassword(hashedPassword);
		int rowID = super.dbm.insert("Employee", 
				new String[] {"username","password"},
				new String[] {employee.getUsername(), hashedPassword}
		 );
		if( rowID > 0) {
			employee.setId(rowID);
		}
		return employee;
	}
	
	public boolean updateEmployee(Employee employee) throws SQLException {
		String hashedPassword = BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt(15));
		employee.setPassword(hashedPassword);
		return super.dbm.update("Employee", 
				new String[] {"username","password"}, 
				new String[] {employee.getUsername(), hashedPassword}, 
				new String[] {"id",Integer.toString(employee.getId()),"="}
		);
	}
	
	public boolean deleteEmployee(Employee employee) throws SQLException {
		return super.dbm.delete("Employee", new String[] {"id",Integer.toString(employee.getId()),"="});
	}
	
	public Employee getEmployeeById(int id) throws SQLException {
		Employee employee = new Employee();
		ResultSet rs = super.dbm.select("Employee", 
				new String[] {"username", "password"}, 
				new String[] {"id",Integer.toString(id),"="}
		);
		if(rs.next()) {
			System.out.println("lala");
			employee.setId(id);
			employee.setUsername(rs.getString("username"));
			employee.setPassword(rs.getString("password"));
		}		
		return employee;
	}
	
	public Employee getEmployeeByName(String username) throws SQLException {
		Employee employee = new Employee();
		ResultSet rs = super.dbm.select("Employee", 
				new String[] {"id", "password"}, 
				new String[] {"username",username,"="}
		);
		
		try {
			if(rs.next()) {
				employee.setId(rs.getInt("id"));
				employee.setUsername(username);
				employee.setPassword(rs.getString("password"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		ResultSet rs = super.dbm.select("Employee", 
				new String[] {"id", "username", "password"}, 
				null
		);
		if(rs.next()) {
			do {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				employees.add(new Employee(id,username,password));
			} while(rs.next());
		}
		return employees;
	}
	
	public boolean login(Employee employee) throws SQLException {
		boolean r = false;
		if(employee.getPassword() != null && employee.getPassword() != "") {
			ResultSet rs = super.dbm.select("Employee", 
											new String[] {"password"}, 
											new String[] {"username",employee.getUsername()}
											);
			if(rs.next()) {
				String pw = rs.getString("password");
				if (BCrypt.checkpw(employee.getPassword(), pw)) {
					r = true;
				}
			}
		}
		return r;
	}
}