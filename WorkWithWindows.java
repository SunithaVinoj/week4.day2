package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindows {

	public static void main(String[] args) throws InterruptedException {
		
		List<String> closeWindowsList = new ArrayList<String>();
		
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
//		closeWindowsList.add(windowHandlesList.get(1));
//		System.out.println(windowHandlesList.get(1));
//		
//		
//		chromedriver.close();
//		
		chromedriver.switchTo().window(windowHandlesList.get(0));
		
		 
		
		
		//2.Count no of Multiple Windows
		
		WebElement clickElement = chromedriver.findElement(By.xpath("//button[text()='Open Multiple Windows']"));
		clickElement.click();
		
		Set<String> clickHandles = chromedriver.getWindowHandles();
		List<String> clickHandlesList = new ArrayList<String>(clickHandles);
		
		int count=clickHandles.size();
		System.out.println("No of Opened Windows are : " + (count-1));
		//System.out.println(clickHandlesList.get(3));
//		System.out.println(clickHandlesList.get(0));
//		System.out.println(clickHandlesList.get(1));
//		System.out.println(clickHandlesList.get(2));
//		System.out.println(windowHandlesList.get(0));
//		
		for(int i=1;i<count;i++)
		{
		closeWindowsList.add(clickHandlesList.get(i));
		}
		//closeWindowsList.add(clickHandlesList.get(2));
		
//		System.out.println("Before");
//		System.out.println("0"+closeWindowsList.get(0));
//		System.out.println("1"+closeWindowsList.get(1));
//		//System.out.println("2"+closeWindowsList.get(2));
		
		//chromedriver.switchTo().window(windowHandlesList.get(0));
		
		// Close All Windows except main Window
//		WebElement closeElement = chromedriver.findElement(By.xpath("//button[contains(text(),'Do not close me')]"));
//		closeElement.click();
		chromedriver.switchTo().window(windowHandlesList.get(0));
		
		Thread.sleep(3000);
		
		chromedriver.findElement(By.xpath("//button[contains(text(),'Do not close me')]")).click();
		
		
		
//		System.out.println("count"+closeWindowsList.size());
//		System.out.println("0"+closeWindowsList.get(0));
//		System.out.println("1"+closeWindowsList.get(1));
		//System.out.println("2"+closeWindowsList.get(2));
		//System.out.println("3"+closeWindowsList.get(3));
		
		
		
		for(int j=0;j<closeWindowsList.size()-1;j++)
		{
		chromedriver.switchTo().window(closeWindowsList.get(j));
		//System.out.println(j+closeWindowsList.get(j));
		//Thread.sleep(3000);
		chromedriver.close();
		Thread.sleep(3000);
		}
		
		//chromedriver.quit();
		chromedriver.switchTo().window(windowHandlesList.get(0));
		
		/*chromedriver.switchTo().window(windowHandlesList.get(1));
		
		
		chromedriver.close();
		//chromedriver.switchTo().window(windowHandlesList.get(0));
		
		chromedriver.switchTo().window(clickHandlesList.get(0));
		for(int j=1;j<count;j++)
		{
		chromedriver.switchTo().window(clickHandlesList.get(j));
		//System.out.println("in the loop"+clickHandlesList.get(j));
		
		Thread.sleep(3000);
		
		
		//chromedriver.switchTo().window(clickHandlesList.get(1));
		
		chromedriver.close();
		}
		*/
		
		
//		chromedriver.switchTo().window(clickHandlesList.get(0));
		
//		System.out.println(windowHandlesList.get(0));
//		System.out.println(clickHandlesList.get(0));
//		
		}
		
		
		
		
		
		//http://www.leafground.com/home.html
		
	}

