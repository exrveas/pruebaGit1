package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaProductosTricot extends ClaseBase {

    public PaginaProductosTricot(WebDriver driver) {
        super(driver);
    }

    //By locatorBtnBuscar = By.xpath("//span[contains(text(),'Buscar')]");

    //By locatorTxtBuscar = By.id("id=\"search_input\"");

    //By locatorBtnLupa = By.xpath("//header/div[@id='search_overlay']/div[1]/form[1]/span[1]/i[1]");

    By locatorBtnZapatilla = By.xpath("//body/div[3]/div[1]/section[2]/article[1]/a[1]/figure[1]/img[1]");

    By locatorBtnAgregar = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]");

    By locatorBtnBolsa = By.xpath("//header/div[@id='upper_menu']/div[1]/ul[1]/li[8]/a[2]/div[1]");

    By locatorBtnCantidadProducto = By.xpath("//header/div[@id='upper_menu']/div[1]/ul[1]/li[8]/a[2]/span[1]");

    By locatorBtnRemover = By.xpath("//body/section[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/button[1]");


}
