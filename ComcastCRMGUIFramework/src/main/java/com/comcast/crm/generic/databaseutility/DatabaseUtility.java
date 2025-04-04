package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	
	Connection con;
	
	public void getDbconnection(String url, String username,String password) throws SQLException {
		try {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		
		 con=DriverManager.getConnection(url, username, password);
      }catch(Exception e) {
    	  
      }
	}
	public void getDbconnection() {
		try {
			Driver diverref=new Driver();
			DriverManager.registerDriver(diverref);
			
			con=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root", "root");
		}catch (Exception e){
			
			
		}
	}
		
		public void closeDbconnection() throws SQLException {
			try {
			con.close();
			}catch(Exception e) {
				
			}
	}
		
		public ResultSet executeSelectQuery(String query) throws Throwable {
			ResultSet result=null;
			try {
		Statement stat = con.createStatement();
		 result = stat.executeQuery(query);
			}catch (Exception e) {
				
			}
		return result;
	}
		
		public int executeNonselectQuery(String query) {
			int result=0;
			try {
				Statement stat=con.createStatement();
				 result = stat.executeUpdate(query);
			}catch(Exception e) {
			
			}
			
			return result;
		}
		
		
		
}