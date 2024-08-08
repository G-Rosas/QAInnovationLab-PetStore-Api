package com.nttdata.steps;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CrearStoreOrderStep {

    private static final String BASE_URI = "https://petstore.swagger.io/v2/store";
    private Response response;
    private String bodyNuevoOrder;
    private int orderId;

    public void preparaBody(int id, int quantity, String status, String shipDate, boolean complete){
        bodyNuevoOrder = "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"quantity\": " + quantity + ",\n" +
                "  \"shipDate\": \"" + shipDate + "\",\n" +
                "  \"status\": \"" + status + "\",\n" +
                "  \"complete\": " + complete + "\n" +
                "}";
    }

    public void createOrder(){
        response = given().baseUri(BASE_URI)
                .basePath("/order")
                .header("Content-Type", "application/json")
                .body(bodyNuevoOrder)
                .when()
                .post()
                .then()
                .extract()
                .response();
    }

    public void verifyStatusCode(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    public void verifyResponseBody(int id, int quantity, String status, String shipDate, boolean complete) {
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("\"id\": " + id));
        assertTrue(responseBody.contains("\"quantity\": " + quantity));
        assertTrue(responseBody.contains("\"shipDate\": \"" + shipDate + "\""));
        assertTrue(responseBody.contains("\"status\": \"" + status + "\""));
        assertTrue(responseBody.contains("\"complete\": " + complete));
    }

    public void getOrder(int orderId) {
        response = given().baseUri(BASE_URI)
                .basePath("/order/" + orderId)
                .when()
                .get()
                .then()
                .extract()
                .response();
    }

    public void verifyResponseBody(int id) {
        String responseBody = response.getBody().asString();
        assertTrue(responseBody.contains("\"id\": " + id));
    }

    public void setOrderId(int id) {
        this.orderId = id;
    }

    public void verifyPostEndpointIsAvailable() {
        response = given().baseUri(BASE_URI)
                .basePath("/order")
                .header("Content-Type", "application/json")
                .body("{}")
                .when()
                .post()
                .then()
                .extract()
                .response();

        assertEquals(405, response.getStatusCode());
    }

    public void verifyGetEndpointIsAvailable() {
        response = given().baseUri(BASE_URI)
                .basePath("/order/1")
                .when()
                .get()
                .then()
                .extract()
                .response();

        assertEquals(200, response.getStatusCode());
    }
}
