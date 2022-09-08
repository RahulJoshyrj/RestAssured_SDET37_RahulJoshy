package dataDrivenTesting;

import com.crm.genericUtilities.JavaUtility;
import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POJOClass.PostProjectsPOJOClass;
import io.restassured.http.ContentType;

public class createMultipleProjectUsingDataProvider {
	@Test(dataProvider="getData")
	public void createProject(String createdBy, String projectName,String status,int teammSize) {
		JavaUtility jLib=new JavaUtility();
		PostProjectsPOJOClass pojo=new PostProjectsPOJOClass(createdBy,projectName+jLib.getRandomNumber(),status,teammSize);
		
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then().log().all();
		
		
		
	}
	
	@DataProvider(name="getData")
	public Object[][]data(){
		Object[][] data=new Object[4][4];
		data[0][0]="Rahul Joshy";
		data[0][1]="samsung";
		data[0][2]="Created";
		data[0][3]=12;
		
		data[1][0]="Rahul Joshy";
		data[1][1]="xiaomi";
		data[1][2]="Completed";
		data[1][3]=15;
		
		data[2][0]="Joshy Thomas";
		data[2][1]="ACER";
		data[2][2]="OnGoing";
		data[2][3]=25;
		
		data[3][0]="Jeevan";
		data[3][1]="AsuS";
		data[3][2]="Completed";
		data[3][3]=17;      
		
		return data;
		
	}

}
