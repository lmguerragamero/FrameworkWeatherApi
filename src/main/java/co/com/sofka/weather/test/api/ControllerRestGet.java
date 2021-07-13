package co.com.sofka.weather.test.api;

import co.com.sofka.test.actions.Action;
import co.com.sofka.test.actions.ServiceAction;
import co.com.sofka.test.automationtools.webservices.api.WebServiceClient;
import co.com.sofka.test.automationtools.webservices.api.dataTransferObject.ServiceResponse;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.weather.test.controllers.ControllerConsultarClima;

public class ControllerRestGet {

    public ServiceResponse consumoApiRestGet(String request){
        ServiceResponse response = null;
        try{
            ServiceAction serviceAction = new ServiceAction(Action.getPropertiesFiles().getFieldValue("project.name"));
            WebServiceClient client = serviceAction.getWebServicesClient(ServiceAction.ServiceType.REST_GET);
            //Action.getPropertiesFiles().getRandomFieldValue("ids");
            response = client.callWebService(request);
            if(response.getStatus().equals("200")){
                Report.reportInfo("CONSUMO EXITOSO");
            }
            else{
                Report.reportFailure("EL CODIGO DE RESPUESTA DE LA API NO FUE EL ESPERADO");
            }
        }
        catch (Exception e){
            Report.reportFailure("EXCEPTION" + e.getMessage());
        }
        return response;
    }
}
