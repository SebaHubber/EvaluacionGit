package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class CarroPage extends ClaseBase {
	
	public CarroPage(WebDriver driver) {
		super(driver);
	}
	
	//Localizadores
	By locatorBtnEliminar = By.xpath("/html/body/div[1]/main/div[3]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[5]/div/a[3]");

	By locatorLblCarritoVacio = By.xpath("/html/body/div[1]/main/div[3]/div/div[3]/p[1]");
	
	By locatorBtnEditar = By.xpath("/html/body/div[1]/main/div[3]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[5]/div/a[1]");
	
	By locatorBtnCantidad = By.xpath("/html/body/div[1]/main/div[2]/div/div[1]/div[7]/form/div[2]/fieldset/div[1]/div/input");
	
	public void clickEliminar() {
		if(estaDesplegado(locatorBtnEliminar)) {
			click(locatorBtnEliminar);
		}
	}
	
	public String carritoVacio() {
		return obtenerTexto(esperaExplicita(locatorLblCarritoVacio));
	}
	
	public void clickEditar() {
		if(estaDesplegado(locatorBtnEditar)) {
			click(locatorBtnEditar);
		}
				
	}
	
	
	public void clickCantidad() {
		if(estaDesplegado(locatorBtnEditar)) {
			click(locatorBtnCantidad);
			driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[1]/div[7]/form/div[2]/fieldset/div[1]/div/input")).clear();
			agregarTexto(esperaExplicita(locatorBtnEditar), "2");
		}
	}
	



}


