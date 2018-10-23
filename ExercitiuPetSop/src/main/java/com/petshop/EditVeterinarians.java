package com.petshop;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditVeterinarians {

    public WebElement specialties;
    public WebElement vetEditButton;
    WebDriver webDriver;


    public EditVeterinarians(WebDriver webDriver) {
        this.webDriver = webDriver;
        specialties = webDriver.findElement(By.xpath("//div[@class='mat-select-value']"));
        vetEditButton = webDriver.findElement(By.xpath("//button[@type='submit']"));
    }

    public void addNewSpecialties() {
        specialties.click();
        WebElement option = webDriver.findElement(By.xpath("//mat-option[1]"));
        option.click();
        option.sendKeys(Keys.ESCAPE);
        vetEditButton.click();
    }
}