package com.nttdata.glue;

import com.nttdata.steps.CrearUsuario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CrearUsuarioStepsDefs {

    @Steps
    CrearUsuario crearUsuario;

    @When("creo el usuario con username {string}, firstname {string}, lastname {string}")
    public void crearUsuario(String username, String firstName, String lastName){
        crearUsuario.crearUsuario(username, firstName, lastName);
    }

    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
       crearUsuario.validarCodigoRespuesta(statusCode);
    }

    @And("el type es {string}")
    public void elTypeEs(String type) {
      crearUsuario.validarType(type);
    }

    @When("envio una peticion POST a \\/users")
    public void envioUnaPeticionPOSTAUsers() {
    }


    @Given("que tengo los datos {int}, {string}, {string}, {string}, {string}, {string}, {string}, {int}}")
    public void queTengoLosDatosIdStatus(int arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, int arg5) {
    }
}
