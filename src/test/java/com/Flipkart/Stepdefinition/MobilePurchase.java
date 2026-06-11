package com.Flipkart.Stepdefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MobilePurchase {
	static WebDriver driver;
	@Given("User launch the browser")
	public void user_launch_the_browser() {
	    driver= new ChromeDriver();
	    System.out.println("Lauching");
	}

	@Given("User login into flipkart")
	public void user_login_into_flipkart() {
	    driver.get("https://www.flipkart.com/");
	    try {
	    	    WebElement closeIcon = driver.findElement(By.xpath("//button[text()='X']"));
	    	    closeIcon.isDisplayed();
	    	    closeIcon.click();
	    }
	    catch(Exception e){
	    	   System.out.println("Login not required");
	    }
	    System.out.println("Logged into Fliplart");
	}

	@When("User search for mobile")
	public void user_search_for_mobile() {
		WebElement search = driver.findElement(By.name("q"));
	    search.sendKeys("samsung",Keys.ENTER);
	    System.out.println("Searched for Samsung");
	    WebElement prod = driver.findElement(By.xpath("(//div[contains(text(),'Samsung')])[2]"));
	    prod.click();
	}

	@When("User handling the window")
	public void user_handling_the_window() {
	   System.out.println("Window Handling");
	}

	@Then("User validate the product")
	public void user_validate_the_product() {
		System.out.println("Validation");  
	}
	
	@When("User search for mobile with one dim list")
	public void user_search_for_mobile_with_one_dim_list(io.cucumber.datatable.DataTable dataTable) {
		List<String> asList =dataTable.asList();
		WebElement search = driver.findElement(By.name("q"));
	    search.sendKeys(asList.get(0),Keys.ENTER);
	    System.out.println("Searched for Samsung");
	    WebElement prod = driver.findElement(By.xpath("(//div[contains(text(),'"+asList.get(0)+"')])[2]"));
	    prod.click();
	}
	@When("User search for mobile with one dim Map")
	public void user_search_for_mobile_with_one_dim_map(io.cucumber.datatable.DataTable dataTable) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    Map<String, String> asMap =dataTable.asMap();
	    WebElement search = driver.findElement(By.name("q"));
	    search.sendKeys(asMap.get("Phone1"),Keys.ENTER);
	    System.out.println("Searched for Mobiles");
	    WebElement prod = driver.findElement(By.xpath("(//div[contains(text(),'"+asMap.get("Phone1")+"')])[2]"));
	    prod.click();
	}
	@When("Use search All Mobiles {string}")
	public void use_search_all_mobiles(String Names) {
	
	    WebElement search = driver.findElement(By.name("q"));
	    search.sendKeys(Names,Keys.ENTER);
	    WebElement prod = driver.findElement(By.xpath("(//div[contains(text(),'"+Names+"')])[2]"));
	    prod.click();
	    System.out.println("Searched for All Mobles");
	}


}
