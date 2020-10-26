package com.Elsevier.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	String URL = "http://automationpractice.com/index.php";

	@BeforeSuite
	public void setUP() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	}

	@AfterSuite
	public void TearDown() {

		driver.close();
	}

	public static void timeDelay() {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

}
