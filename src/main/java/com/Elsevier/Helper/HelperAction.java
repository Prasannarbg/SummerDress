package com.Elsevier.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HelperAction {

	WebDriver driver;
	Actions action;
	
	public HelperAction(WebDriver _driver) {
		this.driver = _driver;	
		action = new Actions(driver);
	}
	
	public void moveToElement(WebElement element) {
		action.moveToElement(element).build().perform();
		
	}
	 
	
	
}
