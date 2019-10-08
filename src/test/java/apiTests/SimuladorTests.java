package apiTests;

import io.qameta.allure.Feature;
import io.restassured.response.Response;
import models.SimuladorModel;

import org.junit.Test;
import services.SimuladorService;
import util.SchemaReader;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Feature("SimuladorApiTests")
public class SimuladorTests {

    private static SimuladorService simuladorService = new SimuladorService();
    private static Response response;
    private static SimuladorModel simuladorModel;

    @Test
    public void chamarServicoSimuladorTest(){
        response = simuladorService.simularInvestimento();
        assertEquals("\nStatusCode não é 200!", 200, response.getStatusCode());
        simuladorModel = response.getBody().as(SimuladorModel.class);

        List<String> meses = SchemaReader.getCamposSchema("meses.txt", SchemaReader.DATA);
        for (String mes : simuladorModel.getMeses()){
            assertTrue("\nMês incorreto", validaValores(meses, mes));
        }

        List<String> valores = SchemaReader.getCamposSchema("valores.txt", SchemaReader.DATA);
        for (String valor : simuladorModel.getValor()){
            assertTrue("\nValor incorreto.", validaValores(valores, valor));
        }
    }

    private boolean validaValores(List<String> valores, String parametro){
        boolean achou = false;
        for(String valor : valores){
            if(parametro.equals(valor)){
                achou = true;
                break;
            }
        }
        return achou;
    }
}
