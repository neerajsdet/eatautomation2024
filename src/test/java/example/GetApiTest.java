package example;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetApiTest {


    public String urlGetRequest1 = "https://fakerestapi.azurewebsites.net/api/v1/Books/200";
    public String urlGetRequest2 = "https://fakerestapi.azurewebsites.net/api/v1/Books/$10";


    @Test
    public void verifyResponseCodeOfGivenGetRequest(){
        given()
                .when()
                .get(urlGetRequest1)
                .then()
                .statusCode(200);
    }

    //negative test case
    @Test
    public void verifyResponseCodeForInvalidURL(){
        given()
                .when()
                .get(urlGetRequest2)
                .then()
                .statusCode(400);
    }

    @Test
    public void verifyAuthrization(){
        given().auth()
                .basic("user1", "user1Pass")
                .when()
                .get(urlGetRequest1)
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void verifyGetRequestWithBasicAuthentication(){
        given()
                .auth()
                .basic("abc@gmail.com", "123456")
                .when()
                .get(urlGetRequest1)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("id", equalTo(200))
                .body("title", equalTo("Book 200"));
    }

    @Test
    public void verifyIDValueInResponseOfGivenGetRequest(){
        given()
                .when()
                .get(urlGetRequest1)
                .then()
                .statusCode(200)
                .log()
                .body()
                .body("id", equalTo(100))
                .body("title", equalTo("Book 100"));
    }

    @Test
    public void verifyResponseUsingAssert(){
        Response res = given()
                .when()
                .get(urlGetRequest1)
                .then()
                .statusCode(200)
                .log()
                .body().extract().response();

        String output = res.asString();

        //Assert.assertTrue(output.contains("Book 100"));
        boolean flag = false;
        if(output.contains("Book 100")){
            System.out.println("Response Matched Successfully");
            flag = true;
        }else {
            System.out.println("Response Match Failed");
        }

        Assert.assertTrue(flag);
    }


}
