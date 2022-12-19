package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BuscarPage;
import pages.HomePage;
import pages.IniciarSesionPage;
import pages.RegisterPage;

public class CPs {
    //Atributos

    private BuscarPage buscarPage;
    private IniciarSesionPage iniciarSesionPage;

    private WebDriverWait wait;

    private HomePage homePage;
    private RegisterPage registerPage;
    private WebDriver driver;
    private String browser = "CHROME";
    private String propertyDriver = "webdriver.chrome.driver";
    private String urlDriver = System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
    private String url = "https://open.spotify.com/";

    @BeforeMethod
    public void preparacionTests(){

        buscarPage = new BuscarPage(driver);
        iniciarSesionPage = new IniciarSesionPage(driver);

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

    @Test

    public void CP006_Tipos_Pruebas_Xpath_Buscar_Por_Artista(){
        homePage.irABuscar("metallica");
        Assert.assertEquals("Metallica", homePage.obtenerTituloCaratulaAlbum());

    }
    @Test

    public void CP007_Inicio_Seccion_Facebook_Xpath(){

        homePage.iniciarSesion();
        Assert.assertEquals("Iniciar sesión en Facebook",homePage.obtenerTituloFacebook());

    }
    @Test

    public void CP008_Inicio_Seccion_Apple_Xpath(){
        homePage.iniciarSesionApple();
        Assert.assertEquals("Usa tu ID de Apple para iniciar sesión en Spotify.",homePage.obtenerTituloApple());

    }

    @Test

    public void CP009_Inicio_Seccion_Google_Xpath(){
        homePage.iniciarSesionGoogle();
        Assert.assertEquals("Iniciar sesión con Google",homePage.ObtenerTituloGoogle());

    }

    @Test

    public void CP010_Inicio_Seccion_Telefono_Xpath(){
        homePage.iniciarSessionTelefono();
        Assert.assertEquals("Introducir número de teléfono",homePage.obtenerTituloTelefono());
    }


    @AfterMethod
    public void posTests(){
        registerPage.cerrarBrowser();

    }
}
