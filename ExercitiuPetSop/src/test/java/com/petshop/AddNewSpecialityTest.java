package com.petshop;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AddNewSpecialityTest extends BaseClass {
    public NavPage navPage;
    public Specialties specialties;
    public  EditSpecialties editSpecialties;

    //Test Adauga o noua Specializare
    @Test
    public void testAddNewSpec() {
        navPage = new NavPage(webDriver);
        navPage.clickSpecialties();

        specialties = new Specialties(webDriver);
        specialties.clickAddNewSpec();
    }

    //Test Editeaza noua specializare adaugata
    @Test
    public void testEditNewSpec(){
        navPage = new NavPage(webDriver);
        navPage.clickSpecialties();

        specialties = new Specialties(webDriver);
        specialties.editSpec("surgery");

        editSpecialties = new EditSpecialties(webDriver);
        editSpecialties.editSpecType();

    }

    //Test Sterge noua specializare adaugata
    @Test
    public void deleteSpec() {
        navPage = new NavPage(webDriver);
        navPage.clickSpecialties();
        specialties = new Specialties(webDriver);
        specialties.deleteSpec("eye specialist");
    }

}
