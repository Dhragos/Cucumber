package com.petshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PetTypes {

    WebElement addPet;
    WebElement homePet;
    WebElement namePetField;
    WebElement savePet;
    WebDriver webDriver;
    List<WebElement> petTypesList;
    List<WebElement> editButtonList;
    List<WebElement> deleteButtonList;


    public PetTypes(WebDriver webDriver) {

        addPet = webDriver.findElement(By.xpath("//button[contains(text(),'Add')]"));
        homePet = webDriver.findElement(By.xpath("//button[contains(text(),'Home')]"));
        this.webDriver = webDriver;
        petTypesList = webDriver.findElements(By.xpath("//input[@id]"));                         //indentificarea listei de Pet-uri
        editButtonList = webDriver.findElements(By.xpath("//tbody//tr//td[2]//button[1]"));      //indentificarea listei de Edit-uri
        deleteButtonList = webDriver.findElements(By.xpath("//tbody//tr//td[2]//button[2]"));    //indentificarea listei de Delete-uri

    }

    public void clickHomePet() {
        homePet.click();
    }


    public void clickaddNewPet() {
        addPet.click();
        namePetField = webDriver.findElement(By.id("name"));
        savePet = webDriver.findElement(By.xpath("//button[@type='submit']"));
        namePetField.sendKeys("Gecko");
        savePet.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void editPets(String petName) {
        for (int i = 0; i < petTypesList.size(); i++) {

            String var = petTypesList.get(i).findElement(By.id(String.valueOf(i))).getAttribute("value");

            if (petName.equals(var)) {

                System.out.println("zg");
                editButtonList.get(i).click();
                break;
            }


        }

    }

    public void deletePets(String petName) {
        for (int i = 0; i < petTypesList.size(); i++) {

            String var = petTypesList.get(i).findElement(By.id(String.valueOf(i))).getAttribute("value");

            if (petName.equals(var)) {

                deleteButtonList.get(i).click();
                break;
            }

        }
    }
}
