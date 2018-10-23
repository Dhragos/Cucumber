package com.petshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditSpecialties {
    WebDriver webDriver;
    WebElement specUpdate;
    WebElement specNameField;

    public EditSpecialties(WebDriver webDriver){
        specNameField = webDriver.findElement(By.id("name"));
        specUpdate = webDriver.findElement(By.xpath("//button[@type='submit']"));
    }

    public void editSpecType(){
        specNameField.clear();

        specNameField.sendKeys("eye specialist");
        specUpdate.click();
    }
}