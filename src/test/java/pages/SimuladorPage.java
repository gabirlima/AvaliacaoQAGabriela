package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseTest;

public class SimuladorPage extends BasePage {

    private WebDriver driver;

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

    @FindBy(className = "btSelect")
    protected WebElement comboPeriodo;

    @FindBy(className = "btnLimpar")
    protected WebElement linkLimpar;

    @FindBy(id = "valorAplicar-error")
    protected WebElement hintValorMinimoValorAplicacao;

    @FindBy(id = "valorInvestir-error")
    protected WebElement hintValorMinimoValorInvMensal;

    @FindBy(id = "tempo-error")
    protected WebElement hintTempoObrigatorio;

    public SimuladorPage(){
        driver = BaseTest.getDriver();
        PageFactory.initElements(BaseTest.getDriver(), this);
    }

    public boolean acessarTelaSimulacao(){
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

    public void selecionarComboPeriodo(String periodo) {
        comboPeriodo.click();
        esperaElementoFicarVisivel(driver.findElement(By.className("listaSelect")), 240);
        driver.findElement(By.className("listaSelect")).findElement(By.linkText(periodo)).click();
        Assert.assertTrue("\nCombo tempo não foi selecionado corretamente!",
                driver.findElement(By.className("textoMeses")).getText().equals(periodo));
    }

    public void clicarBotaoSimular(){
        formulario.submit();
    }

    public boolean hintValorMinimoAplicacaoEstaVisivel(){
        return hintValorMinimoValorAplicacao.isDisplayed();
    }

    public boolean hintValorMinimoValorInvMensalEstaVisivel(){
        inputTempoInvestimento.click();
        return hintValorMinimoValorInvMensal.isDisplayed();
    }

    public boolean hintTempoObrigatorioEstaVisivel(){
        return hintTempoObrigatorio.isDisplayed();
    }

    public void clicarNoLinkLimparFormulario(){
        linkLimpar.click();
    }

    public boolean campoAplicacaoEstaEmBranco(){
        return inputValorAplicacao.getText().isEmpty();
    }

    public boolean campoInvMensalEstaEmBranco(){
        return inputValorInvMensal.getText().isEmpty();
    }

    public boolean campoTempoEstaEmBranco(){
        return inputTempoInvestimento.getText().isEmpty();
    }

    public boolean comboPeriodoEstaDefault(){
        return comboPeriodo.getText().contains("Meses");
    }

    public void clicarNoRadioParaVoce(){
        radioParaVoce.click();
    }

    public void clicarNoRadioParaEmpresa(){
        radioParaEmpresa.click();
    }
}
