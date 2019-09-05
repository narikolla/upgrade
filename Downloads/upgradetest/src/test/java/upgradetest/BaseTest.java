package upgradetest;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/* 
 * This base test is used to setup RestAssured request with Authorization 
 *
 */
public class BaseTest {
	public RequestSpecification RESTASSURED_REQUEST;

	public BaseTest() {
		try {
			System.out.println("Callig base test");
			Properties props = new Properties();
			props.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
 			RestAssured.baseURI = props.getProperty("api.uri");
			RestAssured.port = Integer.valueOf(props.getProperty("api.port"));
 			RESTASSURED_REQUEST = RestAssured.given().contentType(ContentType.JSON);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
