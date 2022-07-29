package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaResultadoWom extends ClaseBase {

    public PaginaResultadoWom(WebDriver driver) {
        super(driver);
    }

    By locatorMsjeSinDeuda = By.xpath("//p[contains(text(),'De este lado no tienes deudas.')]");


    public void obtenerMensajeSinDeuda(){
        obtenerTexto(locatorMsjeSinDeuda);
    }

    public Boolean verificaMensajeSinDeuda(){
        return estaDesplegado(locatorMsjeSinDeuda);
    }


}
