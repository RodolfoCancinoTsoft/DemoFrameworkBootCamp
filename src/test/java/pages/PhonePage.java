package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class PhonePage extends BaseClass {
    public PhonePage(WebDriver driver) {
        super(driver);
    }



    By localizadorTituloTelefono = By.xpath("//p[contains(text(),'Introducir número de teléfono')]");



    public String obtenerTituloTelefono(){
        return obtenerTexto(esperarAElementoWeb(localizadorTituloTelefono));
    }


}
