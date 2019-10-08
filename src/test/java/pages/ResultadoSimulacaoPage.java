package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseTest;

public class ResultadoSimulacaoPage extends BasePage {

    private WebDriver driver;

    @FindBy(className = "blocoResultadoSimulacao")
    protected WebElement divResultadoSimulacao;

    @FindBy(className = "valor")
    protected WebElement labelValorDoResultado;

    @FindBy(tagName = "table")
    protected WebElement tabelaMaisOpcoes;

    @FindBy(className = "btnRefazer")
    protected WebElement btnRefazerSimulacao;

    public ResultadoSimulacaoPage(){
        driver = BaseTest.getDriver();
        PageFactory.initElements(BaseTest.getDriver(), this);
    }

    public boolean simulouComSucesso(){
        esperaElementoFicarVisivel(divResultadoSimulacao, 90);
        return labelValorDoResultado.isDisplayed();
    }

    public void clicarBtnRefazerSimulacao(){
        btnRefazerSimulacao.click();
    }

    public boolean compararValorResultado(String resultado){
        return labelValorDoResultado.getText().equals(resultado);
    }
}
