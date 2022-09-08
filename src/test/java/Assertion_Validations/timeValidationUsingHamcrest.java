package Assertion_Validations;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class timeValidationUsingHamcrest {
	@Test
	public void timeValidation() {
		baseURI="http://localhost";
		port=8084;
		
		when()
		.get("/projects")
		
		.then()
		.assertThat().time(lessThan(2000L),TimeUnit.MILLISECONDS)
		.log().all()
		.assertThat().statusCode(equalTo(200))
		.assertThat().contentType(ContentType.JSON);
		
	}

}
