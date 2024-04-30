package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lumaObjects.CreateAccountPage;
/*
1)Click on CreateAccount from account page and verify the page title
2) Create an acount using valid credentials
3) Enter same registered email ID and create the account
4) Dont enter the first name or lastname and click on submit Button
*/
public class RegisterAccountTest {
	WebDriver driver;
	@BeforeTest
	public void OPenBrowser()
	{
		this.driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
		//driver.findElement(By.xpath("//div[@class='panel header']/ul/li[3]")).click();
	}
	@Test(priority=1)
	public void NewAccountCreate()
	{
		driver.findElement(By.xpath("//div[@class='panel header']/ul/li[3]")).click();
	}
	@Test(priority=2)
	public void NewAccountDetails() throws InterruptedException
	{
		CreateAccountPage ca = new CreateAccountPage(driver);
		ca.NewAccout();
		ca.Fname("Sissy");
		ca.Lname("Missy");
		ca.GMail("sissymissy@sis.com");
		ca.PAssword("goole@123");
		ca.Register();
	}
	@Test(priority=3)
	public void NameFirst()
	{
		CreateAccountPage ca = new CreateAccountPage(driver);
		ca.NewAccout();
		ca.Fname(" ");
		ca.Lname("Missy");
		ca.GMail("sissgipsy@sy.com");
		ca.PAssword("Gipsy@123");
		ca.Register();
		String txt = driver.findElement(By.id("firstname-error")).getText();
		String actualtxt = "This is a required field";
		if(txt.equals(actualtxt))
		{
			System.out.println("The test is pass");
		}
		else {
			System.out.println("The test is fail");
		}
		
	}
	@Test(priority=4)
	public void DuplicateAccount()
	{
			CreateAccountPage ca = new CreateAccountPage(driver);
			ca.NewAccout();
			ca.Fname("Sissy");
			ca.Lname("Missy");
			ca.GMail("sissmiss@sy.com");
			ca.PAssword("Gipsy@123");
			ca.Register();
			String txt= driver.findElement(By.xpath("//div[@role='alert']")).getText();
			String expectxt = "There is already an account with this email address. If you are sure "
					+ "that it is your email address, click here to get your password and access your account";					
			if(txt.equals(expectxt))
			{
				System.out.println("The test is pass");
			}
			else {
				System.out.println("The test is fail");
			}
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}

}
