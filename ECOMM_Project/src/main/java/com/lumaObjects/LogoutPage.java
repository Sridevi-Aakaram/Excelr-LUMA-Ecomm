package com.lumaObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	WebDriver driver;
	public LogoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void Logout() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='panel header']/ul/li[2]/span")).click();
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")).click();
		Thread.sleep(2000);
	}

}
