package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Library {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicit wait to wait for 30sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//launch url
		driver.get("https://html.com/tags/table/");
		
		List<WebElement> Rows = driver.findElements(By.xpath("(//table)[1]//tr"));
		int rowcount =Rows.size();
		System.out.println(rowcount);
		System.out.println(Rows.get(0).getText());
		System.out.println(Rows.get(1).getText());
		driver.close();

		


	}

}
