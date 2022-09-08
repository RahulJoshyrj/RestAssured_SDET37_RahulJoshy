package CRUDOperationAndVerifyInDatabase;

import com.crm.genericUtilities.DataBaseUtility;
import com.crm.genericUtilities.JavaUtility;

import POJOClass.PostProjectsPOJOClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.sql.ResultSet;

import org.testng.annotations.Test;

public class PutOperationAndVerifyInDB {
	@Test
	public void PutAndIverifyInDB() throws Throwable {
		JavaUtility jLib=new JavaUtility();
		DataBaseUtility dLib=new DataBaseUtility();
		PostProjectsPOJOClass pojo=new PostProjectsPOJOClass("Jeevan","NewProject"+jLib.getRandomNumber(),"On Going",25);
		baseURI="http://localhost";
		port=8084;
		given().contentType(ContentType.JSON).body(pojo)
		.when().post("/addProject")
		.then().assertThat().statusCode(201).log().all();
		
		dLib.connectDB();
		String query="select * from project where created_by='Jeevan'and project_name like 'NewProject%'";
		ResultSet result = dLib.executeQuery(query); 
		while(result.next()) {
		System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getInt(6));
		}
		
	}

}
