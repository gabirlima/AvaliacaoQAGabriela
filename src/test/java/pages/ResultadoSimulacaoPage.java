package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultadoSimulacaoPage extends BasePage {

    @FindBy(className = "blocoResultadoSimulacao")
    protected WebElement divResultadoSimulacao;

    @FindBy(className = "valor")
    protected WebElement labelValorDoResultado;

    @FindBy(tagName = "table")
    protected WebElement tabelaMaisOpcoes;

    @FindBy(className = "btnRefazer")
    protected WebElement btnRefazerSimulacao;

    public boolean simulouComSucesso(){
        return labelValorDoResultado.isDisplayed();
    }

    public void clicarBtnRefazerSimulacao(){
        btnRefazerSimulacao.click();
    }

    public boolean compararValorResultado(String resultado){
        return labelValorDoResultado.getText().equals(resultado);
    }
}
