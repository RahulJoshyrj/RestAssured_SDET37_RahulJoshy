package Authentcation;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oauth2_0 {
	
	@Test
	public void oauthAuthentication() {
		Response response=given()
				.formParam("client_id", "qwert")
				.formParam("client_secret","180c69b185a681fab02e712e40f9d11d")
				.formParam("grant_type","client_credentials")
				.formParam("redirect_uri","http://example.com")
				.formParam("code","3740")
				.when().post("http://coop.apps.symfonycasts.com/token");
		response.then().log().all();
		String token=response.jsonPath().get("access_token");

		System.out.println(token);

				given()
				.auth().oauth2(token)
				.pathParam("USER_ID","3740")
				.when().post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
				.then().log().all();
	}

}
