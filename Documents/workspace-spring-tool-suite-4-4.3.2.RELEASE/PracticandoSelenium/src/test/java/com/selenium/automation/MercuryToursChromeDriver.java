package com.selenium.automation;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryToursChromeDriver {

	private WebDriver driver;
	By passwordRegister = By.name("password");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/newtours/");
		Thread.sleep(1000);
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void registerUser() throws InterruptedException {
		//fail("Not yet implemented");
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(2000); //Temporizador (si y no recomendado). El Thread agrego el "throws InterruptedException" (add Throws declaration)
		
		//isDisplayed devuelve un Booleano
		if (driver.findElement(By.xpath("//img[@src='images/mast_register.gif']")).isDisplayed()) {
			driver.findElement(By.id("email")).sendKeys("AxelYataco");
			driver.findElement(passwordRegister).sendKeys("12345");
			driver.findElement(By.name("confirmPassword")).sendKeys("12345");
			// driver.findElement(By.cssSelector("input[name='confirmPassword']")).sendKeys("12345"); Este es CssSelector
			driver.findElement(By.name("submit")).click();
		} else {
			System.out.print("Register pages was not found");
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		assertEquals("Note: Your user name is AxelYataco.", fonts.get(5).getText());
	}
	
	@Test
	public void signIn() throws InterruptedException {
		if (driver.findElement(By.name("userName")).isDisplayed()) {
			driver.findElement(By.name("userName")).sendKeys("AxelYataco");
			driver.findElement(By.name("password")).sendKeys("12345");
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			Thread.sleep(2000);
		} else {
			System.out.print("Username TextBox was not present");
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		//assertEquals("Login Successfully", htres.get(1).getText()); Mal
		assertEquals("Thank you for Loggin.", fonts.get(3).getText());
	}
}
