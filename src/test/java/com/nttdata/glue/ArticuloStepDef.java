package com.nttdata.glue;

import com.nttdata.steps.ArticuloStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ArticuloStepDef {

    @Steps
    ArticuloStep articulo;

    @Given("la url {string} del servicio")
    public void laUrlDelServicio(String url) {
        articulo.definirurl(url);
    }

    @When("hago la consulta de los articulos")
    public void hagoLaConsultaDeLosArticulos() {
        articulo.consultaArtuculos();
    }

    @Then("imprimo los articulos")
    public void imprimoLosArticulos() {
        articulo.imprimirArticulos();
    }



    @And("validar codigo de respuesta sea {int}")
    public void validarCodigoDeRespuestaSea(int arg0) {
        articulo.validarCodigoDeRespuesta373838383(arg0);
    }
}
