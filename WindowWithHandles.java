package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WindowWithHandles {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver chromedriver = new ChromeDriver();
		chromedriver.get("http://www.leafground.com/pages/Window.html");
		chromedriver.manage().window().maximize();
		chromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//1.Open Home page 
		chromedriver.findElement(By.id("home")).click();
		
		Set<String> windowHandles = chromedriver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		
		Thread.sleep(3000);
		chromedriver.switchTo().window(windowHandlesList.get(1));
		chromedriver.close();
		
		chromedriver.switchTo().window(windowHandlesList.get(0));
		
		 
		
		
		//2.Count no of Multiple Windows
		
		WebElement clickElement = chromedriver.findElement(By.xpath("//button[text()='Open Multiple Windows']"));
		clickElement.click();
		
		Set<String> clickHandles = chromedriver.getWindowHandles();
		List<String> clickHandlesList = new ArrayList<String>(clickHandles);
		
		int count=clickHandles.size();
		System.out.println("No of Opened Windows are : " + (count-1));
		chromedriver.switchTo().window(clickHandlesList.get(1));
		
		chromedriver.close();
		
		chromedriver.switchTo().window(clickHandlesList.get(2));
		
		chromedriver.close();
		
		
		chromedriver.switchTo().window(windowHandlesList.get(0));
		
		//3.// Close All Windows except main Window
		
		Thread.sleep(3000);
		
		chromedriver.findElement(By.xpath("//button[contains(text(),'Do not close me')]")).click();
		
		Set<String> closeHandles = chromedriver.getWindowHandles();
		List<String> closeWindowsList = new ArrayList<String>(closeHandles);
		
		chromedriver.switchTo().window(closeWindowsList.get(1));
		
		chromedriver.close();
		
		chromedriver.switchTo().window(closeWindowsList.get(2));
		
		chromedriver.close();		
		
		chromedriver.switchTo().window(windowHandlesList.get(0));
		
		//4. wait for 2 new windows to open
		
		
		Thread.sleep(5000);
		
		chromedriver.findElement(By.xpath("//button[contains(text(),'Wait for 5 seconds')]")).click();
		
			
	}




}
