package com.uploadfile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.sql.ClientInfoStatus;
import java.sql.SQLOutput;
import java.time.Instant;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class UploadFileClasspdf {


    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        //HashMap<String,Object> chromePrefs= new HashMap<String,Object>();

       /* chromePrefs.put("profile.default_content_settings.popups",0);
        chromePrefs.put("download.default_directory","C:\\Users\\cgualteros\\Documents\\manejodearchivos");
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("prefs",chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window();*/



       /* Collection<Object> opciones=options.asMap().values();
        for (Object obj:opciones ) {

            System.out.println("QUE ES ESTO"+obj.toString());
        }

      /*  Iterator opc=opciones.stream().iterator();
        for (Iterator it = opc; it.hasNext(); ) {
            Object o = it.next();
            System.out.println("haha"+o);
        }
*/
        //opciones.forEach(Object obj>System.out.println(););
      //  options.asMap().values();

        //for (Object obj:opciones ) {

          //  System.out.println("QUE ES ESTO"+obj.toString());
        //}




    }


    @After
    public void tearDown(){



    }

    @Test
    public void test() throws InterruptedException {


        String nombrepdf="RESULTADO DE PRUEBAS.pdf";
      File file=new File("C:\\Users\\cgualteros\\Documents\\manejodearchivos"+nombrepdf);
      String path =file.getAbsolutePath();



        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", "C:\\Users\\cgualteros\\Documents\\manejodearchivos");
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-minimized");
        options.addArguments("--safebrowsing-disable-download-protection");
        options.addArguments("safebrowsing-disable-extension-blacklist");
        ChromeDriver chromeDriver= new ChromeDriver(options);

        WebDriver driver =  new ChromeDriver(options);
        driver.get("https://www.ilovepdf.com/es/pdf_a_word");




      //driver.get("https://the-internet.herokuapp.com/upload");
      //driver.get("https://www.ilovepdf.com/es/pdf_a_word");
        //Thread.sleep(20000);
        WebDriverWait wait = new WebDriverWait(driver,5);
        String prueba=driver.findElement(By.linkText( "Seleccionar archivo PDF")).getText();
        System.out.println(prueba);
        driver.findElement(By.linkText( "Seleccionar archivo PDF")).click();
        Thread.sleep(3000);
        driver.quit();
     // driver.findElement(By.xpath("//span[contains(text(),'Seleccionar archivos PDF')]")).sendKeys(path);;


      //String text =driver.findElement(By.id("//span")).getText();
      //  System.out.println("archivo recuperado: "+text);
      //assertEquals("prueba.txt",text);


    }
}
