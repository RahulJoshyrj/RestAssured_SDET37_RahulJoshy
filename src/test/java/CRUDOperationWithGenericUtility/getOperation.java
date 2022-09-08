package CRUDOperationWithGenericUtility;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.crm.genericUtilities.endPointsLibrary;

import io.restassured.http.ContentType;
@Test
public class getOperation  {
	public void getWithGeneric() {
		baseURI="http://localhost";
		port=8084;
		
		given().contentType(ContentType.JSON)
		.when().get(endPointsLibrary.getAllProject).then().assertThat().statusCode(200).assertThat().contentType(ContentType.JSON);
		
		
		
		
	}

}
