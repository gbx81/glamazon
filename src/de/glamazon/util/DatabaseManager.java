package de.glamazon.util;

import java.sql.*;

public final class DatabaseManager {
	private final static DatabaseManager instance = new DatabaseManager();
	private String host;
	//private String dbClass;
	private Connection connection;
	PreparedStatement pstmt;
	
	private DatabaseManager () {
		host = "jdbc:sqlite:C:\\Databases\\glamazon\\glamazondb.db";
		//dbClass = "org.sqlite.JDBC";
		connection = null;	
		try {
			openConnection();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public static DatabaseManager getInstance() {
		return instance;
	}
		
	/**
	 * Performs a SQL SELECT 
	 * @param table
	 * String, name of the table
	 * @param fields
	 * String[], column names to select
	 * @param where
	 * String[], accepts 2 or 3 values. with 2 values "=" will be used as operator. 
	 * optional third value can be any SQL operator (<, >, <>, LIKE,...)
	 * @return
	 * returns ResultSet
	 * 
	 */
	public ResultSet select(String table, String fields[], String where[]) throws SQLException{
		ResultSet rs = null;
		String sql = "SELECT ";
		sql += String.join(", ", fields) + " FROM " + table;

		if(where != null) {
			if(where.length > 1 && where.length < 4) {
				sql +=" WHERE ";
				if(where.length < 3) {
					sql += where[0] + " = ? ";
				}
				else {
					sql += where[0] + where[2] + "?";
				}
			}
		}
		//System.out.println(sql);
			
		pstmt = connection.prepareStatement(sql);
		if(where != null) {
			if(where.length > 1 && where.length < 4) {
				pstmt.setString(1, where[1]);
			}
		}
		//System.out.println("Daten werden abgerufen");
		rs = pstmt.executeQuery();
		
		return rs;
	}
	
	/**
	 * checks for existing entry, returns boolean
	 * @param table
	 * @param field
	 * @param value
	 * @return
	 * @throws SQLException
	 */
	public boolean exists(String table, String field, String value) throws SQLException{
		ResultSet rs = this.select(table, new String[] {field}, new String[] {field,value});
		if(rs.next()) {
			return true;
		}
		return false;
	}
	
	/**
	 * will do an insert without commit for possible rollback
	 * @param table
	 * @param fields
	 * @param values
	 * @return
	 * returns rowID of insert, 0 on fail
	 */
	public int nocommitInsert(String table, String fields[], String values[]) throws SQLException{ 
		int rowID = 0;
		if(fields.length == values.length) {
			String sql = "INSERT INTO " + table + " (";
			sql += String.join(", ", fields) + ") VALUES (";
			for (int i = 0; i < values.length -1; i++) {
				sql += "?, ";
			}
			sql += "?) ";
			//System.out.println(sql);
			
			pstmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			for(int i = 0; i < values.length; i++) {
				pstmt.setString(i + 1, values[i]);
			}
			if(pstmt.executeUpdate() > 0) {
				ResultSet rs=pstmt.getGeneratedKeys();
				if(rs.next()){
					rowID = rs.getInt(1);
				}
			}
		}
		return rowID;
	}
	
	/**
	 * SQL insert including commit
	 * @param table
	 * @param fields
	 * @param values
	 * @return
	 * returns rowID of insert, 0 on fail
	 * @throws SQLException
	 */
	public int insert(String table, String fields[], String values[]) throws SQLException {
		int ins = nocommitInsert(table, fields, values);
		if(ins > 0) {
			this.commit();
		}
		return ins;
	}
	
	public boolean nocommitUpdate(String table, String fields[], String values[], String where[]) throws SQLException{
		boolean r = false;
		if(where != null) {
			if(fields.length == values.length && where.length == 3) {
				String sql = "UPDATE " + table + " SET ";
				for(int i = 0; i < fields.length-1; i++) {
					sql += fields[i] + "=?, ";
				}
				sql += fields[fields.length - 1] + "=? ";
				sql += "WHERE " + where[0] + where[2] + "'" + where[1] + "'";
				// System.out.println(sql);
				
				pstmt = connection.prepareStatement(sql);
				for(int i = 0; i < values.length; i++) {
					pstmt.setString(i + 1, values[i]);
				}
				if(pstmt.executeUpdate() > 0) {
					r = true;
				}
			}
		}
		return r;
	}
	
	public boolean update(String table, String fields[], String values[], String where[]) throws SQLException {
		boolean r = false;
		if(nocommitUpdate(table,fields,values,where)) {
			r = true;
		}
		this.commit();
		return r;
	}
	
	//
	
	public boolean nocommitDelete(String table, String where[]) throws SQLException{
		boolean r = false;
		if(where != null) {
			if(where.length > 1 && where.length < 4) {
				String sql = "DELETE FROM " + table + " ";
				sql += "WHERE " + where[0] + where[2] + "'" + where[1] + "'";
				//System.out.println(sql);
				
				pstmt = connection.prepareStatement(sql);
				if(pstmt.executeUpdate() > 0) {
					r = true;
				}
			}
		}
		return r;
	}
	
	public boolean delete(String table, String where[]) throws SQLException {
		boolean r = false;
		if(nocommitDelete(table,where)) {
			this.commit();
			r = true;
		}
		return r;
	}
	
	private void openConnection() throws SQLException {
		if(connection == null) {
			connection = DriverManager.getConnection(host);
			if(connection == null) {
				System.out.println("Verbindung fehlgeschlagen");
			}
			else {
				System.out.println("Verbindung zur Datenbank hergestellt");
				connection.setAutoCommit(false);
			}
		}
	}
	
	public void closeConnection() throws SQLException{
		if(pstmt != null) {
			pstmt.close();
		}
		
		if(connection != null) {
			connection.commit();
			connection.setAutoCommit(true);
			connection.close();
			if(connection.isClosed()) {
				System.out.println("Verbindung wurde getrennt");
			}
			connection = null;
		}
	}	
	
	public void commit() throws SQLException {
		if(connection != null) {
			connection.commit();
		}
	}
	
	public void rollback() throws SQLException {
		if(connection != null) {
			connection.rollback();
		}
	}
}
