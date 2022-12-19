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
    public void irAIniciarSesion(){
        click(esperarAElementoWeb(localizadorBtnIniciarSesion));

    }

}
