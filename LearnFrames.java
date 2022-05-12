package week4.day2;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {
	public static void main(String[] args) throws InterruptedException 
	{
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
				driver.manage().window().maximize();
						
			
				
				driver.switchTo().frame("frame1");
			
				
				driver.findElement(By.xpath("//input")).clear();
				
				driver.findElement(By.xpath("//input")).sendKeys("Animals");
				
				driver.switchTo().frame("frame3");
				
				driver.findElement(By.xpath("//input[@id='a']")).click();
			
				driver.switchTo().defaultContent(); 
				
				driver.switchTo().frame("frame2");
				
				driver.findElement(By.xpath("//select[@id='animals']")).sendKeys("Big Baby Cat");
				
				
				
				
				
			}		
				
			
	}
