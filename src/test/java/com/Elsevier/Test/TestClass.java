package com.Elsevier.Test;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Elsevier.PageClasses.AddToCartPage;
import com.Elsevier.PageClasses.HomePage;
import com.Elsevier.PageClasses.LoginPage;
import com.Elsevier.PageClasses.ShoppingCartPage;

public class TestClass extends BaseClass {

	HomePage homePage;
	AddToCartPage addToCart;
	ShoppingCartPage ShoppingCart;
	LoginPage loginPage;
	String txtCartItemPrice;
	String txtShippingPrice;

	@BeforeClass
	public void Init() {
		homePage = new HomePage(driver);
		addToCart = new AddToCartPage(driver);
		ShoppingCart = new ShoppingCartPage(driver);
		loginPage = new LoginPage(driver);
	}

	@Test
	public void Test_001_toVerifyHomePageTitleisDisplayed() {
		assertEquals(homePage.getTitlePage(), "My Store");
	}

	@Test
	public void Test_002_toVerifySearchSummerItemisDisplayedandItemisSelected() {
		String searchHeadingString;

		homePage.SearchForItem("summer");
		searchHeadingString = homePage.verifySummerItemSearchResult();
		assertEquals(searchHeadingString, "\"SUMMER\"");
		BaseClass.timeDelay();

		homePage.MovetoItemToClick();
		homePage.SelectTheItem();
	}

	@Test
	public void Test_003_toVerifyPriceofItemisDisplayedCorrectly() {
		assertEquals(homePage.verifyItemPriceResult(), "$28.98");
	}

	@Test
	public void Test_004_toVerifyAddtocartTitleisDisplayed() {
		String itemSelectTileString;
		itemSelectTileString = addToCart.getCurrentTitlePage();
		assertEquals(itemSelectTileString, "Printed Summer Dress - My Store");
	}

	@Test
	public void Test_005_toVerifySearchItemHeadingisDisplayed() {
		assertEquals(addToCart.getCurrentItemSearchHeading(), "Printed Summer Dress");
	}

	@Test
	public void Test_006_toVerifyAddtocartPriceItemisdisplayed() {

		assertEquals(addToCart.getPriceItem(), "$28.98");
	}

	@Test
	public void Test_007_toAddtoCartandVerifytheProductPriceintheCart() {
		addToCart.clickAddtoCart();
		txtCartItemPrice = addToCart.getproductPrice();
		assertEquals(addToCart.getproductPrice(), "$28.98");
	}

	@Test
	public void Test_008_toVerifytheProductAddedConfirmMessage() {
		String confirmMessageString;
		confirmMessageString = addToCart.getProductAddedConfirmMessage();
		assertEquals(confirmMessageString, "Product successfully added to your shopping cart");

	}

	@Test
	public void Test_009_toVerifytheNoOfItemInTheCartMessage() {
		assertEquals(addToCart.getNoOfItemIntheCartMessage(), "There is 1 item in your cart.");

	}

	@Test
	public void Test_010_toVerifytheShippingPriceintheCart() {
		txtShippingPrice = addToCart.getshippingPrice();
		assertEquals(addToCart.getshippingPrice(), "$2.00");

	}

	@Test
	public void Test_011_toVerifytheTotalPriceintheCart() {
		assertEquals(addToCart.getTotalPrice(), "$30.98");

	}

	@Test
	public void Test_012_toVerifytheSelectedItemIsAddedCart() {

		addToCart.clickToProceedButton();
		BaseClass.timeDelay();

	}

	@Test
	public void Test_013_toVerifyShoppingCartTitleisDisplayed() {
		assertEquals(ShoppingCart.getTitle(), "Order - My Store");
	}

	@Test
	public void Test_014_toVerifyShoppingCartHeadingisDisplayed() {
		assertEquals(ShoppingCart.getHeadingText(), "SHOPPING-CART SUMMARY");

	}

	@Test
	public void Test_015_toVerifyShoppingCartContainsNumberOfItemisDisplayed() {
		assertEquals(ShoppingCart.getShoppingCartText(), "Your shopping cart contains: 1 Product");

	}

	@Test
	public void Test_016_toVerifyShoppingCartContainsNumberOfItemisDisplayed() {
		String ShoppingItemText;
		ShoppingItemText = ShoppingCart.getShoppingItemDescription();
		assertEquals(ShoppingItemText, "Printed Summer Dress");

	}

	@Test
	public void Test_017_toVerifyShoppingCartTotalProductItemPrice() {
		String ShoppingTotalProductPriceText;
		ShoppingTotalProductPriceText = ShoppingCart.getShoppingTotalProductItemPrice();
		assertEquals(ShoppingTotalProductPriceText, txtCartItemPrice);

	}

	@Test
	public void Test_018_toVerifyShoppingCartTotalShippingPrice() {
		String ShoppingTotalShippingPriceText;
		ShoppingTotalShippingPriceText = ShoppingCart.getShoppingItemShippingPrice();
		assertEquals(ShoppingTotalShippingPriceText, txtShippingPrice);

	}

	@Test
	public void Test_019_toVerifyShoppingCartTotalPrice() {
		String ShoppingTotalPriceText;
		ShoppingTotalPriceText = ShoppingCart.getShoppingTotalPrice();
		assertEquals(ShoppingTotalPriceText, addToCart.getTotalPrice());

	}

	@Test
	public void Test_020_toVerifyNavigateToSignInPageandTitleisDisplayed() {
		String titePage;
		ShoppingCart.clickToProceedToCheckOut();
		BaseClass.timeDelay();
		titePage = loginPage.getCurrentTitlePage();
		assertEquals(titePage, "Login - My Store");

	}

	@Test
	public void Test_021_toVerifySignInPageheadingisDisplayed() {
		assertEquals(loginPage.getLoginPageHeading(), "AUTHENTICATION");

	}

	@Test
	public void Test_022_toVerifyCreateLoginheadingisDisplayed() {
		assertEquals(loginPage.getCreateLoginHeading(), "CREATE AN ACCOUNT");

	}

	@Test
	public void Test_023_toVerifyAlreadyRegisterPageheadingisDisplayed() {
		assertEquals(loginPage.getAlreadyRegHeading(), "ALREADY REGISTERED?");

	}

}
