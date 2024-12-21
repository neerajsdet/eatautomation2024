package example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteApiRequest {

    public String urlDeleteRequest = "https://fakerestapi.azurewebsites.net/api/v1/Books/101";

    @Test
    public void VerifyResponseCodeForDeleteRequest(){
        given()
                .when()
                .delete(urlDeleteRequest)
                .then()
                .statusCode(200)
                .log()
                .body();
    }

}
