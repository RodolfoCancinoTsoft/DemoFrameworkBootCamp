package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class CPs {
    //Atributos

    private HomePage homePage;
    private RegisterPage registerPage;
    private WebDriver driver;
    private String browser = "CHROME";
    private String propertyDriver = "webdriber.chrome.driver";
    private String urlDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
    private String url = "https://open.spotify.com/";

    @BeforeMethod
    public void preparacionTests(){
        homePage = new HomePage(driver);
        homePage.conexionBrowser(browser,propertyDriver,urlDriver);
        registerPage = new RegisterPage(homePage.getDriver());

        homePage.cargarPagina(url);
        homePage.maximizarPagina();

    }

    @Test
    public void CP001_Registro_Fallido_Captcha_En_Blacno(){
        homePage.irARegistrarse();
        registerPage.completarFormularioRegistro("rodo@htomail.com",
                "rodo@htomail.com",
                "123456",
                "rodo",
                "9",
                "Julio",
                "1990");

        Assert.assertEquals(registerPage.obtenerErrorCaptchaVacio(),"Confirma que no eres un robot.");
    }

    @AfterMethod
    public void posTests(){
        registerPage.cerrarBrowser();

    }
}
