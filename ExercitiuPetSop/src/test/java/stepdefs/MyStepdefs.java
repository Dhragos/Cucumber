package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver webDriver;

    @Given("^I have acces to go to HomePage$")
    public void iHaveAccesToGoToHomePage() throws Throwable {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //asteapta 5 sec pentru a aparea elementul
    }

    @When("^I click Specialities menu$")
    public void iClickPetTypesMenu() throws Throwable {
        webDriver.findElement(By.xpath("//span[contains(text(),'Specialties')]")).click();

    }

    @Then("^Validate if Specialities title exists$")
    public void validateIfSpecialitiesTitleExists() throws Throwable {
        webDriver.findElement(By.xpath("//h2[contains(text(),'Specialties')]")).isDisplayed();
    }

    @Given("^User has acces to go to HomePage$")
    public void userHasAccesToGoToHomePage() throws Throwable {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //asteapta 5 sec pentru a aparea elementul
    }

    @When("^User clicks on veterinarians menu$")
    public void userClicksOnVeterinariansMenu() throws Throwable {
        webDriver.findElement(By.xpath("//a[text()='Veterinarians']")).click();
        webDriver.findElement(By.xpath("//a[@href='/petclinic/vets/add']")).click();
        webDriver.findElement(By.id("firstName")).sendKeys("Vlad");
        webDriver.findElement(By.id("lastName")).sendKeys("Doinea");
        webDriver.findElement(By.id("specialties")).click();
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @Then("^User adds a new veterinarian$")
    public void userAddsANewVeterinarian() throws Throwable {
        webDriver.findElement(By.xpath("//h2[contains(text(),'Veterinarians')]"));


    }
}
