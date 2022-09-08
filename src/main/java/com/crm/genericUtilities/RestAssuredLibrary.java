package com.crm.genericUtilities;

import io.restassured.response.Response;

public class RestAssuredLibrary {
	public String getJSONData(Response response,String path) {
		String jsonData=response.jsonPath().get(path);
		return jsonData;
				
	}

}
