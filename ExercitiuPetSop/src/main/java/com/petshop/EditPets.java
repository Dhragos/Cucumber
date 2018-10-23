package com.petshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPets {
    WebElement nameField;
    WebElement updateButton ;

    public EditPets(WebDriver webDriver) {
        nameField = webDriver.findElement(By.id("name"));
        updateButton = webDriver.findElement(By.xpath("//button[@type='submit']"));
    }
    public void editPetType(){
        nameField.clear();

        nameField.sendKeys("porumbel");
        updateButton.click();
    }
}
