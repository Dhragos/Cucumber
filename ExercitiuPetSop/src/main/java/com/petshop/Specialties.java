package com.petshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Specialties {

    WebElement addSpecialty;
    WebElement homeSpecialty;
    WebElement nameSpecialtyField;
    WebElement saveSpecialty;
    List<WebElement> specTypesList;
    List<WebElement> editButtonList;
    List<WebElement> deleteButtonList;
    WebDriver webDriver;


    public Specialties(WebDriver webDriver) {
        this.webDriver = webDriver;
        addSpecialty = webDriver.findElement(By.xpath("//button[contains(text(),'Add')]"));
        homeSpecialty = webDriver.findElement(By.xpath("//button[contains(text(),'Home')]"));
        specTypesList = webDriver.findElements(By.xpath("//input[@id]"));
        editButtonList = webDriver.findElements(By.xpath("//tbody//tr//td[2]//button[1]"));
        deleteButtonList = webDriver.findElements(By.xpath("//tbody//tr//td[2]//button[2]"));
    }


    public void clickAddNewSpec() {
        addSpecialty.click();
        nameSpecialtyField = webDriver.findElement(By.id("name"));
        saveSpecialty = webDriver.findElement(By.xpath("//button[@type='submit']"));
        nameSpecialtyField.sendKeys("epidermolog");
        saveSpecialty.click();
    }

        // metoda care parcurge lista de specialitati si gaseste specializarea introdusa.
    public void editSpec(String specName) {
        for (int i = 0; i < specTypesList.size(); i++) {
            String var = specTypesList.get(i).findElement(By.id(String.valueOf(i))).getAttribute("value");
            if (specName.equals(var)) {
                System.out.println("sf");
                editButtonList.get(i).click();
                break;
            }
        }
    }

    // metoda care parcurge lista de specialitati si gaseste specializarea introdusa.
    public void deleteSpec(String specName) {
        for (int i = 0; i < specTypesList.size(); i++) {
            String var = specTypesList.get(i).findElement(By.id(String.valueOf(i))).getAttribute("value");
            if (specName.equals(var)) {
                deleteButtonList.get(i).click();
                break;
            }
        }
    }
}
