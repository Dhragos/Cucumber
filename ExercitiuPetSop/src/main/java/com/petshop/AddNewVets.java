package com.petshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddNewVets {

     WebElement firstName;
     WebElement lastName;
     Select type;
     WebElement saveVet;


    public AddNewVets (WebDriver webDriver) {
        //    addNewVet = webDriver.findElement(By.xpath("//petclinic/vets/add"));
        firstName = webDriver.findElement(By.id("firstName"));
        lastName = webDriver.findElement(By.id("lastName"));
        type = new Select(webDriver.findElement(By.id("specialties")));
        saveVet = webDriver.findElement(By.xpath("//button[@type='submit']"));
    }


    public void clickSave() {
        saveVet.click();
    }

    public void addNewVet(){
        firstName.sendKeys("Dan");
        lastName.sendKeys("Ionescu");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        type.selectByVisibleText("surgery");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    }
