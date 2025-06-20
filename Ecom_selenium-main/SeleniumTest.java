package com.test;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) {
		 //Set path to your ChromeDriver
		WebDriver driver = new ChromeDriver();
		 //Open Flipkart
		driver.get("https://www.flipkart.com");
		//Maximize the browser window 
		driver.manage().window().maximize();
		 //Find the search box using 'name' attribute
		WebElement searchBox=driver.findElement(By.name("q"));
		searchBox.sendKeys("iphone 15 pro max");
		//Submit the search form
		searchBox.submit();
		
		String mainPage = driver.getWindowHandle();
		System.out.println("Main page="+ mainPage);
		//Click on a specific product
		driver.findElement(By.xpath("//div[normalize-space()='Apple iPhone 15 Pro Max (Blue Titanium, 256 GB)']")).click();
		
		Set<String> allPages=driver.getWindowHandles();
		//Switch to new opened tab
		for(String page : allPages) {
			if(!page.equals(mainPage)) {
				driver.switchTo().window(page);
				break;
			}
		}
		//Print the current page url
		System.out.println(driver.getCurrentUrl());
		List<WebElement> products= driver.findElements(By.className("_21Ahn-"));
		System.out.println(products.size());
		for(WebElement product: products) {
			System.out.println(product.getText());
		}
		//Click on the Add to cart button
		driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
	}

}
