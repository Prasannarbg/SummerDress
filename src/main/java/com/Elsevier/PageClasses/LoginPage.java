package com.Elsevier.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Elsevier.Helper.HelperAction;

public class LoginPage extends BasePage {

	WebDriver driver;
	HelperAction HelperAction;

	public LoginPage(WebDriver _driver) {
		super(_driver);
		this.driver = _driver;

	}

	// WebElement Region

	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement txtloginPageHeading;

	@FindBy(xpath = "(//h3[@class='page-subheading'])[1]")
	WebElement txtloginCreateLoginHeading;

	@FindBy(xpath = "(//h3[@class='page-subheading'])[2]")
	WebElement txtloginAlreadyRegisteredHeading;

	public String getCurrentTitlePage() {
		return driver.getTitle();
	}

	public String getLoginPageHeading() {
		return txtloginPageHeading.getText();
	}

	public String getCreateLoginHeading() {
		return txtloginCreateLoginHeading.getText();
	}

	public String getAlreadyRegHeading() {
		return txtloginAlreadyRegisteredHeading.getText();
	}

}
