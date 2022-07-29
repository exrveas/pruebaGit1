package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ClaseBase;

public class PaginaTricot extends ClaseBase {

    public PaginaTricot(WebDriver driver) {
        super(driver);
    }

    //localizadores

    By locatorBtnIniciarSesionTricot = By.xpath("//a[contains(text(),'Inicia Sesión')]");

    By locatorTxtMailTricot = By.xpath("//body/div[@id='menu_inicia_sidebar']/div[1]/form[1]/input[1]");

    By locatorTxtPassTricot = By.xpath("//body/div[@id='menu_inicia_sidebar']/div[1]/form[1]/input[2]");

    By locatorBtnIngresarTricot = By.xpath("//body/div[@id='menu_inicia_sidebar']/div[1]/form[1]/input[3]");

    By locatorMsjeClaveinvalida = By.xpath("//p[@id='error_msg']");

    By locatorLinkOlvidasteContraseña = By.xpath("//a[contains(text(),'¿Olvidaste tu contraseña?')]");

    By locatorTxtMailRecuperar = By.xpath("//input[@id='email_recupera']");

    By locatorBtnIngresa2 = By.xpath("//body/div[@id='menu_inicia_sidebar']/div[2]/div[1]/form[1]/input[2]");

    By locatorMsjeClaveEnviada = By.xpath("//p[contains(text(),'Tu clave ha sido enviada al mail ingresado.')]");

    By locatorBtnPagarVisaT = By.xpath("//header/div[@id='upper_menu']/div[1]/ul[1]/li[1]/a[1]");

    By locatorBtnSeguirPedidos = By.xpath("//header/div[@id='upper_menu']/div[1]/ul[1]/li[2]/a[1]");

    By locatorBtnBuscar = By.xpath("//span[contains(text(),'Buscar')]");

    By locatorTxtBuscar = By.xpath("//input[@id='search_input']");

    By locatorBtnLupa = By.xpath("//header/div[@id='search_overlay']/div[1]/form[1]/span[1]/i[1]");

    By locatorBtnZapatilla = By.xpath("//body/div[3]/div[1]/section[2]/article[1]/a[1]/figure[1]/img[1]");

    By locatorBtnAgregar = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]");

    By locatorBtnBolsa = By.xpath("//header/div[@id='upper_menu']/div[1]/ul[1]/li[8]/a[2]/div[1]");

    By locatorBtnCantidadProducto = By.xpath("//header/div[@id='upper_menu']/div[1]/ul[1]/li[8]/a[2]/span[1]");

    By locatorBtnRemover = By.xpath("//body/section[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/button[1]");

    By locatorImgTriCar = By.xpath("//body/section[1]/div[1]/div[2]/section[1]/div[2]/div[1]/img[1]");

    By locatorMsjeCarroVacio = By.xpath("//span[contains(text(),'Tienes 0 producto(s) en tu bolsa')]");


    public void iniciarSesionTricot(String user, String pass) {
        click(esperaExplicita(locatorBtnIniciarSesionTricot));
        esperarXSegundos(3000);
        agregarTexto(locatorTxtMailTricot,user);
        agregarTexto(locatorTxtPassTricot,pass);
        esperarXSegundos(3000);
        click(esperaExplicita(locatorBtnIngresarTricot));
    }

    public String claveInvalidaMsje(){
        return obtenerTexto(esperaExplicita(locatorMsjeClaveEnviada));
    }

    public void contrasenaOlvidada(String mail){
        click(esperaExplicita(locatorBtnIniciarSesionTricot));
        click(esperaExplicita(locatorLinkOlvidasteContraseña));
        agregarTexto(locatorTxtMailRecuperar,mail);
        click(esperaExplicita(locatorBtnIngresa2));
    }

    public String claveEnviada(){
        return obtenerTexto(esperaExplicita(locatorMsjeClaveEnviada));
    }

    public void IrAPagarVisaT(){
        click(esperaExplicita(locatorBtnPagarVisaT));
    }

    public void IrASeguimiento(){
        click(esperaExplicita(locatorBtnSeguirPedidos));
    }

    public void agregarABolsa(String producto){
        click(esperaExplicita(locatorBtnBuscar));
        agregarTexto(locatorTxtBuscar, producto);
        click(esperaExplicita(locatorBtnLupa));
        click(esperaExplicita(locatorBtnZapatilla));
        click(esperaExplicita(locatorBtnAgregar));
        click(esperaExplicita(locatorBtnBolsa));

    }

    public void eliminarproducto(String producto){
        click(esperaExplicita(locatorBtnBuscar));
        agregarTexto(locatorTxtBuscar, producto);
        click(esperaExplicita(locatorBtnLupa));
        click(esperaExplicita(locatorBtnZapatilla));
        click(esperaExplicita(locatorBtnAgregar));
        click(esperaExplicita(locatorBtnBolsa));
        esperarXSegundos(4000);
        click(esperaExplicita(locatorBtnRemover));
    }

    public String mensajeCarroVacio(){
        return obtenerTexto(esperaExplicita(locatorMsjeCarroVacio));
    }
    public Boolean VerificaImagenPagar(){
        return estaDesplegado(locatorImgTriCar);
    }

}
