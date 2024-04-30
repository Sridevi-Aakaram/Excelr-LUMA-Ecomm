package com.lumaObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By signIN = By.xpath("//div[@class='panel header']/ul/li[2]");
	By emaillog = By.name("login[username]");
	By pwdlog = By.name("login[password]");
	By showpwd = By.name("//input[@type='checkbox']");
	By submitlog = By.xpath("//*[@id=\"send2\"]");
	
	public void loginwebsite()
	{
		driver.findElement(signIN).click();
	}
	public void emaillogin(String mail)
	{
		driver.findElement(emaillog).sendKeys(mail);
	}
	public void passwordlog(String pass)
	{
		driver.findElement(pwdlog).sendKeys(pass);
	}
	public void submitbutton()
	{
		driver.findElement(submitlog).click();
	}
	public void EntertoLoop()
	{
		driver.findElement(signIN).click();
		driver.findElement(emaillog).sendKeys("sissymissy@sis.com");
		driver.findElement(pwdlog).sendKeys("goole@123");
		driver.findElement(submitlog).click();
	}

}
