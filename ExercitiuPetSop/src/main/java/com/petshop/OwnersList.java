package com.petshop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;


public class OwnersList {


    List<WebElement> ownersList;


    public OwnersList(WebDriver webDriver) {
        ownersList = webDriver.findElements(By.className("ownerFullName"));

    }

    public List<String> getOwnersList() {
        List<String> ownerNames = new ArrayList<String>();
        for( WebElement we : ownersList) {
            ownerNames.add(we.getText());           //se pune textul din fiecare element intr.o noua lista ownerNames
        }
        return ownerNames;
    }

    public boolean isOwnerPrezent(String ownerNam) {
        for (String st : getOwnersList()){           //cauta in noua lista creata in metoda getOwnersList
        if (st.equals(ownerNam))                    //verifica daca e egal cu stringul din text
            return true;
        }
        return false;
        }
    }
