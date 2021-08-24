package tests;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CarroPage;
import pages.CasioPage;
import pages.ElectroacusticasPage;
import pages.GuitarraElegidaPage;
import pages.GuitarrasPage;
import pages.HomePage;
import pages.IniciarSesionPage;
import pages.InterfazScarlett;
import pages.PianosPage;
import pages.TecladosPage;
import utilidades.DataDriven;



public class Inicio {
	
	private WebDriver driver;
	private HomePage homePage;
	private GuitarrasPage guitarrasPage;
	private ElectroacusticasPage electroacusticasPage;
	private GuitarraElegidaPage guitarraelegidaPage;
	private CarroPage carroPage;
	private PianosPage pianosPage;
	private TecladosPage tecladosPage;
	private CasioPage casioPage;
	private InterfazScarlett interfazScarlett;
	private IniciarSesionPage iniciarSesionPage;
	private ArrayList<String> datosCP;
	private DataDriven data;
	
	@BeforeMethod
	public void prepararSitio() {
		homePage.maximizarBrowser();
		homePage.cargarSitio("https://www.audiomusica.com/");
	}
	
	@BeforeTest
	public void before() {
		// ruta del webdriver.chrome.driver
		String rutaDriver = Paths.get(System.getProperty("user.dir"), "\\src\\test\\resources\\webdriver\\chromedriver.exe").toString();
		String navegador = "chrome";
		String propertyDriver = "webdriver.chrome.driver";
		
		homePage = new HomePage(driver);
		homePage.conexionDriver(navegador, rutaDriver, propertyDriver);
		iniciarSesionPage = new IniciarSesionPage(homePage.getDriver());
		guitarrasPage = new GuitarrasPage(homePage.getDriver());
		electroacusticasPage = new ElectroacusticasPage(homePage.getDriver());
		guitarraelegidaPage = new GuitarraElegidaPage(homePage.getDriver());
		carroPage = new CarroPage(homePage.getDriver());
		pianosPage = new PianosPage(homePage.getDriver());
		tecladosPage = new TecladosPage(homePage.getDriver());
		casioPage = new CasioPage(homePage.getDriver());
		interfazScarlett = new InterfazScarlett(homePage.getDriver());
	}
	

	@Test
	public void CP01_IniciarSesion() throws IOException {
	datosCP = data.getData("CP01_IniciarSesion");
	homePage.irAIniciarSesion();
	iniciarSesionPage.completarFomularioInicioSesion(datosCP.get(1), datosCP.get(2));
	iniciarSesionPage.ingresarCuenta();
	Assert.assertEquals(iniciarSesionPage.ComprobarInicioCorrecto(), "Mi Cuenta");
	}
	

	
	
	
	@Test 
	public void CP02_IngresoGuitarras() throws InterruptedException {
		homePage.irAGuitarras();
		guitarrasPage.ingresarGuitarrasElectroacusticas();
		electroacusticasPage.ingresarAGuitarra();
		guitarraelegidaPage.comprarGuitarra();
		guitarraelegidaPage.presionarSeguirComprando();	
		Assert.assertEquals(guitarraelegidaPage.productoAgregado(), "Añadiste Guitarra electroacústica Ibanez GA3ECE - color amber high gloss (AM) a tu Carro, esto NO reserva el stock, solo el pago asegura tu compra.");
	}
	
	
	@Test
	public void CP03_EliminarGuitarra() throws InterruptedException{
		homePage.desplegarCarrito();
		homePage.presionarEditar();
		carroPage.clickEliminar();
		Assert.assertEquals(carroPage.carritoVacio(), "No tienes ningún artículo en tu carro.");
		
		
		
	}
	
	@Test
	public void CP04_IngresoPiano() throws InterruptedException{
		homePage.ingresarPianos();
		pianosPage.ingresarCategoriaTeclado();
		tecladosPage.ingresarACasio();
		Assert.assertEquals(tecladosPage.comprobarIngresoACasio(), "Un sonido adecuado a cada gusto.");
	}
	
	
	@Test
	public void CP05_ComprarCasio() throws InterruptedException{
		homePage.ingresarPianos();
		pianosPage.ingresarCategoriaTeclado();
		tecladosPage.ingresarACasio();
		casioPage.comprarCasio();
		casioPage.presionarSeguirComprando();
		Assert.assertEquals(casioPage.productoAgregado(), "Añadiste Teclado personal Casio CT-X800 a tu Carro, esto NO reserva el stock, solo el pago asegura tu compra.");
	}
	
	
	@Test
	public void CP06_EliminarCasio() throws InterruptedException{
		homePage.desplegarCarrito();
		homePage.presionarEditar();
		carroPage.clickEditar();
		carroPage.clickCantidad();

	}
	
	
	 @Test
	 public void CP07_BuscarInterfazAudio()  throws IOException {
	 	 datosCP = data.getData("CP07_BuscarInterfazAudio");
		 homePage.completarBusqueda(datosCP.get(1));
		 homePage.ingresarInterfazBuscada();
		 Assert.assertEquals(interfazScarlett.comprobarIngresoAInterfaz(), "211584");
	 }
	
	@Test
	public void CP08_CerrarSesion() throws IOException {
		homePage.irAIniciarSesion();
		iniciarSesionPage.completarFomularioInicioSesion(datosCP.get(1), datosCP.get(2));
		homePage.irACerrarSesion();
		homePage.CerrarSesion();
		Assert.assertEquals(homePage.ComprobarCierreCorrecto(), "Has cerrado la sesión");
	}
	
	
	/*@AfterTest
	public void finPrueba() {
		driver.close();
	}
	*/

	public GuitarrasPage getGuitarrasPage() {
		return guitarrasPage;
	}

	public void setGuitarrasPage(GuitarrasPage guitarrasPage) {
		this.guitarrasPage = guitarrasPage;
	}

	public ElectroacusticasPage getElectroacusticasPage() {
		return electroacusticasPage;
	}

	public void setElectroacusticasPage(ElectroacusticasPage electroacusticasPage) {
		this.electroacusticasPage = electroacusticasPage;
	}
	


}
