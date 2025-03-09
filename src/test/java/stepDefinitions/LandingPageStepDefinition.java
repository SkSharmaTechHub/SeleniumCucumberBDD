package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefinition {

public WebDriver driver;
public String landingPageproductName;

TestContextSetup testContextSetup;

PageObjectManager pageObjectManager;

LandingPage landingPage;

public LandingPageStepDefinition(TestContextSetup testContextSetup ) {
	
	this.testContextSetup=testContextSetup;
	this.landingPage=testContextSetup.pageObjectManager.getLandingPage();
	
}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	
	}
	@When("^User searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		//LandingPage landingPage=new LandingPage(testContextSetup.driver);

		landingPage.searchItem(shortName);
		
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(5000);
		//testContextSetup.landingPageproductName=testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		testContextSetup.landingPageProductName=landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName + " is extracted from Home Page");
		
		
	}
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity) {
	
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
		
	}
	
}
