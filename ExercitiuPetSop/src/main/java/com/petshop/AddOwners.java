package com.petshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AddOwners {
    WebElement firstName;
    WebElement lastName;
    WebElement address;
    WebElement city;
    WebElement telephone;
    WebElement error;
    WebElement submitOwner;
    List<WebElement> owner;


    public AddOwners(WebDriver webDriver) {
        firstName = webDriver.findElement(By.id("firstName"));
        lastName = webDriver.findElement(By.id("lastName"));
        address = webDriver.findElement(By.id("address"));
        city = webDriver.findElement(By.id("city"));
        telephone = webDriver.findElement(By.id("telephone"));
        submitOwner = webDriver.findElement(By.xpath("//button[@type='submit']"));

    }

    public boolean addIncorrect(WebDriver webDriver) {
        firstName.sendKeys("Alexandru");
        lastName.sendKeys("Popescu");
        address.sendKeys("Cantemir nr.5");
        city.sendKeys("Bucuresti");
        telephone.sendKeys("fdsgsoif");

        error = webDriver.findElement(By.className("help-block"));
        return error.isDisplayed();
    }

    public void addCorrect() {
        firstName.sendKeys("Alexandru");
        lastName.sendKeys("Popescu");
        address.sendKeys("Cantemir nr.5");
        city.sendKeys("Bucuresti");
        telephone.sendKeys("0736248006");
    }

    public void submitOwner() {

        submitOwner.click();
    }

    public void deleteCharacters() {
        telephone.clear();
    }

    public List<WebElement> newOwnerExists() {
        return owner;
    }

    public boolean checkNewOwner(String newOwner) {
        List<String> textList = new ArrayList<String>();
        for (WebElement elemt : owner) {
            textList.add(elemt.getText());
        }
        for (String res : textList) {
            if (res.equals(newOwner)) {
                return true;
            }

        }
        return true;
    }
}



