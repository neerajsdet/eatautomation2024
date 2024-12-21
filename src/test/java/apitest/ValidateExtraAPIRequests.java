package apitest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ValidateExtraAPIRequests {
    public String urlGetRequest1 = "https://fakerestapi.azurewebsites.net/api/v1/Books/100";
    public String urlGetRequest2 = "https://fakerestapi.azurewebsites.net/api/v1/Books/$10";


    @Test
    public void verifyResponseCodeOfGivenGetRequest(){
        given()
                .when()
                .get(urlGetRequest1)
                .then()
                .statusCode(200);

    }
}
