package week4.day2;


import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WindowHandles {
	public static void main(String[] args) {
		
	

	
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.get("http://www.leafground.com/pages/Window.html");

	
	 driver.findElement(By.id("home")).click();
	 String windowHandle = driver.getWindowHandle();
	 System.out.println(windowHandle);   
	 System.out.println("--------------------------------------------------");                  
	 
	 Set<String> windowHandles = driver.getWindowHandles();         
	 System.out.println(windowHandles);                  
	 List<String> windowHandlesList = new ArrayList<String>(windowHandles);         
	 String newWindowHandle = windowHandlesList.get(1);         
	 System.out.println("First Window --------------------------");         
	 System.out.println(driver.getCurrentUrl());         
	 System.out.println(driver.getTitle());         
	 System.out.println("Second Window------------------------------------");         
	 driver.switchTo().window(newWindowHandle);                  
	 System.out.println(driver.getCurrentUrl());         
	 System.out.println(driver.getTitle());         
	 System.out.println("First Window----------------------------------------");         
	 driver.switchTo().window(windowHandlesList.get(0));                           
	 System.out.println(driver.getCurrentUrl());         
	 System.out.println(driver.getTitle()); 
	 
	 driver.quit();
	 


		      // Switch the context from webpage to frame
	 //        WebElement frameElement = driver.findElement(By.className("demo-frame"));
	 /*driver.switchTo().frame(5);                  
	 driver.findElement(By.xpath("//li[text()='Item 1']")).click();                  
	 driver.switchTo().defaultContent();                  
	 driver.findElement(By.linkText("Download")).click();  */                         

}
	
}

