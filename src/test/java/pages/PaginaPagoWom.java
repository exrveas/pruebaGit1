package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaPagoWom extends ClaseBase {

    public PaginaPagoWom(WebDriver driver) {
        super(driver);
    }

    By locatorTxtRutPagar = By.xpath("//input[@id='rut_form']");

    By locatorBtnPagarEnLinea = By.xpath("//a[@id='enviar_form']");

    By locatorMsjeSinDeuda = By.xpath("//p[contains(text(),'De este lado no tienes deudas.')]");


    public void pagarCuentaWom(String rut){
        agregarTexto(locatorTxtRutPagar,rut);
        esperarXSegundos(2000);
        click(esperaExplicita(locatorBtnPagarEnLinea));
        esperarXSegundos(4000);
        estaDesplegado(locatorMsjeSinDeuda);
    }

    public Boolean verificaMensajeSinDeuda(){
        return estaDesplegado(locatorMsjeSinDeuda);
    }

}
