package com.petshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VeterinariansList {

    public List<WebElement> veterinarians;                   // lista de webElements;
    public List<WebElement> editVet;
    public List<WebElement> deleteVet;
    public WebDriver webDriver;


    public VeterinariansList(WebDriver webDriver) {
        veterinarians = webDriver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        editVet = webDriver.findElements(By.xpath("//table/tbody/tr/td[3]/button[1]"));
        deleteVet = webDriver.findElements(By.xpath("//table/tbody/tr/td[3]/button[2]"));
        this.webDriver = webDriver;

    }

    public boolean doesVetExists(String vetExist) {          //verifica daca un elem din lista e ceea ce am creat.
        for (WebElement vets : veterinarians) {
            if (vets.getText().equals(vetExist)) {           //loop care verifica lista
                return true;
            }
        }
        return false;
    }

    public void editNewVet(String vetExist) {               //parcurge lista de veterinari si gaseste veterianarul adaugat.
        for (int i = 0; i < veterinarians.size();i++){
            if(veterinarians.get(i).getText().equals(vetExist)){
                editVet.get(i).click();
            }
        }

    }
}