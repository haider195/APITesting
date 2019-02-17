package APITesting;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITest {
	
	@Test
		
	
	public void test1() {
		
	RequestSpecification request=RestAssured.given();
	request.header("Content-Type","application/json");
	
	
	JSONObject json = new JSONObject();
	json.put("id", (int)(Math.random()*50+5));

	json.put("title", "haider");
	json.put("author", "abdullah");
	
	request.body(json.toString());
	
	Response response = request.post("http://localhost:3000/posts");
	
	int code = response.getStatusCode();

	Assert.assertEquals(code,201);
	
	System.out.println("code is" +code);
	
	
	}
	
	@Test
	
	public void print1() {
		
	Response prn =RestAssured.get("http://localhost:3000/posts/6.092895710153657");
	
	String code = prn.asString();
	
	System.out.println("data is"  +code);
	
	System.out.println("Response time is"  +prn.getTime());
		
	}
	
	@Test
	
	public void delete() {
		
		Response Delete = RestAssured.delete("http://localhost:3000/posts/2");
		
		int code = Delete.getStatusCode();
		
		Assert.assertEquals(code, 200);
		
		System.out.println("my code is" +code);
		
		
	}
	
@Test
		
	
	public void put() {
		
	RequestSpecification request=RestAssured.given();
	request.header("Content-Type","application/json");
	
	
	JSONObject json = new JSONObject();
	json.put("id", "45.32401889405272");

	json.put("title", "talha");
	json.put("author", "hasan");
	
	request.body(json.toString());
	
	Response response = request.put("http://localhost:3000/posts/45.32401889405272");
	
	int code = response.getStatusCode();

	Assert.assertEquals(code,200);
	
	System.out.println("code is" +code);
	

}
}