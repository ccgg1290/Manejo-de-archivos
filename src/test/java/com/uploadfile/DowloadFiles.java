package com.uploadfile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DowloadFiles {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/download");
        // driver.get("https://www.google.com");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test() throws IOException {
        String link =driver.findElement(By.cssSelector("div.example>a")).getAttribute("href");

        HttpURLConnection httpconection=(HttpURLConnection) (new URL(link).openConnection());
        httpconection.setRequestMethod("HEAD");
        httpconection.connect();

        String contentype=httpconection.getContentType();
        int contentlenght=httpconection.getContentLength();

        System.out.println("contentype: "+contentype+" contentlenght: "+contentlenght);

        assertEquals(contentlenght,4936);
        assertNotEquals(contentype,"aplication/octet-stream");

        //h3[contains(text(),'Unir PDF')]
    }





}
