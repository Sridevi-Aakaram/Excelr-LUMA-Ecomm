package com.lumaObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		By listitems = By.className("product-item-link");
	}
	By listitems = By.className("product-item-link");
	By addtoCart = By.xpath("//button[@title='Add to Cart']");

	public void OPenBrowser()
	{
		this.driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");

	}
	public void AddTOCArt() throws InterruptedException
	{
		WebElement product = driver.findElement(By.className("columns"));
			String pagetitle = driver.getTitle();
			System.out.println(pagetitle);	
			List<WebElement>  productslist = driver.findElements(listitems);
			
			for(int i = 0; i<productslist.size(); i++)
			{
				try {
				String productsname = productslist.get(i).getText();
				System.out.println(productsname);
				if(productsname.equals("Argus All-Weather Tank"))
				{
					driver.findElement(By.linkText("Argus All-Weather Tank")).click();
				}}catch(Exception e)
				{
					System.out.println(e.getMessage());

				}			
		}
		}
	public void AddtoCartdirect() throws InterruptedException
	{
		WebElement product = driver.findElement(By.className("columns"));
			String pagetitle = driver.getTitle();
			System.out.println(pagetitle);	
			List<WebElement>  productslist = driver.findElements(listitems);
			for(int i = 0; i<productslist.size(); i++)
			{
				try {
				String productsname = productslist.get(i).getText();
				System.out.println(productsname);
				
				if(productsname.equals("Hero Hoodie"));
				{
					WebElement hover = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[3]/div/div/ol/li[4]/div/a/span/span/img"));
					Actions ac = new Actions(driver);
					ac.moveToElement(hover);
					ac.build().perform();
					driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[3]/div/div/ol/li[4]/div/div/div[3]/div/div[1]/form/button")).click();
					
				}
				}catch(Exception e)
				{
					System.out.println(e);

				}
			}
	}
}
	
