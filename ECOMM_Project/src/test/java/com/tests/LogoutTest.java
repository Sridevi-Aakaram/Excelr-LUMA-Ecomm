package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lumaObjects.LoginPage;
import com.lumaObjects.LogoutPage;
/*
 * Log out from the website*/
public class LogoutTest {
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
	@Test
	public void logout() throws InterruptedException
	{
		LogoutPage  lop = new LogoutPage(driver);
		lop.Logout();
	}
	@AfterTest
	public void Quit()
	{
		driver.quit();
	}

}
