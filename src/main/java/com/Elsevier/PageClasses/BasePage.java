package com.Elsevier.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

public class BasePage {

	WebDriver driver;
	
	public BasePage(WebDriver _driver) {
		
		this.driver = _driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
}
