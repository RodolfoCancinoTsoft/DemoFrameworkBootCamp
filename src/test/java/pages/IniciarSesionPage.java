package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class IniciarSesionPage extends BaseClass {

    public IniciarSesionPage(WebDriver driver){
        super(driver);
    }


    By localizadorBtnEntarConFacebook = By.xpath("//button[@data-testid='facebook-login']");
    By localisadorBtnEntarConApple = By.xpath("//button[@data-testid='apple-login']");
    By localizadorBtnEntarGoogle = By.xpath("//button[@data-testid='google-login']");
    By localizadorBtnTelefono = By.xpath("//button[@data-testid='phone-login']");

    public void iniciarSessionPorFacebook(){
        click(esperarAElementoWeb(localizadorBtnEntarConFacebook));
    }

    public void irAIniciarSesionApple(){
        click(esperarAElementoWeb(localisadorBtnEntarConApple));

    }

    public void irAIniciarSesionGoogle(){
        click(esperarAElementoWeb(localizadorBtnEntarGoogle));

    }
    public void irAIniciarSessionTelefono(){

        click(esperarAElementoWeb(localizadorBtnTelefono));
    }




}
