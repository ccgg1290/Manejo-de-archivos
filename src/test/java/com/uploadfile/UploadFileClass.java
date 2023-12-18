package com.uploadfile;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UploadFileClass {


    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_settings.popups", 0);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("ignore-certificate-errors");
        options.addArguments("start-minimized");
        options.addArguments("incognito");
        options.addArguments("disable-infobars");
        options.addArguments("disable-extensions");
        options.addArguments("ignore-certificate-errors");
        //options.addArguments("remote-allow-origins");
        //DesiredCapabilities ssl = DesiredCapabilities.chrome ();
        //ssl.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new ChromeDriver (options);
        //driver = new ChromeDriver();
        driver.manage().window().maximize();






       // driver.get("https://www.google.com");
    }


    @After
    public void tearDown(){

        driver.quit();

    }

    @Test
    public void test() throws InterruptedException {


        driver.get("https://test-www.bancofalabellaempresas.com.co/FrontOffice/Login.aspx");
        //driver.findElement(By.id("file-upload")).sendKeys(path);
        Thread.sleep(5000);
        driver.findElement(By.id("tbGrupoEmpresarial")).sendKeys("23534");
        //driver.findElement(By.id("ddlTipoID")).sendKeys("hahahaha");
        Select objSelect =new Select(driver.findElement(By.id("ddlTipoID")));
        objSelect.selectByVisibleText("Cédula de Ciudadanía");
        driver.findElement(By.name("tbNumeroID")).sendKeys("1049653008");
        driver.findElement(By.name("tbClavePersonal")).sendKeys("976431");
        driver.findElement(By.name("tbToken")).sendKeys("123456");
        String oldTab = driver.getWindowHandle();
        driver.findElement(By.name("btInrgesar")).click();
        //driver.findElement(By.name("lbNombreUsuario")).click();
        //String LBERROR=driver.findElement(By.id("lbError")).getText();
        //String text =driver.findElement(By.id("uploaded-files")).getText();
        //assertEquals(LBERROR,"Los datos ingresados no son válidos.");
        Thread.sleep(20000);
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(newTab.size());
        driver.switchTo().window(newTab.get(1));
        //WebDriverWait wait= new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("lbNombreUsuario")));
        //System.out.println(""+nameUser);
        String HOME_PAGE=driver.findElement(By.id("lbNombreUsuario")).getText();
        assertEquals(HOME_PAGE,"Dayana Andrea Rojas Alba");
        newTab.remove(newTab.get(1));
        System.out.println(newTab.size());
        driver.switchTo().window(newTab.get(0));
        Thread.sleep(5000);
        driver.findElement(By.name("btInrgesar")).click();
        String LBERROR=driver.findElement(By.id("lbError")).getText();
        assertEquals(LBERROR,"Los datos ingresados no son válidos.");






     /* File file=new File("C:\\Users\\cgualteros\\Documents\\manejodearchivos\\src\\test\\resources\\prueba.txt");
      String path =file.getAbsolutePath();

      driver.get("https://the-internet.herokuapp.com/upload");
      driver.findElement(By.id("file-upload")).sendKeys(path);
      driver.findElement(By.id("file-submit")).click();

      String text =driver.findElement(By.id("uploaded-files")).getText();
        System.out.println("archivo recuperado: "+text);
      assertEquals("prueba.txt",text);*/


    }
}
