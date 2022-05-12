package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) {

		//download the driver and setup the path
		String prompttext = "Sunitha";;
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
	
	driver.manage().window().maximize();
	driver.switchTo().frame("iframeResult");
	driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
	
	
	
	
	Alert promptalert = driver.switchTo().alert();
	promptalert.sendKeys(prompttext);
	
	
	promptalert.accept();
	
	WebElement findElement = driver.findElement(By.xpath("//p[@id='demo']"));
	
	String set1=findElement.getText();
	
	if(set1.contains(prompttext))
		System.out.println("Name is Present");
	
	/*
	// To find the matched String by Using List  begins here
	
	String[] strsplit=set1.split(" ");
	
	List<String> arraylist = new ArrayList<String>();
	
	
	arraylist.addAll(Arrays.asList(strsplit));
	

	
	
	
	for(String value:arraylist)
	{

		
		String str1=value.substring(0,value.length()-1);
		String str2=prompttext.substring(0,prompttext.length());
		
	if(str1.equals(str2))
	{
		System.out.println("Name is Present");
		break;
	}
	}
	// To find the matched String by Using List  ends here		
	 
	 */
	}

}


//
//String set1 = driver.findElement(By.xpath("//p[@id='demo']")).getText();

//System.out.println(set1);

//
//promptalert.sendKeys("Sunitha");
//prompttext=promptalert.getText();


//System.out.println("prompttext " + prompttext); 
//promptalert.sendKeys(prompttext);

//System.out.println(arraylist);

//System.out.println(arraylist+" " +value+ " "+prompttext);

