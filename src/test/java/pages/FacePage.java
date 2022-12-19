package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class FacePage extends BaseClass {


    public FacePage(WebDriver driver) {
        super(driver);
    }
    By localizadorTextoFacebook = By.xpath("//div[contains(text(),'Iniciar sesión en Facebook')]");
    public String obtenerTituloFacebook(){
        return obtenerTexto(esperarAElementoWeb(localizadorTextoFacebook));
    }
}
