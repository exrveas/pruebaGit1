package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaPagoTricot extends ClaseBase {

    public PaginaPagoTricot(WebDriver driver) {
        super(driver);
    }

    By LocatorTxtRut = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[@id='content']/section[@id='section_916107000']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]");

    By locatorBtnRealizarPago = By.xpath("//body[1]/div[1]/main[1]/div[1]/section[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/p[3]/a[1]/span[1]");

    By locatorMsjeError2 = By.xpath("//body/div[@id='wrapper']/main[@id='main']/div[@id='content']/section[@id='section_2005192807']/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/p[2]");


    public void realizarPagoTarjeta(){
        agregarTexto(LocatorTxtRut,"162998749");
        click(esperaExplicita(locatorBtnRealizarPago));
    }

    public String MsjeErrorPago(){
        return obtenerTexto(esperaExplicita(locatorMsjeError2));
    }

}
