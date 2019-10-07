package com.atmecs.konakart.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.konakart.constant.Constants;

public class Helper {
	/**
	 * Handling mouse event(Clicks at the current mouse location). 
	 * Navigate to back  page.
	 * To move the window up and down.( Scroll by visible element) 
	 * Wait for some time to load the element and execute at different interval time.
	 * Retrieving the specified elements Text(Get Text). 
	 * Easy to choose or select an option given under any drop downs.
	 * 
	 * @author ranjitha.selvam
	 *
	 * 
	 */

	public static void move(WebDriver driver, String xpath) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		Actions action = new Actions(driver);
		action.moveToElement(findElement).perform();

	}
	

	public static void click(WebDriver driver,String xpath) {
		
			

				 driver.findElement(By.xpath(xpath));

				
				
				

		
		
	}
	
/*
 *  * Navigate to back  page.
 */
	public static void navigate(WebDriver driver) {
		driver.navigate().back();
	}
	
	
	/*
	 * To move the window up and down.( Scroll by visible element) 
	 */

	public static void scroll(WebDriver driver, String xpath) {

		// Create instance of Javascript executor

		JavascriptExecutor je = (JavascriptExecutor) driver;



		//Identify the WebElement which will appear after scrolling down

		WebElement element = driver.findElement(By.xpath(xpath));



		// now execute query which actually will scroll until that element is not appeared on page.

		je.executeScript("arguments[0].scrollIntoView(true);",element);
        element.click();
		
	}
	

	/*
	 *  Wait for some time to load the element and execute at different interval time.
	 */
	public static void explicitWait(WebDriver driver, String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.page_load_timeout);
		WebElement element;
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		element.click();
	}
	

	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Constants.page_load_timeout, TimeUnit.SECONDS);
	}
	
	/*
	 * Retrieving the specified elements Text(Get Text). 
	 */

	public static String getText(WebDriver driver, String xpath) {
		
		String text = driver.findElement(By.xpath(xpath)).getText();
		System.out.println(text);
		return text;

	}
	
	/*
	 * Easy to choose or select an option given under any drop downs.
	 */

	public static void selectByValue(WebDriver driver,String xpath, String values) {
		WebElement selectElement = driver.findElement(By.xpath(xpath));
		Select select = new Select(selectElement);
		select.selectByValue(values);
	}
	

	public static void selectIndex(WebDriver driver,String xpath, int values) {
		WebElement selectElement = driver.findElement(By.xpath(xpath));
		Select select = new Select(selectElement);
		select.selectByIndex(values);
	}
	

	public static void selectVisibleText(WebDriver driver,String xpath, String values) {
		WebElement selectElement = driver.findElement(By.xpath(xpath));
		Select select = new Select(selectElement);
		select.deselectByVisibleText(values);
	}
	
	/*
	 * pass the inputs.
	
     */
	public static void sendValues(WebDriver driver,String xpath,String values)
	
	{
      WebElement findElement = driver.findElement(By.xpath(xpath));
      findElement.sendKeys(values);
      findElement.click();
    }
	

}
