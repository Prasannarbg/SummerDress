package com.Elsevier.PageClasses;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.Elsevier.Helper.HelperAction;

public class HomePage extends BasePage {

	WebDriver driver;
	HelperAction HelperAction;

	// WebElement Region

	@FindBy(id = "search_query_top")
	WebElement editSearchElement;

	@FindBy(xpath = "//span[@class='lighter']")
	WebElement textSearchMessage;

	@FindBy(xpath = "(//span[@itemprop='price'])[1]")
	WebElement textItemPriceMessage;

	@FindBy(xpath = "(//span[@class='availability'])[1]")
	WebElement imageSelectTheItemElement;

	@FindBy(xpath = "//div[@id='center_column']//following-sibling::img[position()=1]")
	WebElement imageSelectDressItemElement;

	public HomePage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;
		HelperAction = new HelperAction(driver);
	}

	WebElement actionElement;

	// Action Methods Region

	public String getTitlePage() {

		return driver.getTitle();
	}

	public void SearchForItem(String item) {

		editSearchElement.sendKeys(item);
		editSearchElement.sendKeys(Keys.ENTER);
	}

	public String verifySummerItemSearchResult() {

		return getWebElementText(textSearchMessage);
	}

	private String getWebElementText(WebElement ele) {

		return ele.getText();
	}

	public String verifyItemPriceResult() {

		return textItemPriceMessage.getText();
	}

	public void MovetoItemToClick() {

		HelperAction.moveToElement(imageSelectTheItemElement);

	}

	// Navigation Methods

	public AddToCartPage SelectTheItem() {

		imageSelectDressItemElement.click();
		return new AddToCartPage(driver);

	}

}
