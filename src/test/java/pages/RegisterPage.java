package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class RegisterPage extends BaseClass {

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    By locatorTxtCorreo = By.id("email");
    By locatorTxtConfirmarCorreo = By.name("confirm");
    By locatorTxtContrasena = By.name("password");
    By locatorTxtNickName = By.name("displayname");
    By locatorTxtDiaNaci = By.id("day");
    By locatorDDLMesNaci = By.id("month");
    By locatorTxtAnioNaci = By.name("year");
    By locatorRbdGeneroH = By.xpath("//label[@for='gender_option_male']");
    By locatorChkMarketing = By.xpath("//label[@for='marketing-opt-checkbox']");
    By locatorChkCompartirDatos = By.xpath("//label[@for='third-party-checkbox']");
    By locatorBtnRegistrarte = By.xpath("//button[@type='submit']");
    By locartorLblErrorCaptcha = By.xpath("//div[contains(text(),'Confirma que no eres un robot.')]");

    public  void completarFormularioRegistro(String correo, String confirmarCorreo, String password, String apodo,String diaNaci, String mesNaci, String anioNaci){

        esperaXSegundos(2000);
        agregarTexto(esperarAElementoWeb(locatorTxtCorreo),correo);
        agregarTexto(esperarAElementoWeb(locatorTxtConfirmarCorreo),confirmarCorreo);
        agregarTexto(esperarAElementoWeb(locatorTxtContrasena),password);
        agregarTexto(esperarAElementoWeb(locatorTxtNickName),apodo);
        agregarTexto(esperarAElementoWeb(locatorTxtDiaNaci),diaNaci);
        selecionMesNacimiento(esperarAElementoWeb(locatorDDLMesNaci),mesNaci);
        agregarTexto(esperarAElementoWeb(locatorTxtAnioNaci),anioNaci);
        scrollElementoWeb(esperarAElementoWeb(locatorRbdGeneroH));
        click(esperarAElementoWeb(locatorRbdGeneroH));
        click(esperarAElementoWeb(locatorChkMarketing));
        click(esperarAElementoWeb(locatorChkCompartirDatos));
        scrollElementoWeb(esperarAElementoWeb(locatorBtnRegistrarte));
        click(esperarAElementoWeb(locatorBtnRegistrarte));
    }

    public String obtenerErrorCaptchaVacio(){
        return obtenerTexto(esperarAElementoWeb(locartorLblErrorCaptcha));
    }
}
