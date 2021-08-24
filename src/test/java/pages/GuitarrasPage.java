package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilidades.ClaseBase;

public class GuitarrasPage extends ClaseBase{

	public GuitarrasPage(WebDriver driver) {
		super(driver);
	}
	
	By locatorBtnGuitarrasElectro = By.xpath("//body/div[1]/main[1]/div[2]/div[1]/div[2]/ul[1]/li[2]/a[1]");
	
	
	public void ingresarGuitarrasElectroacusticas() {
		click(esperaExplicita(locatorBtnGuitarrasElectro));
	}
}
