package reqresAssignments;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostOperationInReqres {
	@Test
	public void putData() {
		baseURI="https://reqres.in";
		
		JSONObject jobj=new JSONObject();
		jobj.put("name", "RahulJoshy");
		jobj.put("job", "resident 2");
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("/api/users")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.assertThat().statusCode(201).log().all();
		
		
	}

}
