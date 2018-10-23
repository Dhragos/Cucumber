package com.petshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebElement PaginaStart;             //declaram elementele
    private WebElement header;
    private WebElement image;

    public HomePage(WebDriver webDriver) {

        PaginaStart = webDriver.findElement(By.xpath("//app-welcome/h1"));      //localizam elementele;
        header = webDriver.findElement(By.xpath("//h2"));
        image = webDriver.findElement(By.className("img-responsive"));
    }
    public boolean titleIsDisplayed() {
        return PaginaStart.isDisplayed();
    }
    public String getHeaderText() {
        return header.getText();
    }
    public boolean getImage() {
        return image.isDisplayed();
    }
}
