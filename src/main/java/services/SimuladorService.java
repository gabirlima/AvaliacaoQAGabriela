package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SimuladorService {

    private final String ENDPOINT = "http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador";

    public Response simularInvestimento(){
        return given()
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(ENDPOINT)
                .then()
                .log().all()
                .extract().response();
    }
}
