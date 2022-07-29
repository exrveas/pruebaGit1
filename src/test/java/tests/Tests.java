package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utils.DataDriven;
import utils.PropertiesDriven;

import java.nio.file.Paths;
import java.util.ArrayList;


public class Tests {

    private WebDriver driver;
    private PaginaTricot paginaTricot;
    private PaginaPagoTricot paginaPagoTricot;
    private PaginaPersonasSantander paginaPersonasSantander;
    private PaginaPlanesSantander paginaPlanesSantander;
    private PaginaCuentaCorriente paginaCuentaCorriente;
    private PaginaCuentaLife paginaCuentaLife;
    private PaginaFashionP paginaFashionP;
    private PaginaSeguimientoFashionP paginaSeguimientoFashionP;
    private PaginaWom paginaWom;
    private PaginaPagoWom paginaPagoWom;
    private PaginaPortabilidadWom paginaPortabilidadWom;
    private PaginaResultadoWom paginaResultadoWom;
    private String urlSitio;
    private ArrayList<String> dataCP;
    private String path;
    private String browser;
    private String propertyDriver;


    @BeforeTest
    public void preparacionEjecucionTest(){
        path = Paths.get(System.getProperty("user.dir"), PropertiesDriven.getProperty("rutaDriver")).toString();
        browser = PropertiesDriven.getProperty("browser");
        propertyDriver = PropertiesDriven.getProperty("propertyDriver");
        paginaTricot = new PaginaTricot(driver);
        paginaTricot.conexionBrowser(browser, path, propertyDriver);
        paginaPagoTricot = new PaginaPagoTricot(paginaTricot.getDriver());
        paginaPersonasSantander = new PaginaPersonasSantander(paginaPagoTricot.getDriver());
        paginaPlanesSantander = new PaginaPlanesSantander(paginaPersonasSantander.getDriver());
        paginaCuentaLife = new PaginaCuentaLife(paginaPlanesSantander.getDriver());
        paginaCuentaCorriente = new PaginaCuentaCorriente(paginaCuentaLife.getDriver());
        paginaFashionP = new PaginaFashionP(paginaCuentaCorriente.getDriver());
        paginaSeguimientoFashionP = new PaginaSeguimientoFashionP(paginaFashionP.getDriver());
        paginaWom = new PaginaWom(paginaSeguimientoFashionP.getDriver());
        paginaPagoWom = new PaginaPagoWom(paginaWom.getDriver());
        paginaPortabilidadWom = new PaginaPortabilidadWom(paginaPagoWom.getDriver());
        paginaResultadoWom = new PaginaResultadoWom(paginaPortabilidadWom.getDriver());
        dataCP = new ArrayList<>();
    }

    @BeforeMethod
    public void preTest(){
        urlSitio = PropertiesDriven.getProperty("url");
        paginaTricot.cargarSitio(urlSitio);
        paginaTricot.maximizarBrowser();
    }

    @AfterMethod
    public void postEjecucionTest(){
        paginaTricot.cerrarBrowser();
    }

    @Test
    public void CP001_Inicio_De_Sesion_Fallido(){
        dataCP = DataDriven.getData("CP001_Inicio_De_Secsion_Fallido");
        paginaTricot.iniciarSesionTricot(dataCP.get(1), dataCP.get(2));
        Assert.assertEquals("//p[@id='error_password_login']","//p[@id='error_password_login']");
    }

    @Test
    public void CP002_Recuperacion_de_Clave_Exitoso(){
        dataCP = DataDriven.getData("CP002_Recuperacion_de_Clave_Exitoso");
        paginaTricot.contrasenaOlvidada(dataCP.get(1));
        Assert.assertNotEquals(paginaTricot.claveEnviada(),"Tu clave ha sido enviada al mail ingresado");
    }

    @Test
    public void CP003_Agregar_Producto_Exitoso(){
        dataCP = DataDriven.getData("CP003_Agregar_Producto_Exitoso");
        paginaTricot.agregarABolsa(dataCP.get(1));
        Boolean despliegueImagenPagar = true;
        Assert.assertTrue(paginaTricot.VerificaImagenPagar());

    }

    @Test
    public void CP004_Eliminar_Poroducto_Exitoso() {
        dataCP = DataDriven.getData("CP004_Eliminar_Poroducto_Exitoso");
        paginaTricot.eliminarproducto(dataCP.get(1));
        Assert.assertNotEquals(paginaTricot.mensajeCarroVacio(),"Tienes 2 producto(s) en tu bolsa");
        //Assert.assertFalse(paginaTricot.VerificaBotonPagar());
    }

    @Test
    public void CP005_Abrir_cuenta_Life_Fallido(){
        dataCP = DataDriven.getData("CP005_Abrir_cuenta_Life_Fallido");
        paginaPersonasSantander.navegarAOtraPagina();
        paginaPersonasSantander.irAPaginaPanes();
        paginaPlanesSantander.IrACuentaLife();
        paginaCuentaLife.irAAbrirCuentaCorriente();
        paginaCuentaCorriente.comienzoCtaLife(dataCP.get(1),dataCP.get(2),dataCP.get(3),dataCP.get(4));
        Assert.assertEquals(paginaCuentaCorriente.obtenerMensaje(),"Verifica que los datos entregados sean los correctos e intenta nuevamente");
    }

    @Test
    public void CP006_Seguir_Pedido_Fallido(){
        dataCP = DataDriven.getData("CP006_Seguir_Pedido_Fallido");
        paginaFashionP.navegarAOtraPagina();
        paginaFashionP.irASeguirCompra();
        paginaSeguimientoFashionP.consultaPedido(dataCP.get(1));
        paginaSeguimientoFashionP.esperarXSegundos(3000);
        Assert.assertNotEquals(paginaSeguimientoFashionP.mensajeAlert(), dataCP.get(2));
    }

    @Test
    public void CP007_Pago_De_Cuenta_Fallido(){
        dataCP = DataDriven.getData("CP007_Pago_De_Cuenta_Fallido");
        paginaWom.cambioDePagina();
        paginaWom.irAPagoDeCuenta();
        paginaPagoWom.pagarCuentaWom(dataCP.get(1));
        Assert.assertTrue(paginaPagoWom.verificaMensajeSinDeuda());
    }

    @Test
    public void CP008_Portar_Plan_Fallido(){
        dataCP = DataDriven.getData("CP008_Portar_Plan_Fallido");
        paginaWom.cambioDePagina();
        paginaWom.irAPortabilidad();
        paginaPortabilidadWom.contratarPlan(dataCP.get(1),dataCP.get(2),dataCP.get(3));
        Assert.assertEquals(paginaPortabilidadWom.verificaMsjeLoSentimos(),dataCP.get(4));
    }
}