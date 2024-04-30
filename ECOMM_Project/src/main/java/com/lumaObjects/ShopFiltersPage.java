package com.lumaObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopFiltersPage {
	
	WebDriver driver;
	public ShopFiltersPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By Catogory = By.id("layered-filter-block");
	By subcat = By.xpath("//div[@role='presentation']");
	By NewYoga = By.xpath("//div[@class='blocks-promo']/a/span");
	By Performance = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[1]/div/a[4]/span/span[2]");
	JavascriptExecutor js = (JavascriptExecutor)driver;
	By submitbtn = By.xpath("//button[@type='submit']");
	By listitems = By.className("product-item-link");
	public void CatogoryCollection() throws InterruptedException
	{
		driver.findElement(NewYoga).click();
		String yoga = driver.getTitle();
		System.out.println(yoga);			
		
		
		
	}
		
}

