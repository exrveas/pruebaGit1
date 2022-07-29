package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaPortabilidadWom extends ClaseBase {

    public PaginaPortabilidadWom(WebDriver driver) {
        super(driver);
    }

    By locatorBtnQuieroPlan = By.xpath("//body/div[@id='___gatsby']/div[@id='gatsby-focus-wrapper']/div[3]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]");

    By locatorTxtRutW = By.xpath("//input[@id='rut']");

    By locatorTxtTelefonoW = By.xpath("//input[@id='phone']");

    By locatorTxtCorreoW = By.xpath("//input[@id='email']");

    By locatorBtnContratar = By.xpath("//button[contains(text(),'Contratar')]");

    By locatorBtnInfo = By.xpath("//a[contains(text(),'REVISAR CUENTA')]");

    By locatorMsjeLoSentimos = By.xpath("//p[contains(text(),'Lo sentimos')]");



    public void contratarPlan(String rut,String telefono,String mail){
        click(esperaExplicita(locatorBtnQuieroPlan));
        esperarXSegundos(4000);
        agregarTexto(locatorTxtRutW,rut);
        agregarTexto(locatorTxtTelefonoW,telefono);
        agregarTexto(locatorTxtCorreoW,mail);
        esperarXSegundos(2000);
        click(esperaExplicita(locatorBtnContratar));
        esperarXSegundos(15000);
    }

    public String verificaMsjeLoSentimos(){
        return obtenerTexto(locatorMsjeLoSentimos);
    }
}
