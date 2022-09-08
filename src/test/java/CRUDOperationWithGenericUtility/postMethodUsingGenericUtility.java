package CRUDOperationWithGenericUtility;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;
import com.crm.genericUtilities.endPointsLibrary;

import POJOClass.PostProjectsPOJOClass;
import io.restassured.http.ContentType;

public class postMethodUsingGenericUtility {
	@Test
 public void post() {
	 baseURI="http://localhost";
	 port=8084;
	 JavaUtility jLob=new JavaUtility();
	 PostProjectsPOJOClass pojo=new PostProjectsPOJOClass("ANUTOMy","aiden"+jLob.getRandomNumber(),"On Going",10);
	 
	 given().contentType(ContentType.JSON).body(pojo)
	 .when().post(endPointsLibrary.createProject).then().assertThat().statusCode(201).assertThat().contentType(ContentType.JSON).log().all();
	 
 }
}
