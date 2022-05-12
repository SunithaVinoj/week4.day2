package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("(//form[@name= 'MergePartyForm']//a//img)[1]")).click();
		
		
		Set<String> windowHandles= driver.getWindowHandles();
		System.out.println(windowHandles);
		
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		
		String oldWindowHandle = windowHandlesList.get(0);
		String newWindowHandle = windowHandlesList.get(1);
		System.out.println("1-------------------------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("Parent Window" + oldWindowHandle);
		
		driver.switchTo().window(newWindowHandle);
		
		System.out.println("2-------------------------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("ChildWindow"+newWindowHandle);
		
		List<WebElement> findElements = driver.findElements(By.xpath("//a[@class='linktext']"));
		findElements.get(0).click();
		
		driver.switchTo().window(oldWindowHandle);
		
		// To Merge List
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("(//table[@class= 'twoColumnForm']//tbody//tr[2]//td[2]//a//img)")).click();
		
		
		
		Set<String> towindowHandles= driver.getWindowHandles();
		System.out.println(towindowHandles);
		
		List<String> towindowHandlesList = new ArrayList<String>(towindowHandles);
		
		String tooldWindowHandle = towindowHandlesList.get(0);
		String tonewWindowHandle = towindowHandlesList.get(1);
		System.out.println("1-------------------------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("Parent Window to " + tooldWindowHandle);
		
		driver.switchTo().window(tonewWindowHandle);
		
		System.out.println("2-------------------------------------------------");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		System.out.println("to ChildWindow "+newWindowHandle);
		
		List<WebElement> tofindElements = driver.findElements(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a[@class='linktext']"));
		tofindElements.get(1).click();
		
		//driver.quit();
		
		driver.switchTo().window(tooldWindowHandle);
		driver.findElement(By.xpath("(//table[@class= 'twoColumnForm']//tbody//tr[4]//td[2]//a)")).click();

		//Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title=driver.getTitle();
		System.out.println(" Title is " + title);
		
		if(title.equals("View Contact | opentaps CRM"))
				{
					System.out.println(" Title is verified");
				}
		
		
		
		
		
		
		
	}

}
