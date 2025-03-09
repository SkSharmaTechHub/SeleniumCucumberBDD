package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class TestContextSetup {

    public WebDriver driver;
    public String landingPageProductName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException {
    	
        testBase = new TestBase();  // Initialize testBase first
        driver = testBase.WebDriverManager();  // Assign WebDriver from testBase
        pageObjectManager = new PageObjectManager(driver);
        genericUtils = new GenericUtils(driver);
    }
}
