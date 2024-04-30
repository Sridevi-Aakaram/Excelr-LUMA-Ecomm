package com.lumaObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartItemsPage {
	WebDriver driver;
	public CartItemsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By cartImage = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
	By viewCart = By.linkText("View and Edit Cart");
	public void ECartPage() throws InterruptedException
	{
		driver.navigate().refresh();
		driver.findElement(cartImage).click();
		driver.findElement(viewCart).click();
	}

}
