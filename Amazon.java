package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		String oldPrice;
		WebDriverManager.chromedriver().setup();
		ChromeDriver chromeDriver = new ChromeDriver();
		
		//1.Load the URL https://www.amazon.in/
		chromeDriver.get("https://www.amazon.in/");
		chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
	/*		
			
			
			9.close the browser*/
			
		//	2.search as oneplus 9 pro
		chromeDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		
		Thread.sleep(3000);
		
		chromeDriver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		Thread.sleep(3000);
		
	//	3.Get the price of the first product
		
		WebElement priceElement = chromeDriver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		System.out.println(priceElement.getText());
		
		oldPrice=priceElement.getText();
		
		
		//4. Print the number of customer ratings for the first displayed product
		
		
		WebElement RatingElement = chromeDriver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
		
		System.out.println(" No.Of Customer Rating is : " + RatingElement.getText());
		
		
		//5. Click the first text link of the first image
		chromeDriver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		
		Set<String> clickHandles = chromeDriver.getWindowHandles();
		List<String> clickHandlesList = new ArrayList<String>(clickHandles);
		
		chromeDriver.switchTo().window(clickHandlesList.get(1));
		
		
		//6. Take a screen shot of the product displayed
		
		File sourceImage = chromeDriver.getScreenshotAs(OutputType.FILE);
		File destImage = new File("./snaps/IMG001.png");
		FileUtils.copyFile(sourceImage, destImage);
		
		System.out.println("Snap shot saved");
		//7. Click 'Add to Cart' button
		
	
		chromeDriver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		
		
		
		//8. Get the cart subtotal and verify if it is correct.
		Thread.sleep(3000);
		String cartAmt =chromeDriver.findElement(By.xpath("//span[contains(@class,'a-size-base-plus a-color-price a-text-bold')]/span")).getText();
		
		System.out.println("Cart Amount: " +cartAmt);
		
		
		//System.out.println("oldprice" + oldPrice +"cartAmt" +cartAmt);
		
		//cartAmt=cartAmt.replace('?', ' ');
		
		//System.out.println("After oldprice" + oldPrice +"cartAmt" +cartAmt);
		
		if (cartAmt.contains(oldPrice))
		{
			System.out.println(" Amount is verified");
		}
		else
			System.out.println(" Amount is not verified");
//		
////		
//		
	} 
	

}



//chromeDriver.switchTo().window(clickHandlesList.get(1));
//System.out.println(chromeDriver.getWindowHandle());
//
//	WebElement cartAmt =chromeDriver.findElement(By.id("attach-accessory-cart-subtotal"));
//System.out.println("art" +cartAmt);
//String cartAmt=chromeDriver.findElement(By.xpath("//html/body/div[4]/div[3]/div[3]/div/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/span[2]/span")).getText();

//*[@id="attach-accessory-cart-subtotal"]

//String cartAmt =chromeDriver.findElement(By.xpath("//span[contains(@id,'attach-accessory-cart-subtotal')]")).getText();

