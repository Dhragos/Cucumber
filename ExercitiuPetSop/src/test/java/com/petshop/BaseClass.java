package com.petshop;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class BaseClass {
    WebDriver webDriver;        //declar obiect de tip webdriver

    @Before
    public void init() {                                                                 //init - intial
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //asteapta 5 sec pentru a aparea elementul
    }

    @After
    public void teardown() {
        webDriver.quit();
    }
    }
