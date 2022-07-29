package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaCuentaLife extends ClaseBase {

    public PaginaCuentaLife(WebDriver driver) {
        super(driver);
    }

    By locatorBtnAbrelaAqui = By.xpath("//body/div[@id='modyo-31cdd39a-8b80-4986-a4e1-48f9563b02ed/594e931e8a8a0ba92c09ce8f20cc14708fa3c5011ecbf1029f364ea9a8708949']/div[@id='cta-cte-life']/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]");

    public void irAAbrirCuentaCorriente(){
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnAbrelaAqui));
    }
}
