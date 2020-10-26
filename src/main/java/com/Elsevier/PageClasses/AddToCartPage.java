package com.Elsevier.PageClasses;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Elsevier.Helper.HelperAction;

public class AddToCartPage extends BasePage {

	WebDriver driver;
	HelperAction HelperAction;

	// WebElement Region

	@FindBy(xpath = "//h1[@itemprop='name']")
	WebElement textSearchItemHeadingElement;

	@FindBy(xpath = "(//span[@itemprop='price'])[1]")
	WebElement textItemPriceElement;

	@FindBy(id = "add_to_cart")
	WebElement btnAddtoCartElement;

	@FindBy(xpath = "(//span[contains(.,'$')])[6]")
	WebElement enableHiddenElement;

	@FindBy(xpath = "(//span[contains(.,'$')])[6]")
	WebElement productPrice;

	@FindBy(xpath = "(//span[contains(.,'$')])[7]")
	WebElement shippingCost;

	@FindBy(xpath = "(//span[contains(.,'$')])[8]")
	WebElement totalPrice;

	@FindBy(xpath = "//h2[contains(.,'P')]")
	WebElement txtProductSuccesfullMessage;

	@FindBy(xpath = "//h2[contains(.,'T')]")
	WebElement txtnoOfItemsInTheCart;

	/*
	 * @FindBy(xpath = "(//div[@id='layer_cart']//following::div/span)[6]")
	 * WebElement productPrice;
	 * 
	 * @FindBy(xpath = "(//div[@id='layer_cart']//following::div/span)[7]")
	 * WebElement shippingCost;
	 * 
	 * @FindBy(xpath = "(//div[@id='layer_cart']//following::div/span)[8]")
	 * WebElement totalPrice;
	 * 
	 * @FindBy(xpath = "(//div[@id='layer_cart']//following-sibling::h2)[1]")
	 * WebElement txtProductSuccesfullMessage;
	 * 
	 * @FindBy(xpath = "(//div[@id='layer_cart']//following-sibling::h2)[2]")
	 * WebElement txtnoOfItemsInTheCart;
	 */

	@FindBy(linkText = "Proceed to checkout")
	WebElement btnproceedToCheckOut;

	public AddToCartPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
	}

	// Action Method Region

	public String getCurrentTitlePage() {

		return driver.getTitle();
	}

	public String getCurrentItemSearchHeading() {

		return textSearchItemHeadingElement.getText();
	}

	public String getPriceItem() {

		return textItemPriceElement.getText();
	}

	public void clickAddtoCart() {

		btnAddtoCartElement.click();

	}

	public String getproductPrice() {

		return productPrice.getText();
	}

	public String getshippingPrice() {

		return shippingCost.getText();
	}

	public String getTotalPrice() {

		return totalPrice.getText();
	}

	public String getProductAddedConfirmMessage() {

		return txtProductSuccesfullMessage.getText();
	}

	public String getNoOfItemIntheCartMessage() {

		return txtnoOfItemsInTheCart.getText();
	}

	// Navigation method Region
	
	public ShoppingCartPage clickToProceedButton() {

		btnproceedToCheckOut.click();
		return new ShoppingCartPage(driver);
	}

}
