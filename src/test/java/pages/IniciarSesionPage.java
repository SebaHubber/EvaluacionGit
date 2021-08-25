package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class IniciarSesionPage extends ClaseBase{
	
	public IniciarSesionPage(WebDriver driver) {
		super(driver);
	}
	
	By locatorBtnUsuario = By.xpath("//input[@id='email']");
	
	By locatorBtnContraseña = By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/div[1]/div[2]/form[1]/fieldset[1]/div[2]/div[1]/input[1]");

	By locatorBtnIngresar = By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/div[1]/div[2]/form[1]/fieldset[1]/div[5]/div[1]/button[1]");
	
	By locatorBtnClickCuenta = By.xpath("//header/div[2]/div[2]/ul[1]");
	
	By locatorBtnCuenta = By.xpath("//a[contains(text(),'Mi Cuenta')]");
	
	By locatorTxtSesionCorrecta = By.xpath("//span[contains(text(),'Mi Cuenta')]");

	public void completarFomularioInicioSesion(String email, String pass) {
		
			agregarTexto(esperaExplicita(locatorBtnUsuario), email);
		

			agregarTexto(esperaExplicita(locatorBtnContraseña), pass);


			click(esperaExplicita(locatorBtnIngresar));
	}
	
	public void ingresarCuenta() {
		click(esperaExplicita(locatorBtnClickCuenta));
		click(esperaExplicita(locatorBtnCuenta));
	}
	
	public String ComprobarInicioCorrecto() {
		return obtenerTexto(esperaExplicita(locatorTxtSesionCorrecta));
	}
	
	
	

}
