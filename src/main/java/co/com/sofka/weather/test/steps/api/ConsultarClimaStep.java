package co.com.sofka.weather.test.steps.api;

import co.com.sofka.test.actions.Action;
import co.com.sofka.weather.test.controllers.ControllerConsultarClima;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultarClimaStep {

    private ControllerConsultarClima controllerConsultarClima;
    private String urlbase;
    private String mainResult;

    @Given("un usuario conoce la url para realizar la peticion a la api")
    public void unUsuarioConoceLaUrlParaRealizarLaPeticionALaApi() {
        urlbase = Action.getPropertiesFiles().getFieldValue("urlbase");
    }

    @When("quiere consultar el clima de una ciudad con ([^\"]*) y key validos")
    public void quiereConsultarElClimaDeUnaCiudadConIdYKeyValidos(String id) {
        String path = Action.getPropertiesFiles().getFieldValue("path");
        String key = Action.getPropertiesFiles().getFieldValue("key");
        System.out.println(id);
        controllerConsultarClima = new ControllerConsultarClima();
        mainResult = controllerConsultarClima.checkWeatherSuccess(urlbase, path, id, key);
    }

    @Then("podra ver toda la informacion sobre el clima actual de la ciudad correspondiente")
    public void podraVerTodaLaInformacionSobreElClimaActualDeLaCiudadCorrespondiente() {
        controllerConsultarClima.validateCheckWeatherSuccess(mainResult);
    }

}
