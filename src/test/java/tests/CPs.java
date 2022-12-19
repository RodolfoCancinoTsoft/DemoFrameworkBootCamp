package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class CPs {
    //Atributos

    private BuscarPage buscarPage;
    private IniciarSesionPage iniciarSesionPage;

    private WebDriverWait wait;

    private FacePage facePage;
    private ApplePage applePage;
    private GooglePage googlePage;
    private PhonePage phonePage;
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


        homePage = new HomePage(driver);
        homePage.conexionBrowser(browser,propertyDriver,urlDriver);
        registerPage = new RegisterPage(homePage.getDriver());
        iniciarSesionPage = new IniciarSesionPage(homePage.getDriver());
        facePage = new FacePage(iniciarSesionPage.getDriver());
        applePage = new ApplePage(iniciarSesionPage.getDriver());
        googlePage = new GooglePage(iniciarSesionPage.getDriver());
        phonePage =new PhonePage(iniciarSesionPage.getDriver());

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

        homePage.irAIniciarSesion();
        iniciarSesionPage.iniciarSessionPorFacebook();

        Assert.assertEquals("Iniciar sesión en Facebook",facePage.obtenerTituloFacebook());

    }
    @Test

    public void CP008_Inicio_Seccion_Apple_Xpath(){
        homePage.irAIniciarSesion();
        iniciarSesionPage.irAIniciarSesionApple();
        Assert.assertEquals("Usa tu ID de Apple para iniciar sesión en Spotify.",applePage.obtenerTituloApple());

    }

    @Test

    public void CP009_Inicio_Seccion_Google_Xpath(){
        homePage.irAIniciarSesion();
        iniciarSesionPage.irAIniciarSesionGoogle();
        Assert.assertEquals("Iniciar sesión con Google",googlePage.ObtenerTituloGoogle());

    }

    @Test

    public void CP010_Inicio_Seccion_Telefono_Xpath(){
        homePage.irAIniciarSesion();
        iniciarSesionPage.irAIniciarSessionTelefono();
        Assert.assertEquals("Introducir número de teléfono",phonePage.obtenerTituloTelefono());
    }


    @AfterMethod
    public void posTests(){
        registerPage.cerrarBrowser();

    }
}
