package utilidades;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClaseBase {
	//Definir atributos
	protected WebDriver driver;
	protected WebDriverWait espera;
	
	//Metodos
	public ClaseBase(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	//Definir funciones para interactuar en las paginas (Selenium)
	
	public WebDriver getDriver() {
		return driver;
	}



	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}



	//Buscar elemento web
	public WebElement buscarElementoWeb(By localizador) {
		return this.driver.findElement(localizador);
	}
	//Buscar elementos web
	public List<WebElement> buscarElementosWeb(By localizador){
		return this.driver.findElements(localizador);
	}
	
	//Obtener texto de un objeto por su localizador
	public String obtenerTexto(By localizador) {
		return this.driver.findElement(localizador).getText();
	}
	//Obtener texto de un webelement
	public String obtenerTexto(WebElement elemento) {
		return elemento.getText();
	}
	
	//Ingresar texto en un elemento web por su localizador
	public void agregarTexto(By localizador, String mensaje) {
		this.driver.findElement(localizador).sendKeys(mensaje);
	}
	//Ingresar texto a un elemento web
	public void agregarTexto(WebElement elemento, String mensaje) {
		elemento.sendKeys(mensaje);
	}
	
	//Hacer click a elemento por su localizador
	public void click(By localizador) {
		this.driver.findElement(localizador).click();
	}
	//Hacer click a un elemento web
	public void click(WebElement elemento) {
		elemento.click();
	}
	//Carga de sitio
	public void cargarSitio(String url) {
		this.driver.get(url);
	}
	//pantalla completa
	public void maximizarBrowser() {
		this.driver.manage().window().maximize();
	}
	
	//Cerrar
	public void cerrarBrowser() {
	this.driver.close();
	}
	
	//Metodo para conectarse al webdriver
	public WebDriver conexionDriver(String browser, String ruta, String propertyDriver) {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty(propertyDriver, ruta);
			this.driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(propertyDriver, ruta);
			this.driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("IE")) {
			System.setProperty(propertyDriver, ruta);
			this.driver = new InternetExplorerDriver();
		}
		return driver;
	}
	
	public boolean estaDesplegado(By localizador) {
		try {
			return this.driver.findElement(localizador).isEnabled();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
		 
	}
	//Espera fija 
	public void esperarXSegundos(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	}
	
	//Espera explicita
	public WebElement esperaExplicita(By localizador) {
		 espera = new WebDriverWait(this.driver,30);
		 
		 return espera.until(ExpectedConditions.presenceOfElementLocated(localizador));
	}

}
