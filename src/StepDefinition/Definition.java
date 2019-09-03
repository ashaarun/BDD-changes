package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Definition {
	
	
	WebDriver driver;
	
	@Given("^login application should be launched$")
	public void login_application_should_be_launched() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\AshaArun\\Documents\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		 driver=new FirefoxDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.manage().window().maximize();
	}
		
	@When("^Test login with valid credentials$")
	public void test_login_with_valid_credentials() throws Throwable {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
		Thread.sleep(3000);
	}
	    
	
	
	@Then("^login should be success$")
	public void login_should_be_success() throws Throwable {
	
		String exptitle="OrangeHRM";
		String acttitle=driver.getTitle();
		Assert.assertEquals(exptitle, acttitle);
		driver.close();
}
}