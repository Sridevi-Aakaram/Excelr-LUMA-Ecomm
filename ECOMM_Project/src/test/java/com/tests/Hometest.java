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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lumaObjects.ShopFiltersPage;
import com.lumaObjects.HomePage;
import com.lumaObjects.LoginPage;
/*
 * Click on item frompage and add to cart with specifications
 * click on ADDTOCART without specifications
 * click on ADDTOCART by hover on the image*/
import com.lumaObjects.LogoutPage;

public class Hometest {
	
	WebDriver driver;
	@BeforeTest
	public void BasicTest()
	{
		this.driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
		LoginPage lp = new LoginPage(driver);
		lp.EntertoLoop();
	}
	@Test(priority=1)
	public void ClickonItem() throws InterruptedException
	{
			
			HomePage hp= new HomePage(driver);
			hp.AddTOCArt();
			String title = driver.getTitle();
			String s = "Argus All-Weather Tank";
			if(s.equals(title))
			{
				System.out.println("the test is passed");
			}
			else
			{
				System.out.println("the test is fail");
			}
			
	}
	@Test(priority=2)
	public void itemWithoutSpecifications() throws InterruptedException
	{
		
		HomePage hp= new HomePage(driver);
		hp.AddTOCArt();
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		String errmsg = driver.findElement(By.id("super_attribute[143]-error")).getText();
		String actualmsg = "This is a required field.";
		if(errmsg.contains(actualmsg))
		{
			System.out.println("The test is pass");
		}
		else
		{
			System.out.println("The test is fail");

		}
		}
	@Test(priority=3)
	public void FinalitemtoCart() throws InterruptedException
	{
		
		HomePage hp= new HomePage(driver);
		hp.AddTOCArt();
		List<WebElement> clothsize = driver.findElements(By.xpath("//div[@role='option']"));
		for(int i = 0; i<clothsize.size();i++)
		{
			String productsize = clothsize.get(i).getText();
			System.out.println(productsize);
			if(productsize.equals("XS"))
			{
				

				driver.findElement(By.xpath("//div[@aria-describedby='option-label-size-143']")).click();
			}

		}
		
		driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-52\"]")).click();
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();	
		}
	@Test(priority=4)
	public void addcart() throws InterruptedException
	{
		driver.navigate().back();
		HomePage Homep= new HomePage(driver);
		Homep.AddtoCartdirect();
		Thread.sleep(1000);
		String alert = "You need to choose options for your item.";
		String msg = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		if(msg.equals(alert))
		{
			System.out.println("The test is pass");
		}
		else
		{
			System.out.println("The test is fail");

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




