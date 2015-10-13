package org.orgselenium.indeed.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	WebDriver driver;
	String pageTitle="Werk zoeken | één klik. alle vacatures. Indeed";
	
	@FindBy (xpath = "//*[@id='what']")
	private WebElement searchItem;
	
	@FindBy (xpath = "//*[@id='where']")
	private WebElement searchCity;
	
	@FindBy (xpath = "//*[@id='fj']")
	private WebElement searchButton;
	
	@FindBy (xpath = "//*[@id='resultsCol']")
	private WebElement searchResults;
	
	public LandingPage(WebDriver driver){
		this.driver = driver;
	//	Assert.assertTrue(pageTitle.equals(driver.getTitle()));
		System.out.println(driver.getTitle());
	}

	public List<WebElement> performSearch(String item, String location){
		searchItem.clear();
		searchItem.sendKeys(item);
		searchCity.clear();
		searchCity.sendKeys(location);
		searchButton.click();
		return searchResults.findElements(By.tagName("a"));
	}
	
	public void getSearchAmount(String item, String location){
		List<WebElement> results = performSearch(item, location);
		for (WebElement resultitem : results){
			 System.out.println(resultitem.getText());
		}
		
	}
}
