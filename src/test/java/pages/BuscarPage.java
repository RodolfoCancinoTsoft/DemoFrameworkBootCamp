package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseClass;

public class BuscarPage extends BaseClass {

    public BuscarPage(WebDriver driver){
        super(driver);
    }


    //By locatorTxtCorreo = By.id("email");
    By locatorTxtQueEscuchar = By.name("musica");
    //By locatorTxtResultado = By.xpath("//h2[contains(text(),'Incluye a Metallica')]");

    public void respuestaEncontrada(String musica){
        esperaXSegundos(2000);







    }




}
