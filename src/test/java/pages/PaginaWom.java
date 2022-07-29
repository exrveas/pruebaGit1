package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaWom extends ClaseBase {

    public PaginaWom(WebDriver driver) {
        super(driver);
    }

    By locatorBtnPoagoDeCuenta = By.xpath("//body/section[2]/article[1]/a[3]/span[2]");

    By locatorBtnPortateAWom = By.xpath("//body/section[2]/article[1]/a[1]/span[2]");



    public void irAPagoDeCuenta(){
        click(esperaExplicita(locatorBtnPoagoDeCuenta));
    }

    public void irAPortabilidad(){
        click(esperaExplicita(locatorBtnPortateAWom));
    }

    public void cambioDePagina(){
        cargarSitio("https://www.wom.cl/");
    }
}
