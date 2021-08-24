package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class CasioPage extends ClaseBase {
	
	public CasioPage(WebDriver driver) {
		super(driver);
	}
	
	By locatorBtnComprar = By.xpath("//button[@id='product-addtocart-button']");
	
	By locatorBtnSeguirComprando = By.xpath("/html/body/div[6]/aside[3]/div[2]/footer/button[1]");
	
	By locatorTextProductoAgregado = By.xpath("/html/body/div[1]/main/div[1]/div[2]/div/div");
	
	
	public void comprarCasio() {
		click(esperaExplicita(locatorBtnComprar));
	}
	public void presionarSeguirComprando() {
		 click(esperaExplicita(locatorBtnSeguirComprando));
	}
	
	public String productoAgregado() {
		return obtenerTexto(esperaExplicita(locatorTextProductoAgregado));
	}
}
