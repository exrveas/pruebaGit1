package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaSeguimientoFashionP extends ClaseBase {

    public PaginaSeguimientoFashionP(WebDriver driver) {
        super(driver);
    }

    By locatorTxtNumeroDePedido = By.xpath("//input[@id='myshippingordermobile']");

    By locatorBtnConsultar = By.xpath("//body/div[6]/main[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/input[1]");

    By locatorMsjeAlerta = By.xpath("//body");


    public void consultaPedido(String pedido){
        agregarTexto(locatorTxtNumeroDePedido,pedido);
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnConsultar));
    }

    public String mensajeAlert(){
        return obtenerTexto(locatorMsjeAlerta);
    }

}
