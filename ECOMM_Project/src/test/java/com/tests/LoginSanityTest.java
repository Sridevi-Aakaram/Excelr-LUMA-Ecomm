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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lumaObjects.LoginPage;
/*1) Enter password and click on submit
2) Just click on submit
3) Enter email and click on submit
4) Enter invalid email and password then click on submit
5) Click on createaccount from login page
6) Enter valid email and invalid password then click on submit
7) click on forgot password and check page title*/

public class LoginSanityTest {
	
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
	public void sanityOne() throws InterruptedException
	{
		LoginPage lin= new LoginPage(driver);
		lin.loginwebsite();
		lin.emaillogin(" ");
		lin.passwordlog("roni_cost3@example.com");
		lin.submitbutton();
		Thread.sleep(2000);
		String email = driver.findElement(By.id("email-error")).getText();
		String actualmsg = "This is a required field.";
		if(email.contains(actualmsg))
		{
			System.out.println("The test is pass");
		}
		else
		{
			System.out.println("The test is fail");

		}
	}
	@Test(priority=2)
	public void sanityTwo() throws InterruptedException
	{
		LoginPage lin= new LoginPage(driver);
		lin.loginwebsite();
		lin.emaillogin(" ");
		lin.passwordlog("");
		lin.submitbutton();
		Thread.sleep(2000);
		String email = driver.findElement(By.id("email-error")).getText();
		String actualmsg = "This is a required field.";
		if(email.contains(actualmsg))
		{
			System.out.println("The test is pass");
		}
		else
		{
			System.out.println("The test is fail");

		}
		String password = driver.findElement(By.id("pass-error")).getText();
		String actualpwdmsg = "This is a required field.";
		if(password.contains(actualpwdmsg))
		{
			System.out.println("The test is pass");
		}
		else
		{
			System.out.println("The test is fail");

		}

		
	}
	@Test(priority=3)
	public void SanityThree() throws InterruptedException
	{
			LoginPage lin= new LoginPage(driver);
			lin.loginwebsite();
			lin.emaillogin(" sanity@123.com");
			lin.passwordlog("");
			lin.submitbutton();
			Thread.sleep(2000);
			String password = driver.findElement(By.id("pass-error")).getText();
			String actualpwdmsg = "This is a required field.";
			if(password.contains(actualpwdmsg))
			{
				System.out.println("The test is pass");
			}
			else
			{
				System.out.println("The test is fail");

			}			
		}
	@Test(priority=4)
	public void sanityFour() throws InterruptedException
	{
		LoginPage lin= new LoginPage(driver);
		lin.loginwebsite();
		lin.emaillogin("google123@d.com");
		lin.passwordlog("roni_cost3@example.com");
		lin.submitbutton();
		Thread.sleep(2000);	
		String alertactual = driver.findElement(By.className("messages")).getText();
		System.out.println(alertactual);
		String expectalert = "The account sign-in was incorrect or your account is"
				+ " disabled temporarily. Please wait and try again later.";
		if(alertactual.contains(expectalert))
		{
			System.out.println("The test is pass");
		}
		else
		{
			System.out.println("The test is fail");

		}	
	}
	
	@Test(priority=5)
	public void CreateAccountLogin()
	{
		LoginPage lin= new LoginPage(driver);
		lin.loginwebsite();
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[2]/div[2]/div/div/a")).click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		String expectTitle = "Create New Customer Account";
		if(pageTitle.contains(expectTitle))
		{
			System.out.println("The test is pass");
		}
		else
		{
			System.out.println("The test is fail");

		}	
	}
	@Test(priority=6)
	public void invalidPassword() throws InterruptedException
	{
		LoginPage lin= new LoginPage(driver);
		lin.loginwebsite();
		lin.emaillogin("roni_cost@example.com");
		lin.passwordlog("comm@123");
		lin.submitbutton();
		Thread.sleep(2000);
		String alertactual = driver.findElement(By.className("messages")).getText();
		System.out.println(alertactual);
		String expectalert = "The account sign-in was incorrect or your account is"
				+ " disabled temporarily. Please wait and try again later.";
		if(alertactual.contains(expectalert))
		{
			System.out.println("The test is pass");
		}
		else
		{
			System.out.println("The test is fail");

		}	
	}
	@Test(priority=7)
	public void forgotPassword() throws InterruptedException
	{
		LoginPage lin= new LoginPage(driver);
		lin.loginwebsite();
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[4]/div[2]/a")).click();
		Thread.sleep(2000);
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		String expectTitle = "Forgot Your Password?";
		if(pageTitle.contains(expectTitle))
		{
			System.out.println("The test is pass");
		}
		else
		{
			System.out.println("The test is fail");

		}	
	}
	@AfterTest
	public void BrowserClose()
	{
		driver.close();
	}
	

}
