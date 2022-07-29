package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaPlanesSantander extends ClaseBase {

    public PaginaPlanesSantander(WebDriver driver) {
        super(driver);
    }

    By locatorCuentaLife = By.xpath("//h3[contains(text(),'Cuenta Corriente Santander Life')]");

    public void IrACuentaLife(){
        click(esperaExplicita(locatorCuentaLife));
    }
}
