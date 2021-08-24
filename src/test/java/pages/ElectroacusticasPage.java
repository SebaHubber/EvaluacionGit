package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class ElectroacusticasPage extends ClaseBase{

	public ElectroacusticasPage(WebDriver driver) {
		super(driver);
	}
	
	By locatorBtnGuitarra = By.xpath("/html/body/div[1]/main/div[2]/div[1]/div[3]/div[3]/ol/li[13]/div/div[3]/strong/a");
	
	
	public void ingresarAGuitarra() {
		click(esperaExplicita(locatorBtnGuitarra));
	}

}

