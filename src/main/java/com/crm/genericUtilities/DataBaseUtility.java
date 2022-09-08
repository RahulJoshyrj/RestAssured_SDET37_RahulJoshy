package com.crm.genericUtilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	static Driver driver;
	static Connection connection;
	static ResultSet resultset;
	public void connectDB() {
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			Reporter.log("connection is successful",true);
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	public void closeDB() {
		try {
			connection.close();
			Reporter.log("connection closed",true);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ResultSet executeQuery(String query) throws Throwable {
		ResultSet result = connection.createStatement().executeQuery(query);
		return result;
	}
	public int executeUpdate(String query) throws Throwable {
		int result = connection.createStatement().executeUpdate(query);
		return result;
	}
	
}
