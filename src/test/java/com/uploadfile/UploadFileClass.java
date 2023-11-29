package com.uploadfile;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class UploadFileClass {


    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       // driver.get("https://www.google.com");
    }


    @After
    public void tearDown(){

        driver.quit();

    }

    @Test
    public void test(){
      File file=new File("C:\\Users\\cgualteros\\Documents\\manejodearchivos\\src\\test\\resources\\prueba.txt");
      String path =file.getAbsolutePath();

      driver.get("https://the-internet.herokuapp.com/upload");
      driver.findElement(By.id("file-upload")).sendKeys(path);
      driver.findElement(By.id("file-submit")).click();

      String text =driver.findElement(By.id("uploaded-files")).getText();
        System.out.println("archivo recuperado: "+text);
      assertEquals("prueba.txt",text);


    }
}
