package org.orgselenium.indeed.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.orgselenium.indeed.pages.LandingPage;
import org.testng.annotations.AfterMethod;

public class IndeedSearchTest {
	WebDriver driver;
	
	 @DataProvider
	 public Object[][] testData(){
	  	return new Object[][]{
			new Object[] {"Selenium tester","Amsterdam"},
			new Object[] {"SoapUI","Amsterdam"},
			new Object[] {"Cucumber tester","Amsterdam"},
			new Object[] {"Mobile tester","Amsterdam"},
			};
		}

	  @Test(dataProvider="testData")
	  public void testSearch(String search, String location) {
		 LandingPage lp = PageFactory.initElements(driver,LandingPage.class);
		 System.out.println(lp.performSearch(search,location).size());
		 lp.getSearchAmount(search,location);
	  }
	  @BeforeMethod
	  public void beforeClass() {
		  driver = new FirefoxDriver();
		  driver.navigate().to("http://www.indeed.nl/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  }

	  @AfterMethod
	  public void afterClass() {
		  driver.quit();
	  }
}
