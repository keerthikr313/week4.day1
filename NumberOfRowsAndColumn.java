package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NumberOfRowsAndColumn {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicit wait to wait for 30sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//launch url
		driver.get("https://html.com/tags/table/");
		
		int count = driver.findElements(By.xpath("(//table)")).size();
		System.out.println("The number of tables is "+count);
		for(int i=1;i<=count;i++) {
			int row = driver.findElements(By.xpath("(//table)["+i+"]//tr")).size();
			System.out.println("The number of row is "+row);
			int column = driver.findElements(By.xpath("(//table)["+i+"]//th")).size();
			System.out.println("The number of column is "+column);



		}
		driver.close();

	}
}
