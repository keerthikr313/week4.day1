package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicit wait to wait for 30sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//launch url
		driver.get("https://www.chittorgarh.com/");
		
		//click on stock market
		driver.findElement(By.id("navbtn_stockmarket")).click();
		
		//click on NSE bulk deals
		driver.findElement(By.linkText("NSE Bulk Deals")).click();
		
		//get all security names
		List<WebElement> findElements = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//th"));
		List<String> securityNames = new ArrayList<String>();
		int count = findElements.size();
		System.out.println(count);
		for(int i=1; i<=count; i++) {
			String text = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr["+i+"]//th[1]")).getText();
			System.out.println("securityNames" +text);
			System.out.println("securityNames");
			Set<String> set = new LinkedHashSet<String>();
			if(set.size()<findElements.size()) {
				System.out.println("The elements are" +set);
			}
			driver.close();
		}



		
		
	}

}
