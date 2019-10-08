package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.ResultadoSimulacaoPage;
import pages.SimuladorPage;

import static org.junit.Assert.assertTrue;

public class SimularInvestimentoSteps {

    private final SimuladorPage simuladorPage = new SimuladorPage();
    private final ResultadoSimulacaoPage resultadoSimulacaoPage = new ResultadoSimulacaoPage();

    @Dado("que acessei a tela de simulacao de investimento")
    public void queAcesseiATelaDeSimulacaoDeInvestimento(){
        assertTrue("\nNão acessou a tela de simulação de investimento!",
                simuladorPage.acessarTelaSimulacao());
    }

    @Quando("^preencher o campo do valor aplicacao com \"([^\"]*)\"$")
    public void preencherOCampoDoValorAplicacaoCom(String valor) {
        simuladorPage.preencherInputValorInvestimento(valor);
    }

    @E("^preencher o campo do valor do investimento mensal com \"([^\"]*)\"$")
    public void preencherOCampoDoValorDoInvestimentoMensalCom(String valor) {
        simuladorPage.preencherInputValorMensal(valor);
    }

    @E("^preencher o campo de tempo de investimento com \"([^\"]*)\"$")
    public void preencherOCampoDeTempoDeInvestimentoCom(String tempo) {
        simuladorPage.preencherInputTempo(tempo);
    }

    @E("^selecionar o valor \"([^\"]*)\" no combo periodo$")
    public void selecionarOValorNoComboPeriodo(String periodo) {
        simuladorPage.selecionarComboPeriodo(periodo);
    }

    @E("^clicar no botao Simular$")
    public void clicarNoBotaoSimular() {
        simuladorPage.clicarBotaoSimular();
    }

    @Entao("^devo acessar a tela de resultado$")
    public void devoAcessarATelaDeResultado() {
        resultadoSimulacaoPage.simulouComSucesso();
    }

    @E("^o valor do resultado sera \"([^\"]*)\"$")
    public void oValorDoResultadoSera(String resultado) {
        assertTrue("\nO valor informado não foi o valor retornado pelo simulador!",
                resultadoSimulacaoPage.compararValorResultado(resultado));
    }
}
