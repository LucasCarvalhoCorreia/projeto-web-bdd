package br.com.rsinet.hub_bdd.testes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the Firefox driver
		 
        driver = new ChromeDriver();
 
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
        //Launch the Online Store Website
 
        driver.manage().window().maximize();
        driver.get("http://www.store.demoqa.com");
 
        // Find the element that's ID attribute is 'account'(My Account)
        
        driver.findElement(By.linkText("Dismiss")).click();
 
        driver.findElement(By.linkText("My Account")).click();
 
        // Find the element that's ID attribute is 'log' (Username)
 
        // Enter Username on the element found by above desc.
 
        driver.findElement(By.id("username")).sendKeys("lucas"); 
 
        // Find the element that's ID attribute is 'pwd' (Password)
 
        // Enter Password on the element found by the above desc.
 
        driver.findElement(By.id("password")).sendKeys("10203040Lcc@?");
 
        // Now submit the form. WebDriver will find the form for us from the element 
 
        driver.findElement(By.name("login")).click();
 
        // Print a Log In message to the screen
 
        System.out.println("Login Successfully");
 
        // Find the element that's ID attribute is 'account_logout' (Log Out)
 
        driver.findElement (By.linkText("Logout")).click();
 
        // Print a Log In message to the screen
 
        System.out.println("LogOut Successfully");
 
        // Close the driver
 
        driver.quit();
 
 }
 
}
