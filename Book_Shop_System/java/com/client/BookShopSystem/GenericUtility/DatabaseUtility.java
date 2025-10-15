package com.client.BookShopSystem.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class DatabaseUtility {
	 public Connection con;
	public Statement st;
	
	//method for connection to database
	public void connectToTheDataBase(String url, String username , String password)  {
		try {
		Driver d= new Driver();
		DriverManager.registerDriver(d);
		  con = DriverManager.getConnection(url, username, password);
		 st=con.createStatement();
		}
	     catch(Exception e) {
	    	 
	     }}
		// method for connection database
		public void connectToTheDataBase() {
			try {
				Driver d= new Driver();
				DriverManager.registerDriver(d);
				FileUtility flib= new FileUtility();
				String URL=flib.getDataFromPropertyFile("url");
				String USERNAME=flib.getDataFromPropertyFile("username");
				String PASSWORD=flib.getDataFromPropertyFile("password");
				con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				st= con.createStatement();
			}
				catch(Exception e) {
				
			}}
		
		//close the connection 
			public void closeConnection() {
				try {
					con.close();
	            }
				catch(Exception e) {
					}}
			
				public  ResultSet executeSelectQuery(String query) {
				ResultSet result = null;
				
				try{
					  st =con.createStatement();
					  result=  st.executeQuery(query);
					
				}
				catch(Exception e) {
					}
				
				return result;
				}
			
			public int executeNonSelectQuery(String query) {
				int result=0;
				try {
					 st =con.createStatement();
					  result=  st.executeUpdate(query);
					}
				catch(Exception e) {
					}
			   return result;
			    }
}

