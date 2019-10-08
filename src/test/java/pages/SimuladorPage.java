package pages;

import lombok.Data;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class SimuladorPage extends BasePage {

    @FindBy(id = "formInvestimento")
    protected WebElement formulario;

    @FindBy(xpath = "//input[@value='paraVoce']")
    protected WebElement radioParaVoce;

    @FindBy(xpath = "//input[@value='paraEmpresa']")
    protected WebElement radioParaEmpresa;

    @FindBy(id = "valorAplicar")
    protected WebElement inputValorAplicacao;

    @FindBy(id = "valorInvestir")
    protected WebElement inputValorInvMensal;

    @FindBy(id = "tempo")
    protected WebElement inputTempoInvestimento;

    @FindBy(id = "periodo")
    protected WebElement comboPeriodo;

    @FindBy(className = "btnLimpar")
    protected WebElement linkLimpar;

    public boolean acessarTelaSimulacao(){
        driver.get("https://www.sicredi.com.br/html/ferramenta/simulador-investimento-poupanca/");
        return formulario.isDisplayed();
    }

    public void selecionarPerfilParaVoce(){
        radioParaVoce.click();
    }

    public void selecionarPerfilParaEmpresa(){
        radioParaEmpresa.click();
    }

    public void preencherInputValorInvestimento(String valor){
        inputValorAplicacao.sendKeys(valor);
    }

    public void preencherInputValorMensal(String valor){
        inputValorInvMensal.sendKeys(valor);
    }

    public void preencherInputTempo(String valor){
        inputTempoInvestimento.sendKeys(valor);
    }

    public void selecionarComboPeriodo(String periodo){
        comboPeriodo.click();
        driver.findElement(By.linkText(periodo)).click();
        Assert.assertTrue("\nCombo tempo não foi selecionado corretamente!",
                driver.findElement(By.className("textoMeses ")).getText().equals(periodo));
    }

    public void clicarBotaoSimular(){
        formulario.submit();
    }
}
