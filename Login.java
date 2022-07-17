package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//Login
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Check login success
		WebElement logout = driver.findElement(By.className("decorativeSubmit"));
		String attribute = logout.getAttribute("value");
		if(attribute.equals("Logout"))
			System.out.println("Login Sucess!!");
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		
		//Create Lead
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Indium Software");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Dhanabalan");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Karnan");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Dhana");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QA");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is a test description.");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test@gmail.com");
		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateDropdown=new Select(state);  //dropdown access by Select class
		stateDropdown.selectByVisibleText("New York");
		WebElement Source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select selectDropdownOption = new Select(Source);
		selectDropdownOption.selectByVisibleText("Cold Call");
		driver.findElement(By.className("smallSubmit")).click();
		//String text = driver.findElement(By.tagName("title")).getText();
		String title = driver.getTitle();
		System.out.println(title);
		//if(title.contains("View Lead | opentaps CRM"))
		//{
			//System.out.println("view lead details displayed");
		//}
		
		//Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Company");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Senthil");
		driver.findElement(By.className("smallSubmit")).click();
		String LeadPageTitle = driver.getTitle();
		System.out.println(LeadPageTitle);
		
		
		
		
		
	}

}
