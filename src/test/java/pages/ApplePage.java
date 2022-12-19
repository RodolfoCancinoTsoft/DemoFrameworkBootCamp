package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class ApplePage extends BaseClass {
    public ApplePage(WebDriver driver) {
        super(driver);
    }

    By localizadorTituloApple = By.xpath("//h1[@class='si-container-title tk-intro  ']");

    public String obtenerTituloApple(){
        return obtenerTexto(esperarAElementoWeb(localizadorTituloApple));
    }
}
