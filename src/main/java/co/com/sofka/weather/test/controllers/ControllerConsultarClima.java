package co.com.sofka.weather.test.controllers;

import co.com.sofka.test.automationtools.webservices.api.dataTransferObject.ServiceResponse;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.weather.test.api.ControllerRestGet;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.Assert.assertEquals;

public class ControllerConsultarClima {

    public String checkWeatherSuccess(String urlbase, String path, String id, String key){
        String request = urlbase + path + "?id=" + id + "&appid=" + key;
        String resultMessage = "";
        try{
            ControllerRestGet controllerRestGet = new ControllerRestGet();
            ServiceResponse response = controllerRestGet.consumoApiRestGet(request);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(response.getBody());
            resultMessage = jsonNode.get("weather").get(0).get("main").toString();
            Report.reportInfo("RESPUESTA OBTENIDA EXITOSAMENTE");
        }
        catch (Exception e){
            Report.reportFailure("OCURRIO UN ERROR AL MAPEAR LA RESPUESTA DE LA API");
        }
        return resultMessage;
    }

    public void validateCheckWeatherSuccess(String message){
        try{
            Assert.Hard.thatIsNotEmpty(message);
            Report.reportInfo("ASSERT REALIZADO CORRECTAMENTE");
        }
        catch (Exception e){
            Report.reportFailure("OCURRIO UN ERROR AL REALIZAR EL ASSERT");
        }
    }
}
