package com.lumaObjects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;

public class CreateAccountPage {
	
	WebDriver driver;
	public CreateAccountPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By newAccount = By.xpath("//div[@class='panel header']/ul/li[3]");
	By firstname = By.xpath("//input[@id='firstname']");
	By lastname = By.xpath("//input[@id='lastname']");
	By email = By.id("email_address");
	By pwd = By.id("password");
	By confirmpwd = By.id("password-confirmation");
	By submit = By.xpath("//button[@title='Create an Account']");
	
	public void NewAccout()
	{
		driver.findElement(newAccount).click();
	}
	public void Fname(String fname)
	{
		WebElement usernameElement = driver.findElement(firstname);
        usernameElement.clear();
        usernameElement.sendKeys(fname);
	}
	public void Lname(String lname)
	{
		driver.findElement(lastname).sendKeys(lname);
	}
	public void GMail(String mailID)
	{
		driver.findElement(email).sendKeys(mailID);
	}
	public void PAssword(String pass)
	{
		driver.findElement(pwd).sendKeys(pass);
		driver.findElement(confirmpwd).sendKeys(pass);
	}
	public void Register()
	{

		driver.findElement(submit).click();
	}
	

}
