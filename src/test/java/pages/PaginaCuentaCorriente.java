package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaCuentaCorriente extends ClaseBase {

    public PaginaCuentaCorriente(WebDriver driver) {
        super(driver);
    }

    By locatorTxtNombre = By.xpath("//input[@id='name']");

    By locatorTxtTelefono = By.xpath("//input[@id='phone']");

    By locatorTxtRut = By.xpath("//input[@id='rut']");

    By locatorTxtSerie = By.xpath("//input[@id='serial']");

    By locatorBtnComencemos = By.xpath("//button[@id='obd-btn']");

    By localizadorMsjeVerificar = By.xpath("//span[contains(text(),'Verifica que los datos entregados sean los correct')]");

    By locatorBtnFinalizar = By.xpath("//button[contains(text(),'FINALIZAR')]");


    public void comienzoCtaLife(String nombre, String telefono, String rut, String serie){
        agregarTexto(locatorTxtNombre, nombre);
        agregarTexto(locatorTxtTelefono, telefono);
        agregarTexto(locatorTxtRut, rut);
        agregarTexto(locatorTxtSerie, serie);
        esperarXSegundos(2000);
        click(esperaExplicita(locatorBtnComencemos));
        esperarXSegundos(7000);
        click(esperaExplicita(locatorBtnFinalizar));
    }

    public String obtenerMensaje(){
        return obtenerTexto(localizadorMsjeVerificar);
    }

    public Boolean verificarBtnFinalizar(){
        return estaDesplegado(locatorBtnFinalizar);
    }

}
