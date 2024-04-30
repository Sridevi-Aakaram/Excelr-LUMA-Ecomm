package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*
 * Go to cart and remove items
 * Edit the quantity and check the final price of the product */
import com.lumaObjects.CartItemsPage;
import com.lumaObjects.HomePage;
import com.lumaObjects.LoginPage;
import com.lumaObjects.LogoutPage;

public class AddCartTest {
	WebDriver driver;

	@BeforeTest
	public void BasicTest() throws InterruptedException {
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
		LoginPage lp = new LoginPage(driver);
		lp.EntertoLoop();
		Thread.sleep(1000);

	}
	@Test
	public void RemoveCartitems() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.AddTOCArt();
		CartItemsPage cart = new CartItemsPage(driver);
		cart.ECartPage();
		Thread.sleep(1000);
		WebElement deleteButton = driver
				.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody[2]/tr[2]/td/div/a[2]"));
		deleteButton.click();
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test

	public void EditSumofItems() throws InterruptedException {

		CartItemsPage cart = new CartItemsPage(driver);
		cart.ECartPage();
		Thread.sleep(1000);
		WebElement sum = driver.findElement(By.xpath("//input[@step='any']"));
		String actual = driver.findElement(By.className("cart-price")).getText();
		sum.clear();
		sum.sendKeys("4");
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button[2]")).click();
		Thread.sleep(1000);
		String expec = driver.findElement(By.className("cart-price")).getText();
		if (expec.equals(actual)) {
			System.out.println("The test is fail");
		} else {
			System.out.println("The test is pass");
		}
	}
	@AfterTest
	public void ExitBrowser() throws InterruptedException
	{
		LogoutPage lp = new LogoutPage(driver);
				lp.Logout();
		driver.quit();
	}
}

