import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	  public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", "F:\\Studies\\Java\\eclipse\\ChromeDriver.exe");
		  WebDriver driver; 
		  String baseUrl="https://www.centennialcollege.ca/";
		  
		  driver = new ChromeDriver();	
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  
		  //launch url
		  driver.get(baseUrl);
		  
		  //search textbox
		  WebElement textbox = driver.findElement(By.xpath("//*[@id='txtSearch']"));
		  textbox.sendKeys("software");
		  driver.findElement(By.xpath("//*[@id=\'btnSearch\']")).click();
		  
		  //clickon the link
		  driver.findElement(By.xpath("//*[@id=\'___gcse_0\']/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div/a")).click();

		  //close previous tab
		  ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
			driver.close();
			driver.switchTo().window(tabs.get(1));
		  
		  //Scroll 	  
		  JavascriptExecutor je = (JavascriptExecutor) driver;
		  WebElement element = driver.findElement(By.xpath("//div[@id='mock-tbody']/div/div[3]/section"));	  
		  je.executeScript("arguments[0].scrollIntoView(true);",element);
		  
		  //get text from element
		  System.out.println("Status of International Availability");
		  System.out.println(driver.findElement(By.xpath("//div[@id='mock-tbody']/div/div[3]/section")).getText());
		 
	  }
}
