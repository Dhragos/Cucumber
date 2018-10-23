package com.petshop;

import org.junit.Assert;
import org.junit.Test;

public class HomePageTest extends BaseClass {
    public HomePage homePage;
    public NavPage navPage;
    public OwnersList owners;
    public AddOwners addOwners;


    @Test
    public void setHomePageTest() {
        homePage = new HomePage(webDriver);
        Assert.assertTrue(homePage.titleIsDisplayed());                       //valideaza ca MainPage este afisata
        Assert.assertEquals("Welcome", homePage.getHeaderText());     //valideaza ca textul "Welcome" este afisat
        Assert.assertTrue(homePage.getImage());                               //valideaza ca imaginea este afisata.
        try {
            Thread.sleep(2000);                     // pauza de 2 sec;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Test Verifica ca ownerul exista
    @Test
    public void checkOwner() {
        navPage = new NavPage(webDriver);
        navPage.clickAllOwners();                       //executa comanda click pe owners + all din NavPage;

        owners = new OwnersList(webDriver);
        Assert.assertTrue(owners.isOwnerPrezent("Alexandru Popescu"));  //valideaza ca ownerul " " exista;
    }

    //Test cu adaugare owner cu telefon invalid
    @Test
    public void addNewOwner()  {
        navPage = new NavPage(webDriver);
        navPage.clickNewOwners();                        // click pe owners + addNew din NavPage;

        addOwners = new AddOwners(webDriver);
        addOwners.addIncorrect(webDriver);              //adauga date invalide in telefon

        addOwners = new AddOwners(webDriver);
        addOwners.deleteCharacters();                   //sterge caracterele din telefon
        addOwners.addCorrect();                         //adauga caractere valide
        try {
            Thread.sleep(2000);                    //pauza 2 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addOwners.submitOwner();                        //click pe Add Owner
    }

    //Test cu date valide
    @Test
    public void addCorrectNum() {
        navPage = new NavPage(webDriver);
        navPage.clickNewOwners();                      // click  pe owners + addNew din NavPage;
        addOwners = new AddOwners(webDriver);

        addOwners.addCorrect();                        // adauga caractere valide
        addOwners.submitOwner();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Test Verifica daca noul Owner exista
    @Test
    public void verifyNewOwner() {

        navPage = new NavPage(webDriver);                // click  pe owners + addNew din NavPage;
        navPage.clickNewOwners();

        //   addOwners = new AddOwners(webDriver);
        addOwners.addIncorrect(webDriver);              //adauga caractere invalide

        //   addOwners.submitOwner();

        addOwners = new AddOwners(webDriver);           // click  pe owners + addNew din NavPage;
        addOwners.deleteCharacters();                   //sterge caracterele din telefon
        addOwners.addCorrect();                         // adauga caractere valide
        try {
            Thread.sleep(1000);                    //pauza o secunda
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        addOwners.submitOwner();                        //click pe Add Owner

        Assert.assertTrue(addOwners.checkNewOwner("Alexandru Popescu"));        //valideaza ca ownerul " " exista;
    }

}
