package reqresAssignments;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PutOperationInReqres {
	@Test
	public void putOperation() {
		JSONObject jobj=new JSONObject();
		jobj.put("name", "RahulJoshy");
		jobj.put("job", "Bangalore resident");
		baseURI="https://reqres.in";
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("/api/users/52")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
}
