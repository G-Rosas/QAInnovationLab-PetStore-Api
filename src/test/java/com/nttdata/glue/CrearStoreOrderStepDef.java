package com.nttdata.glue;

import com.nttdata.steps.CrearStoreOrderStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CrearStoreOrderStepDef {

    @Steps
    CrearStoreOrderStep crearStoreOrderStep;

    @Given("el endpoint POST order está disponible")
    public void elEndpointPOSTStoreOrderEstáDisponible() {
        crearStoreOrderStep.verifyPostEndpointIsAvailable();
    }

    @When("se envía una solicitud POST al endpoint order con los siguientes datos:")
    public void seEnvíaUnaSolicitudPOSTAlEndpointOrderConLosSiguientesDatos(io.cucumber.datatable.DataTable dataTable) {
        int orderId = Integer.parseInt(dataTable.cell(1, 0));
        int quantity = Integer.parseInt(dataTable.cell(1, 1));
        String status = dataTable.cell(1, 2);
        String shipDate = dataTable.cell(1, 3);
        boolean complete = Boolean.parseBoolean(dataTable.cell(1, 4));

        crearStoreOrderStep.preparaBody(orderId, quantity, status, shipDate, complete);
        crearStoreOrderStep.createOrder();
    }

    @Then("la respuesta debe tener un código de estado {int}")
    public void laRespuestaDebeTenerUnCódigoDeEstado(int statusCode) {
        crearStoreOrderStep.verifyStatusCode(statusCode);
    }

    @And("la respuesta debe contener una Order con los mismos datos enviados")
    public void laRespuestaDebeContenerUnaOrderConLosMismosDatosEnviados(io.cucumber.datatable.DataTable dataTable) {
        int orderId = Integer.parseInt(dataTable.cell(1, 0));
        int quantity = Integer.parseInt(dataTable.cell(1, 1));
        String status = dataTable.cell(1, 2);
        String shipDate = dataTable.cell(1, 3);
        boolean complete = Boolean.parseBoolean(dataTable.cell(1, 4));

        crearStoreOrderStep.verifyResponseBody(orderId, quantity, status, shipDate, complete);
    }

    @Given("el endpoint GET order está disponible")
    public void elEndpointGETOrderEstáDisponible() {
        crearStoreOrderStep.verifyGetEndpointIsAvailable();
    }

    @And("se ha creado una Order con id {int}")
    public void seHaCreadoUnaOrderConId(int orderId) {
        crearStoreOrderStep.setOrderId(orderId);
    }

    @When("se envía una solicitud GET al endpoint order {int}")
    public void seEnvíaUnaSolicitudGETAlEndpointOrderOrderId(int orderId) {
        crearStoreOrderStep.getOrder(orderId);
    }

    @Then("la respuesta debe contener la Order con id {int}")
    public void laRespuestaDebeContenerLaOrderConIdOrderId(int orderId) {
        crearStoreOrderStep.verifyResponseBody(orderId);
    }

    @And("la Order debe tener los siguientes datos:")
    public void laOrderDebeTenerLosSiguientesDatos(io.cucumber.datatable.DataTable dataTable) {
        int orderId = Integer.parseInt(dataTable.cell(1, 0));
        int quantity = Integer.parseInt(dataTable.cell(1, 1));
        String status = dataTable.cell(1, 2);
        String shipDate = dataTable.cell(1, 3);
        boolean complete = Boolean.parseBoolean(dataTable.cell(1, 4));

        crearStoreOrderStep.verifyResponseBody(orderId, quantity, status, shipDate, complete);
    }
}
