package com.nttdata.glue;

import com.nttdata.steps.CrearUsuariosStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UsersStepDef {
    @Steps
    CrearUsuariosStep crearUsuariosStep;

    @Given("que tengo un usuario con los siguientes datos {int}, {string}, {string}, {string}, {string}, {string}, {string}, {int}")
    public void queTengoUnUsuarioConLosSiguientesDatos (int arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, int arg7)  {
        crearUsuariosStep.preparaBody(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
        }

    @When("envio una peticion POST al endpoint users")
    public void envioUnaPeticionPOSTAUsers() {
        crearUsuariosStep.createUser();
    }

    @Then("la respuesta es {int}")
    public void laRespuestaEs(int arg0) {
        crearUsuariosStep.validateResponse(arg0);
    }
}

