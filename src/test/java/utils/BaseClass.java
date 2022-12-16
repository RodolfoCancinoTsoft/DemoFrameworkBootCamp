package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

    protected WebDriver driver;
    protected JavascriptExecutor js;

    protected WebDriverWait wait;

    protected Select select;

    //getter an seter


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement buscarElementoWeb(By localizador){
        return this.driver.findElement(localizador);

    }

    public void cargarPagina(String url){
        this.driver.get(url);
    }

    public WebDriver conexionBrowser(String browser, String propertyDriver, String rutaDriver){
        switch (browser){
            case "CHROME":
                System.setProperty(propertyDriver,rutaDriver);
                this.driver = new ChromeDriver();
                return this.driver;
            case "EDGE":
                System.setProperty(propertyDriver,rutaDriver);
                this.driver = new EdgeDriver();
                return this.driver;
            case "FIREFOX":
                System.setProperty(propertyDriver,rutaDriver);
                this.driver = new FirefoxDriver();
                return this.driver;
            default:
                this.driver = null;
                return this.driver;
        }
    }

    public void scrollElementoWeb(By localizador){
        js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].scrollIntoView();",this.driver.findElement(localizador));
    }

    public void scrollElementoWeb(WebElement elemento){
        js = (JavascriptExecutor) this.driver;
        js.executeScript("arguments[0].scrollIntoView();",elemento);
    }

    public void esperaXSegundos(int milisegundos){
        try {
            Thread.sleep(milisegundos);
        }catch (Exception ex){
            System.out.println("Fallo la espera en milisegundos");
        }
    }

    public WebElement esperarAElementoWeb(By localizador){
        wait = new WebDriverWait(this.driver,20);
        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }

    public void click(WebElement elemento){
        elemento.click();
    }

    public void click(By localizador){
        this.driver.findElement(localizador).click();
    }

    public String obtenerTexto(WebElement elemento){
        return elemento.getText();
    }

    public String obtenerTexto(By localizador){
        return this.driver.findElement(localizador).getText();
    }

    public void submitFormulario(By localizador){
        this.driver.findElement(localizador).submit();
    }

    public void agregarTexto(WebElement elemento, String texto){
        elemento.sendKeys(texto);
    }

    public void agregarTexto(By localizador, String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }

    public void maximizarPagina(){
        driver.manage().window().maximize();
    }

    //metod lista encontar
    public void selecionMesNacimiento(WebElement elemento, String texto){
        select = new Select(elemento);
        select.selectByVisibleText(texto);
    }
}
