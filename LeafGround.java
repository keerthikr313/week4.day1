package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicit wait to wait for 30sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//launch url
		driver.get("http://www.leafground.com/pages/table.html");
		
		//find table
		WebElement element = driver.findElement(By.xpath("(//table)"));
		
		//count of rows
		int row = element.findElements(By.xpath("(//tr)")).size();
		System.out.println("Row size is " + row);
		
		//count of column
		int column = element.findElements(By.xpath("(//th)")).size();
		System.out.println("Column size is " + column);
		
		//get the value of learn to interact with elements
		String text = driver.findElement(By.xpath("//table//tr[@class='even']")).getText();
		System.out.println("Progress value " + text);
		
		//Check the vital task for the least completed progress
		WebElement checkbox = driver.findElement(By.xpath("//input[@name='vital'])[5]"));
		checkbox.click();
		if(checkbox.isSelected()) {
			System.out.println("Checkbox is checked"); }
			else {
				System.out.println("Checkbox is not checked"); 
			}
		driver.close();

		}

		
	}

