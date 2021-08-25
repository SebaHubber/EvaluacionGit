package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class HomePage extends ClaseBase {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

		//Localizadores
	By locatorBtnIniciarSesion = By.xpath("//a[contains(text(),'Iniciar sesión')]");
	
	By locatorBtnGuitarras = By.xpath("//body/div[2]/main[1]/div[2]/div[1]/div[5]/div[1]/div[1]/a[1]/img[1]");
	
	By locatorBtnCarrito = By.xpath("/html/body/div[2]/header/div[2]/div[2]/div/a");
	
	By locatorBtnEditar = By.xpath("/html/body/div[2]/header/div[2]/div[2]/div/div/div/div/div[2]/div[1]/div[2]/div/a/span");
	
	By locatorBtnPianos = By.xpath("/html/body/div[2]/main/div[2]/div/div[5]/div[2]/div[2]/a/img");

	By locatorBtnBuscar = By.xpath("//input[@id='search']");
	
	By locatorBtnInterfazBuscada = By.xpath("/html/body/div[1]/main/div[3]/div/div[3]/div[3]/div[3]/div[2]/div[2]/ul/li[1]/div[2]/div[1]/a");
	
	By locatorBtnCerrarSesion = By.xpath("/html/body/div[2]/header/div[2]/div[2]/ul/li[2]");
	
	By locatorBtnLogOut = By.xpath("/html/body/div[2]/header/div[2]/div[2]/ul/li[2]/div/ul/li[2]/a");
	
	By locatorLblMensajeSalida = By.xpath("/html/body/div[1]/main/div[1]/h1/span");
	
	
	
	
	
	public void irAIniciarSesion() {
		if(estaDesplegado(locatorBtnIniciarSesion)) {
			click(locatorBtnIniciarSesion); 
		}
	}
	
	public void irACerrarSesion() {
		if(estaDesplegado(locatorBtnCerrarSesion)) {
			click(locatorBtnCerrarSesion);
		}
			
	}
	
	public void CerrarSesion() {
		if(estaDesplegado(locatorBtnLogOut)) {
			click(locatorBtnLogOut);
		}
	}
	
	public void irAGuitarras() {
		if(estaDesplegado(locatorBtnGuitarras)) {
			click(locatorBtnGuitarras);
		}
	}
	
	public void desplegarCarrito() {
		if(estaDesplegado(locatorBtnCarrito)) {
			click(esperaExplicita(locatorBtnCarrito));
		}
				
	}
	
	public void presionarEditar() {
		if(estaDesplegado(locatorBtnEditar)) {
			click(esperaExplicita(locatorBtnEditar));
		}
	}
	
	public void ingresarPianos() {
		if(estaDesplegado(locatorBtnPianos))
		click(esperaExplicita(locatorBtnPianos));
	}
	

	
	public void ingresarInterfazBuscada() {
		if(estaDesplegado(locatorBtnInterfazBuscada))
			click(esperaExplicita(locatorBtnInterfazBuscada));
	}
	
	public String ComprobarCierreCorrecto() {
		return obtenerTexto(esperaExplicita(locatorLblMensajeSalida));
	}
	
	public void completarBusqueda(String busqueda) {
		if(estaDesplegado(locatorBtnBuscar)) {
			click(esperaExplicita(locatorBtnBuscar));
			agregarTexto(esperaExplicita(locatorBtnBuscar), busqueda);
			driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
		}
	
		
		
	


		
}
}
