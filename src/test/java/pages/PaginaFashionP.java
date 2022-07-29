package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaFashionP extends ClaseBase {

    public PaginaFashionP(WebDriver driver) {
        super(driver);
    }

    By locatorLinkSeguirCompra = By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]");

    public void navegarAOtraPagina(){
        cargarSitio("https://fashionspark.com/");
    }

    public void irASeguirCompra(){
        click(esperaExplicita(locatorLinkSeguirCompra));
    }


}
