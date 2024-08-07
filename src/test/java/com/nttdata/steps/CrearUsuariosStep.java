package com.nttdata.steps;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class CrearUsuariosStep {

    private static String CREATE_USER = "https://petstore.swagger.io/v2/user";
    private Response response;
    private String bodyNuevoUsuario;

    public void preparaBody(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus){
        bodyNuevoUsuario = "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"username\": \""+username+"\",\n" +
                "  \"firstName\": \""+firstName+"\",\n" +
                "  \"lastName\": \""+lastName+"\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"" + password + "\",\n" +
                "  \"phone\": \"" + phone + "\",\n" +
                "  \"userStatus\": " + userStatus + "\n" +
                "}";
    }

    public void createUser(){
        response = given().baseUri(CREATE_USER)
                .header("Content-Type", "application/json")
                .body(bodyNuevoUsuario)
                .when()
                .post()
                .then()
                .extract()
                .response();
    }

    public void validateResponse(int statusCode) {
        response.then().statusCode(statusCode);
    }
}
