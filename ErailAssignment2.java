package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailAssignment2 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicit wait to wait for 30sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//launch url
		driver.get("https://erail.in/");
		
		//clear the text box and enter MDU
		Thread.sleep(1000);
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MDU",Keys.TAB);
		
		//clear the text box and enter TPJ
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("TPJ",Keys.TAB);
		
		//unselect the sort on date
		driver.findElement(By.id("chkSelectDateOnly")).click();
		Thread.sleep(1000);
		
		//to get all the train names and train numbers
		List<String> trainid = new ArrayList<String>();
		List<String> trainname = new ArrayList<String>();
		List<WebElement> rows = (List<WebElement>) driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		for(int i=1; i<rows.size(); i++) {
			String Trainid1 = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]//td[1]")).getText();
			trainid.add(Trainid1);
			String Trainname1 = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]//td[2]")).getText();
			trainname.add(Trainname1);
		}
		
		//output values
		System.out.println(trainid);
		System.out.println(trainname);
		
		//close browser
		driver.close();

	}

}
