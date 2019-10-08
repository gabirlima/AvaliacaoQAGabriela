package apiTests;

import io.restassured.response.Response;
import models.SimuladorModel;
import org.junit.Test;

import services.SimuladorService;

import static org.junit.Assert.assertEquals;

public class SimuladorTests {

    private static SimuladorService simuladorService = new SimuladorService();
    private static Response response;
    private static SimuladorModel simuladorModel;

    @Test
    public void chamarServicoSimulador(){
        response = simuladorService.simularInvestimento();
        assertEquals("\nStatusCode não é 200!", 200, response.getStatusCode());
        simuladorModel = response.getBody().as(SimuladorModel.class);
        //falta validacao dos valores usando data provider (txt)
    }
}
