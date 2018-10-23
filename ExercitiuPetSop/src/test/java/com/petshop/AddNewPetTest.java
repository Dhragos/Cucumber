package com.petshop;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class AddNewPetTest extends BaseClass {
    public NavPage navPage;
    public PetTypes petTypes;
    public HomePage homePage;
    public EditPets editPets;


    //Test Add New Pet
    @Test
    public void testAddNewPet() {
        navPage = new NavPage(webDriver);       //open MainPage and click onPet Types
        navPage.clickPet();
        //
        petTypes = new PetTypes(webDriver);     //execute method to Add New Pet
        petTypes.clickaddNewPet();

    }

    //Test Edit New Pet
    @Test
    public void testEditPet() {
        navPage = new NavPage(webDriver);       //open MainPage and click onPet Types
        navPage.clickPet();
        petTypes = new PetTypes(webDriver);     //execute method and find Gecko pet type
        petTypes.editPets("Gecko");

        editPets = new EditPets(webDriver);     //execute method and add new "porumbel" pet type
        editPets.editPetType();
    }

    //Test Delete New Pet
    @Test
    public void deletePet() {
        navPage = new NavPage(webDriver);       //open MainPage and click onPet Types
        navPage.clickPet();
        petTypes = new PetTypes(webDriver);
        petTypes.deletePets("Gecko");   //execute method and delete new pet type
    }


    //Test Navigate to HomePage
    @Test
    public void goToHomePage() {
        navPage = new NavPage(webDriver);       //open MainPage and click on Pet Types
        navPage.clickPet();

        petTypes = new PetTypes(webDriver);
        petTypes.clickHomePet();                //click on Home button.

        try {
            Thread.sleep(2000);             //wait 2 sec
        } catch (InterruptedException e) {
            e.printStackTrace();

            homePage = new HomePage(webDriver);
            homePage.getImage();                        //preia imaginea din homePage
            Assert.assertTrue(homePage.getImage());      //valideaza ca imaginea este afisata.
        }

    }
}
