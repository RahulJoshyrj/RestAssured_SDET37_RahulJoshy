package Authentcation;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BearerToken {
	@Test
	public void oauthAuthentication()
	{
		baseURI="https://api.github.com";
		JSONObject obj=new JSONObject();
		obj.put("name", "RahulJoshyrj");
		given().auth().oauth2("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")
		.body(obj)
		.contentType(ContentType.JSON)
		
		.when().post("/user/repos")
		.then().log().all();
	}
}
