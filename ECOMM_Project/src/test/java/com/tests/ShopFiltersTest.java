package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lumaObjects.ShopFiltersPage;
import com.lumaObjects.LoginPage;
import com.lumaObjects.LogoutPage;
/*
 * Click on New Luma Yoga Collection 
 * Click on any shop filters and select the range */
public class ShopFiltersTest {
	WebDriver driver;
	@BeforeTest
	public void BasicTest()
	{
		this.driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
	}
	@Test(priority=1)
	public void ShopCatologs() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.EntertoLoop();
		ShopFiltersPage ap = new ShopFiltersPage(driver);
		ap.CatogoryCollection();
	        
	        WebElement sizeFilterTitle = driver.findElement(By.xpath("//*[@id='narrow-by-list']/div[5]"));
	        sizeFilterTitle.click();

	        WebElement MSizeOption= driver.findElement(By.cssSelector("div.swatch-option.text[option-label='29']"));
	        MSizeOption.click();
	        
	        WebElement priceFilter= driver.findElement(By.xpath("//div[@class='filter-options-title'][text()='Price']"));
	        priceFilter.click();
	        
	        WebElement priceselect= driver.findElement(By.xpath("//div[@class='filter-options-content']//a[contains(@href, 'price=20-30')]"));
	        priceselect.click();
	        System.out.println("Price Range Selected: " + priceselect);
	}
	
	
	@AfterTest
	public void ExitBrowser() throws InterruptedException
	{
		LogoutPage lp = new LogoutPage(driver);
		lp.Logout();
		driver.close();
	}
		
	}
	


