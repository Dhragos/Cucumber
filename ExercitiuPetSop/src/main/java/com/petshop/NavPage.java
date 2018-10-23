package com.petshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NavPage {

    WebElement ownersLink;            //obiect tip webElement
    WebElement ownersAll;
    WebElement ownersAdd;
    WebElement veterinariansLink;
    WebElement vetsAdd;
    WebElement petTypes;
    WebElement specialties;
    WebElement vetsAll;
    WebDriver webDriver;


    public NavPage(WebDriver webDriver) {                   //identifica elementele din MainPage.
        ownersLink = webDriver.findElement(By.xpath("//a[text()='Owners']"));
        ownersAll = webDriver.findElement(By.xpath("//a[@href='/petclinic/owners']"));
        ownersAdd = webDriver.findElement(By.xpath("//a[@href='/petclinic/owners/add']"));
        veterinariansLink = webDriver.findElement(By.xpath("//a[text()='Veterinarians']"));
        vetsAdd = webDriver.findElement(By.xpath("//a[@href='/petclinic/vets/add']"));
        vetsAll = webDriver.findElement(By.xpath("//a[@href='/petclinic/vets']"));
        petTypes = webDriver.findElement(By.xpath("//span[contains(text(),'Pet Types')]"));
        specialties = webDriver.findElement(By.xpath("//span[contains(text(),'Specialties')]"));


    }

    public void clickAllOwners() {         //metoda click executa click pe:
        ownersLink.click();          //butonul owners;
        ownersAll.click();              //butonul all;
    }

    public void clickNewOwners() {      //metoda clickNew executa click pe:

        ownersLink.click();       //butonul owners;
        ownersAdd.click();           //butonul addNewl
    }

    public void clickVeteranians() {
        veterinariansLink.click();      //butonul veterinarians
    }

    public void clickAddNewVet() {
        vetsAdd.click();
    }
    public void clickAllVets() {
        vetsAll.click();
    }

    public void clickPet() {
        petTypes.click();
    }

    public void clickSpecialties() {
        specialties.click();
    }
}
