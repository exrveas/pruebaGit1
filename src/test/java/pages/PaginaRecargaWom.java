package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaRecargaWom extends ClaseBase {

    public PaginaRecargaWom(WebDriver driver) {
        super(driver);
    }

    By locatorTxtLinea = By.xpath("//body");

    By locatorBtnMonto = By.xpath("//body");
}
