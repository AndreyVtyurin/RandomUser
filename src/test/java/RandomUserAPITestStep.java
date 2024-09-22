import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RandomUserAPITestStep {
    private static final String URL = "https://randomuser.me/api/";

    public static Response getRandomUserByGender(String gender) {

        return given()
                .header("accept", "application/json")
                .queryParam("gender", gender)
                .get(URL)
                .then().extract().response();
    }
}
