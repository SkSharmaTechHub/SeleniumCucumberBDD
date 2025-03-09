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
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {


	String offerPageProductName;
	
	TestContextSetup testContextSetup;
	
	PageObjectManager pageObjectManager;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		
		this.testContextSetup=testContextSetup;
	}
	
	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
	
		switchToOffersPage();
		
		OffersPage offersPage=new OffersPage(testContextSetup.driver);
		offersPage.searchItem(shortName);
	    //testContextSetup.driver.findElement(By.id("search-field")).sendKeys(shortName);
	  
	  Thread.sleep(5000);
	  //offerPageProductName=testContextSetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	  
	  offerPageProductName=offersPage.getProductName();
	  
	}
	public void switchToOffersPage() throws InterruptedException {
		
		//LandingPage landingPage=new LandingPage(testContextSetup.driver);
		LandingPage landingPage=testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDeals();
	    //testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		 Thread.sleep(5000);
		testContextSetup.genericUtils.SwitchWindowToChild();
	}
	@And("Validate product page in Offer Page matches with Landing Page")
	public void Validate_product_page_in_Offer_Page_matches_with_Landing_Page() {
		
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
		
	}
}
