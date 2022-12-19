package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BaseClass;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver){
        super(driver);
    }

    By locatorBtnRegistrate = By.xpath("//button[contains(text(),'Registrarte')]");
    By localizadorBtnBuscar = By.xpath("//span[contains(text(),'Buscar')]");
    By localizadorSelecionMusica = By.xpath("//input[@placeholder='¿Qué te apetece escuchar?']");

    By localizadorResultadoPrincipal = By.xpath("//h2[contains(text(),'Resultado principal')]");
    By localizadorResultadoPorGrupo = By.xpath("//div[@data-testid='herocard-click-handler']");

    //localizadores de iniciar session con Facebook
    By localizadorBtnIniciarSesion = By.xpath("//span[contains(text(),'Iniciar sesión')]");
    By localizadorBtnEntarConFacebook = By.xpath("//button[@data-testid='facebook-login']");

    public void irARegistrarse(){
        click(esperarAElementoWeb(locatorBtnRegistrate));
    }

    public void irABuscar(String artista){
        click(esperarAElementoWeb(localizadorBtnBuscar));
        click(esperarAElementoWeb(localizadorSelecionMusica));
        agregarTexto(esperarAElementoWeb(localizadorSelecionMusica),artista);
    }

    By localizadorTituloCaratula = By.xpath("//span/a[contains(text(),'Metallica')]");
    public String obtenerTituloCaratulaAlbum(){
         return obtenerTexto(obtenerElementoHijo(esperarAElementoWeb(localizadorResultadoPorGrupo),localizadorTituloCaratula));
    }
    public void iniciarSesion(){
        click(esperarAElementoWeb(localizadorBtnIniciarSesion));
        click(esperarAElementoWeb(localizadorBtnEntarConFacebook));
    }

    By localizadorTextoFacebook = By.xpath("//div[contains(text(),'Iniciar sesión en Facebook')]");
    public String obtenerTituloFacebook(){
        return obtenerTexto(esperarAElementoWeb(localizadorTextoFacebook));
    }

    By localisadorBtnEntarConApple = By.xpath("//button[@data-testid='apple-login']");
    By localizadorTituloApple = By.xpath("//h1[@class='si-container-title tk-intro  ']");

    public void iniciarSesionApple(){
        click(esperarAElementoWeb(localizadorBtnIniciarSesion));
        click(esperarAElementoWeb(localisadorBtnEntarConApple));
    }
    public String obtenerTituloApple(){
        return obtenerTexto(esperarAElementoWeb(localizadorTituloApple));
    }


    By localizadorBtnGoogle = By.xpath("//button[@data-testid='google-login']");
    By localizadorTituloGoogle = By.xpath("//div[contains(text(),'Iniciar sesión con Google')]");


    public void iniciarSesionGoogle(){
        click(esperarAElementoWeb(localizadorBtnIniciarSesion));
        click(esperarAElementoWeb(localizadorBtnGoogle));
    }

    public String ObtenerTituloGoogle(){
        return obtenerTexto(esperarAElementoWeb(localizadorTituloGoogle));
    }


    By localizadorBtnTelefono = By.xpath("//button[@data-testid='phone-login']");
    By localizadorTituloTelefono = By.xpath("//p[contains(text(),'Introducir número de teléfono')]");
    public void iniciarSessionTelefono(){
        click(esperarAElementoWeb(localizadorBtnIniciarSesion));
        click(esperarAElementoWeb(localizadorBtnTelefono));
    }
    public String obtenerTituloTelefono(){
        return obtenerTexto(esperarAElementoWeb(localizadorTituloTelefono));
    }


}
