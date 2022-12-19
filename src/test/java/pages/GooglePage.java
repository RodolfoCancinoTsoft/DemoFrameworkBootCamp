package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class GooglePage extends BaseClass {
    public GooglePage(WebDriver driver) {
        super(driver);
    }

    By localizadorTituloGoogle = By.xpath("//div[contains(text(),'Iniciar sesión con Google')]");

    public String ObtenerTituloGoogle(){
        return obtenerTexto(esperarAElementoWeb(localizadorTituloGoogle));
    }
}
