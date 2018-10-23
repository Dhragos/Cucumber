package com.petshop;

import org.junit.Assert;
import org.junit.Test;

public class AddNewVetTest extends BaseClass {
    public NavPage navPage;
    public AddNewVets addNewVets;
    public EditVeterinarians editVets;

    //Test Adauga un nou veterinar
    @Test
    public void newAddVetTest() {
        navPage = new NavPage(webDriver);
        navPage.clickVeteranians();

        // open add new vet
        navPage = new NavPage(webDriver);
        navPage.clickAddNewVet();

        // add a new vet
        addNewVets = new AddNewVets(webDriver);
        addNewVets.addNewVet();
        addNewVets.clickSave();
    }

    //Test Verifica si Editeaza un nou veterinar
    @Test
    public void editNewVetTest() {
        navPage = new NavPage(webDriver);
        navPage.clickVeteranians();
        navPage.clickAllVets();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        VeterinariansList vetsList = new VeterinariansList(webDriver);
        Assert.assertTrue(vetsList.doesVetExists("Dan Ionescu"));
        vetsList.editNewVet("Dan Ionescu");
        System.out.println();

        //editeaza noul veterinar
        editVets = new EditVeterinarians(webDriver);
        editVets.addNewSpecialties();
    }

}


