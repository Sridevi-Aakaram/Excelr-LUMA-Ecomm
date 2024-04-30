package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*
1) Enter valid email and password then click on submit button. The page should redirect to Home page
*/
import com.lumaObjects.LoginPage;
import com.lumaObjects.LogoutPage;

public class LoginTest {
	
	WebDriver driver;
	@BeforeTest
	public void HomePagetest()
	{
		this.driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
		
	}
	@Test(priority=1)
	public void ActualLogin() throws InterruptedException
	{
		LoginPage lin= new LoginPage(driver);
		lin.loginwebsite();
		lin.emaillogin("sissymissy@sis.com");
		lin.passwordlog("goole@123");
		lin.submitbutton();
		Thread.sleep(2000);
		
		String element = driver.getTitle();
		System.out.println(element);
		String actualtitle = "Shopping Cart";
		if(element.contains(actualtitle))
		{
			System.out.println("The test is pass");
		}
		else
		{
			System.out.println("The test is fail");

		}
		
	}
	@AfterTest
	public void BrowserClose() throws InterruptedException
	{
		LogoutPage lp = new LogoutPage(driver);
		lp.Logout();
		driver.close();
		
	}
}

