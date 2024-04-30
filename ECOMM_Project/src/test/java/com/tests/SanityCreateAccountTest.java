package com.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lumaObjects.CreateAccountPage;
import com.lumaObjects.LogoutPage;
import com.google.common.io.Files;

/*
1) Click on page create 
2) Dont enter first and enter all valid details
3) Enter same credentials and click on submit
4) Enter all details and keep password as null
5) Enter all details and keep email as null
6) Enter passord less then 8 charectors
7) Enter registerd firstname, lastname and different emailID
8) If account created logout from the page

*/
public class SanityCreateAccountTest {
	WebDriver driver;

	@BeforeTest
	public void OPenBrowser() {
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
		// driver.findElement(By.xpath("//div[@class='panel
		// header']/ul/li[3]")).click();
	}

	@Test(priority = 1)
	public void NewAccountCreate() {
		driver.findElement(By.xpath("//div[@class='panel header']/ul/li[3]")).click();
	}

	@Test(priority = 2)
	public void NameFirst() {
		CreateAccountPage ca = new CreateAccountPage(driver);
		ca.NewAccout();
		ca.Fname(" ");
		ca.Lname("Missy");
		ca.GMail("sissgipsy@sy.com");
		ca.PAssword("Gipsy@123");
		ca.Register();
		String txt = driver.findElement(By.id("firstname-error")).getText();
		System.out.println(txt);
		String actualtxt = "This is a required field";
		if (txt.contains(actualtxt)) {
			System.out.println("The test is pass");
		} else {
			System.out.println("The test is fail");
		}

	}

	@Test(priority = 3)
	public void DuplicateAccount() {
		CreateAccountPage ca = new CreateAccountPage(driver);
		ca.NewAccout();
		ca.Fname("Sissy");
		ca.Lname("Missy");
		ca.GMail("sissmiss@sy.com");
		ca.PAssword("Gipsy@123");
		ca.Register();
		String txt = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		String expectxt = "There is already an account with this email address. If you are sure "
				+ "that it is your email address, click here to get your password and access your account";
		if (txt.contains(expectxt)) {
			System.out.println("The test is pass");
		} else {
			System.out.println("The test is fail");
		}
	}

	@Test(priority = 4)
	public void ForgotPassword() {
		CreateAccountPage ca = new CreateAccountPage(driver);
		ca.NewAccout();
		ca.Fname("Sissy");
		ca.Lname("Missy");
		ca.GMail("sissmiss@sy.com");
		ca.PAssword("");
		ca.Register();
		String txt = driver.findElement(By.id("password-error")).getText();
		String expectxt = "This is a required field.";
		if (txt.contains(expectxt)) {
			System.out.println("The test is pass");
		} else {
			System.out.println("The test is fail");
		}
	}

	@Test(priority = 5)
	public void Forgotemail() {
		CreateAccountPage ca = new CreateAccountPage(driver);
		ca.NewAccout();
		ca.Fname("Sissy");
		ca.Lname("Missy");
		ca.GMail("");
		ca.PAssword("Gipsy@123");
		ca.Register();
		String txt = driver.findElement(By.id("email_address-error")).getText();
		String expectxt = "This is a required field.";
		if (txt.contains(expectxt)) {
			System.out.println("The test is pass");
		} else {
			System.out.println("The test is fail");
		}
	}

	@Test(priority = 6)
	public void Weakpassword() {
		CreateAccountPage ca = new CreateAccountPage(driver);
		ca.NewAccout();
		ca.Fname("Sissy");
		ca.Lname("Missy");
		ca.GMail("sissmiss@sy.com");
		ca.PAssword("Gipsy");
		ca.Register();
		String txt = driver.findElement(By.id("password-error")).getText();
		String expectxt = "Minimum length of this field must be equal or greater than 8 symbols. "
				+ "Leading and trailing spaces will be ignored.";
		if (txt.contains(expectxt)) {
			System.out.println("The test is pass");
		} else {
			System.out.println("The test is fail");
		}
	}

	@Test(priority = 7)
	public void ExistedNames() throws IOException {
		CreateAccountPage ca = new CreateAccountPage(driver);
		ca.NewAccout();
		ca.Fname("Sissy");
		ca.Lname("Missy");
		ca.GMail("jitsyussmitysy@tipsy.com");
		ca.PAssword("Gipsy@123");
		ca.Register();
		String element = driver.getTitle();
		System.out.println(element);
		String actualtitle = "Customer Login";
		if (element.contains(actualtitle)) {
			System.out.println("The test is pass");
		} else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			File f = ((TakesScreenshot) js).getScreenshotAs(OutputType.FILE);
			Files.copy(f, new File("/Volumes/Learnings/Selinium/Excelr/jewel.jpeg"));
			System.out.println("The test is fail");
		}
	}

	

	@AfterTest
	public void FailTestScreenShot() {

		driver.quit();
	}

}
