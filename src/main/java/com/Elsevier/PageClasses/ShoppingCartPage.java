package com.Elsevier.PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Elsevier.Helper.HelperAction;

public class ShoppingCartPage extends BasePage {

	WebDriver driver;
	HelperAction HelperAction;
	
	public ShoppingCartPage(WebDriver _driver) {
		super(_driver);
		this.driver=_driver;
		
	}
	
	//WebElement Region
	
	@FindBy(id = "cart_title")
	WebElement txtshopingPageHeadingElement;
	
	@FindBy(linkText = "Printed Summer Dress")
	WebElement txtItemDescriptionElement;
	
	@FindBy(id = "total_product")
	WebElement txtshopingtotalproductElement;
	 
	@FindBy(id = "total_shipping")
	WebElement txtshopingtotalshippingElement;
	
	@FindBy(id = "total_price")
	WebElement txtshopingtotalpriceElement;
	
	@FindBy(linkText = "Proceed to checkout")
	WebElement btnProceedToCheckOut;
	
	
	// Action method Region
	
	public String getTitle() {
		
	return 	driver.getTitle();
	}
	
	public String getHeadingText() {
		
	return 	txtshopingPageHeadingElement.getText().substring(0, 21);
	}
	
	public String getShoppingCartText() {
		
		return 	txtshopingPageHeadingElement.getText().substring(22);
	}
		
	 
	public String getShoppingItemDescription() {
		
		return 	txtItemDescriptionElement.getText();
	}
	
	
	public String getShoppingTotalProductItemPrice() {
		
		return 	txtshopingtotalproductElement.getText();
	}
	
	public String getShoppingItemShippingPrice() {
		
		return 	txtshopingtotalshippingElement.getText();
	}

	public String getShoppingTotalPrice() {
	
	return 	txtshopingtotalpriceElement.getText();
}
	 
	
	// Navigation Region
	
	public LoginPage clickToProceedToCheckOut() {
		
	  	btnProceedToCheckOut.click();
	  	return new LoginPage(driver);
}

}
