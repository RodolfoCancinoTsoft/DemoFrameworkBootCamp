package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver){
        super(driver);
    }

    By locatorBtnRegistrate = By.xpath("//button[contains(text(),'Registrarte')]");

    public void irARegistrarse(){
        click(esperarAElementoWeb(locatorBtnRegistrate));
    }
}
