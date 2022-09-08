package com.crm.genericUtilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;

public class BaseAPI {
	
	public DataBaseUtility dLib=new DataBaseUtility();
	public JavaUtility jLib=new JavaUtility();
	public RestAssuredLibrary rLib=new RestAssuredLibrary();
	
	@BeforeSuite
	public void bsConfig() {
		dLib.connectDB();
		baseURI="http://localhost";
		port=8084;
	}
	@AfterSuite
	public void asConfig() {
		dLib.closeDB();
		
	}

}
