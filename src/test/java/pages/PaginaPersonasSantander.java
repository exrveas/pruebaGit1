package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaPersonasSantander extends ClaseBase {

    public PaginaPersonasSantander(WebDriver driver) {
        super(driver);
    }

    By locatorBtnAbreTuCuenta = By.xpath("//header/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]");

    public void irAPaginaPanes(){
        click(esperaExplicita(locatorBtnAbreTuCuenta));
    }

    public void navegarAOtraPagina(){
        cargarSitio("https://banco.santander.cl/personas");
    }
}
