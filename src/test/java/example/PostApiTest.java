package example;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostApiTest {
    public static String urlPostRequest ="https://fakerestapi.azurewebsites.net/api/v1/Books";
    public static String contentType = "application/json";
    public static Map payload = null;


    @Test
    public static void validatePostRequestForBookApi(){
        payload = new HashMap();
        payload.put("id", "101");
        payload.put("title", "automation");
        payload.put("description", "EAT Batch of SDET");
        payload.put("pageCount", "100");
        payload.put("excerpt", "Test");
        payload.put("publishDate", "2024-12-21T15:15:09.338Z");

        given().contentType(contentType).body(payload)
                .when()
                .post(urlPostRequest)
                .then()
                .statusCode(200)
                .log()
                .body();

    }



    @Test
    public static void validatePostRequestForBookApiAndVerifyResponse(){
        payload = new HashMap();
        payload.put("id", "101");
        payload.put("title", "automation");
        payload.put("description", "EAT Batch of SDET");
        payload.put("pageCount", "100");
        payload.put("excerpt", "Test");
        payload.put("publishDate", "2024-12-21T15:15:09.338Z");

        given().contentType(contentType).body(payload)
                .when()
                .post(urlPostRequest)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("id", equalTo(101))
                .body("title", equalTo("automation"));

    }



    @Test
    public static void validateResponseCodeInPostMethod(){
        payload = new HashMap();
        payload.put("id", "101");
        payload.put("title", "Book 101");
        payload.put("description", "this book we are creating for testing purpose");
        payload.put("pageCount", "1");
        payload.put("excerpt", "testing");
        payload.put("publishDate","2023-12-16T16:44:59.059Z");

        given().contentType(contentType).body(payload)
                .when()
                .post(urlPostRequest)
                .then()
                .statusCode(200);
    }


}
