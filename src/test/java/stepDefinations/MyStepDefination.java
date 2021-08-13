package stepDefinations;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Cucumber.Automation.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class MyStepDefination extends Base {
	public WebDriver driver;

	@Given("^User is on Greencart Landing page$")
	public void user_is_on_greencart_landing_page() throws Throwable {
		driver = initializeDriver();

	}

	@When("^User searched for (.+) Vegetable$")
	public void user_searched_for_something_vegetable(String strArg1) throws Throwable {

		// //tagname[@attribute='value']
		driver.findElement(By.cssSelector("input.search-keyword")).click();
		driver.findElement(By.cssSelector("input.search-keyword")).sendKeys(strArg1);
		Thread.sleep(3000);

	}

	@Then("^\"([^\"]*)\" results are displayed$")
	public void something_results_are_displayed(String strArg1) throws Throwable {
		Assert.assertTrue(driver.findElement(By.cssSelector("h4.product-name")).getText().contains(strArg1));
	}


	@And("^Added items to cart$")
	public void added_items_to_cart() throws Throwable {
		driver.findElement(By.cssSelector("a.increment")).click();
		driver.findElement(By.xpath("//button[contains(text(),'ADD TO CART')]")).click();
	}

	@And("^User proceeded to Checkout page for purchase$")
	public void user_proceeded_to_checkout_page_for_purchase() throws Throwable {
		driver.findElement(By.xpath("//a[@class='cart-icon']//img[contains(@class,'')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

	}

	@Then("^verify selected (.+) items are displayed in Check out page$")
	public void verify_selected_items_are_displayed_in_check_out_page(String name) throws Throwable {
		Assert.assertTrue(driver.findElement(By.cssSelector("li.cart-item")).getText().contains(name));
	}

	
	
	
	
	
	
	
	
	
	
	
	@Given("^I launch the browser$")
	public void i_launch_the_browser() throws Throwable {
		driver = initializeDriver();
	}

	@Then("^I print the url$")
	public void i_print_the_url() throws Throwable {
		Base.website_url_launch();
	}

	@When("^element with identifier \"([^\"]*)\" is asserted$")
	public void element_with_identifier_something_is_asserted(String strArg1) throws Throwable {
		Base.verify_element_with_id(strArg1);
	}

	@Then("^element with identifier \"([^\"]*)\" is clicked$")
	public void element_with_identifier_something_is_clicked(String strArg1) throws Throwable {
		Base.click_element_with_id(strArg1);
	}

	@And("^text \"([^\"]*)\" is entered in the identifier \"([^\"]*)\"$")
	public void text_something_is_entered_in_the_identifier_something(String strArg1, String strArg2) throws Throwable {
		Base.enter_text_with_id(strArg1, strArg2);
	}

	@When("^wait for element with identifier \"([^\"]*)\" to be present$")
	public void wait_for_element_with_identifier_something_to_be_present(String strArg1) throws Throwable {
		Base.wait_until_element_present_id(strArg1);
	}

	@When("^wait for the text \"([^\"]*)\" with identifier \"([^\"]*)\" to be present$")
	public void wait_for_the_text_something_with_identifier_something_to_be_present(String strArg1, String strArg2)
			throws Throwable {
		Base.wait_until_text_of_element_present_id(strArg1, strArg2);

	}

	@When("^I assist text \"([^\"]*)\" with identifier \"([^\"]*)\"$")
	public void i_assist_text_with_identifier(String arg1, String arg2) throws Throwable {
		Base.verify_text_of_element_with__id(arg1, arg2);
	}

}
