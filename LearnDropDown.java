package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDropDown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver chromedriver = new ChromeDriver();
		
		chromedriver.get("http://www.leafground.com/pages/Dropdown.html");
		
		chromedriver.manage().window().maximize();
		chromedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//chromedriver.findElement(By.xpath("//select[@id='dropdown1']"));
		
		//dropdown by using Index
		
		WebElement drpDwn1 = chromedriver.findElement(By.id("dropdown1"));
		
		Select select1 = new Select(drpDwn1);
		
		select1.selectByIndex(1);
		
		//dropdown by using Text
		
		WebElement drpDwn2 = chromedriver.findElement(By.name("dropdown2"));
		
		Select select2 = new Select(drpDwn2);
		
		select2.selectByVisibleText("Selenium");
		
		//dropdown by using Value
		
		WebElement drpDwn3 = chromedriver.findElement(By.id("dropdown3"));
		
		Select select3 = new Select(drpDwn3);
		
		select3.selectByValue("1");
		
		
		
		WebElement drpDwn4 = chromedriver.findElement(By.className("dropdown"));
		
		Select select4 = new Select(drpDwn4);
		
		List<WebElement> options = select4.getOptions();
		
		System.out.println("Total no of Options : " + (options.size()-1));
		
		
		//options.add(0, String.valueOf(options.size()-1));
		
		
		//dropdown by using sendKeys
		
		chromedriver.findElement(By.xpath("//section[@class='innerblock']//div[5]//select")).sendKeys("Selenium");
		
		//dropdown by using multiple selection
		
		WebElement drpDwn5 = chromedriver.findElement(By.xpath("//section[@class='innerblock']//div[6]//select"));
		
		Select select5 = new Select(drpDwn5);
		
		if(select5.isMultiple())
		{
			for(int i=1;i<options.size();i++)
			{
			select5.selectByIndex(i);
			//select5.selectByIndex(2);
		}
			
		
			
		
	
		
		
		
		}	
		
		
		
		
	}

}
