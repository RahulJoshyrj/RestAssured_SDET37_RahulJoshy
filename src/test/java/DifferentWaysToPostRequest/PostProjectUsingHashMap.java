package DifferentWaysToPostRequest;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostProjectUsingHashMap {
	@Test
	public void postUsingHasMap() {
		JavaUtility jLib=new JavaUtility();
		baseURI="http://localhost";
		port=8084;
		HashMap map=new HashMap();
		map.put("createdBy", "RahulJoshy");
		map.put("projectName", "Stark"+jLib.getRandomNumber());
		map.put("status", "Created");
		map.put("teamSize", "50");
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
		
		
	}
}
