package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownAssignment1 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//implicit wait to wait for 30sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//launch url
		driver.get("http://leaftaps.com/opentaps");
		
		//enter username and password using id locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//click on login button using class locator
		driver.findElement(By.className("decorativeSubmit")).click();
				
		//click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
				
		//click on leads button
		driver.findElement(By.linkText("Leads")).click();
		
		//click on create lead button
		driver.findElement(By.linkText("Create Lead")).click();
				
		//enter companyname using id locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Name");
				
		//enter firstname using id locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("First");
				
		//enter lastname using id locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Last");
		
		//select the element of source dropdown using send keys
		driver.findElement(By.id("createLeadForm_dataSourceId")).sendKeys("Employee");
		
		//select the element of marketing dropdown using visible text
		WebElement marketingdropdown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select marketing = new Select(marketingdropdown);
		marketing.selectByVisibleText("Car and Driver");
		
		//select the element of preferred currency dropdown using index
		WebElement preferredcurrencydropdown = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select currency = new Select(preferredcurrencydropdown);
		currency.selectByIndex(1);
		
		//select all values of industry dropdown 
		WebElement industrydropdown = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select industry = new Select(industrydropdown);
		List<WebElement> options = industry.getOptions();
		for(WebElement eachoption : options) {
			System.out.println(eachoption.getText());
		}
		industry.selectByValue("IND_SOFTWARE");
		
		//select last value of ownership dropdown 
		WebElement ownershipdropdown = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select ownership = new Select(ownershipdropdown);
		List<WebElement> options1 = ownership.getOptions();
		ownership.selectByIndex(options1.size()-1);
		
		//select country from dropdown
		driver.findElement(By.id("createLeadForm_generalCountryGeoId")).sendKeys("India");
		
		//select state from dropdown
		WebElement statedropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select state = new Select(statedropdown);
		state.selectByVisibleText("KERALA");
		
		//click on create lead button
		driver.findElement(By.className("smallSubmit")).click();
		
		//close the browser
		driver.close();
		
		



		


		




		

		

		
		
		
		
	}

}
