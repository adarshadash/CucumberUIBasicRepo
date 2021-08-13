package Cucumber.Automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	public static WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/Cucumber/Automation/global.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/abu/Downloads/chromedriver 4");
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resource/chromedriver 4");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/abu/Downloads/geckodriver");
			driver = new FirefoxDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//driver.get(prop.getProperty("url"));
		return driver;

	}

	// Open url

	public static void website_url_launch() {
		driver.get(prop.getProperty("url"));
	}

	// Click

	public static void click_element_with_id(String identifier) {
		driver.findElement(By.id(identifier)).click();
	}

	public static void click_element_withh_xpath(String identifier) {
		driver.findElement(By.xpath(identifier)).click();
	}

	public static void click_element_with_cssSelector(String identifier) {
		driver.findElement(By.cssSelector(identifier)).click();
	}

	public static void click_element_with_className(String identifier) {
		driver.findElement(By.className(identifier)).click();
	}

	public static void click_element_with_linkText(String linkText) {
		driver.findElement(By.linkText(linkText)).click();
	}

	public static void click_element_with_name(String name) {
		driver.findElement(By.name(name)).click();
	}

	public static void click_element_with_tagName(String name) {
		driver.findElement(By.tagName(name)).click();
	}

	public static void click_element_with_partialLinkText(String partialLinkText) {
		driver.findElement(By.partialLinkText(partialLinkText)).click();
	}

	// Clear

	public static void clear_element_with_id(String identifier) {
		driver.findElement(By.id(identifier)).clear();
	}

	public static void clear_element_withh_xpath(String identifier) {
		driver.findElement(By.xpath(identifier)).clear();
	}

	public static void clear_element_with_cssSelector(String identifier) {
		driver.findElement(By.cssSelector(identifier)).clear();
	}

	public static void clear_element_with_className(String identifier) {
		driver.findElement(By.className(identifier)).clear();
	}

	public static void clear_element_with_name(String name) {
		driver.findElement(By.name(name)).clear();
	}

	public static void clear_element_with_tagName(String name) {
		driver.findElement(By.tagName(name)).clear();
	}

	// Enter text

	public static void enter_text_with_id(String text, String identifier) {
		driver.findElement(By.id(identifier)).sendKeys(text);
	}

	public static void enter_text_with_xpath(String text, String identifier) {
		driver.findElement(By.xpath(identifier)).sendKeys(text);
	}

	public static void enter_text_with_cssSelector(String text, String identifier) {
		driver.findElement(By.cssSelector(identifier)).sendKeys(text);
	}

	public static void enter_text_with_className(String identifier, String text) {
		driver.findElement(By.className(identifier)).sendKeys(text);
	}

	public static void enter_text_with_name(String text, String name) {
		driver.findElement(By.name(name)).sendKeys(text);
	}

	public static void enter_text_with_tagName(String text, String name) {
		driver.findElement(By.tagName(name)).sendKeys(text);

	}

	// Verify using element

	public static void verify_element_with_id(String identifier) {
        driver.findElement(By.id(identifier)).isDisplayed();

	}

	public static void verify_element_with_xpath(String identifier) {
		driver.findElement(By.xpath(identifier)).isDisplayed();
	}

	public static void verify_element_with_cssSelector(String identifier) {
		driver.findElement(By.cssSelector(identifier)).isDisplayed();
	}

	public static void verify_element_with_linkText(String linkText) {
		driver.findElement(By.linkText(linkText)).isDisplayed();
	}

	public static void verify_text_with_name(String name) {
		driver.findElement(By.name(name)).isDisplayed();
	}

	// verify using text of elements
	public static void verify_text_of_element_with_xpath(String text, String xpath) {
		String actualString = driver.findElement(By.xpath(xpath)).getText();
		String expectedString = text;
	    assertEquals(actualString, expectedString);
	}

	public static void verify_text_of_element_with_css(String text, String css) {
		String actualString = driver.findElement(By.cssSelector(css)).getText();
		String expectedString = text;
	     assertEquals(actualString, expectedString);
	}

	public static void verify_text_of_element_with__id(String text, String id) {
		String actualString = driver.findElement(By.id(id)).getText();
		String expectedString = text;
		assertEquals(actualString, expectedString);
	
	}
	// Wait for the element present
	public static void wait_until_element_present_xpath(String identfier) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(identfier)));
	}

	public static void wait_until_element_present_id(String identfier) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(identfier)));
	}

	public static void wait_until_element_present_cssSelector(String identfier) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(identfier)));
	}

	// wait_until_text_of_element_present

        public static void wait_until_text_of_element_present_id(String text, String id) {
		WebElement element = driver.findElement(By.id(id));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public static void wait_until_text_of_element_present_css(String text, String css) {
		WebElement element = driver.findElement(By.cssSelector(css));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public static void wait_until_text_of_element_present_xpath(String text, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public static void click_element_with_id_newtab(String identifier) {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// Click on link to open in new tab
		driver.findElement(By.id(identifier)).click();
		// Switch newly open Tab
		driver.switchTo().window(tabs.get(1));
	}

	public static void click_element_with_xpath_newtab(String identifier) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.findElement(By.xpath(identifier)).click();
		driver.switchTo().window(tabs.get(1));
	}

	public static void click_element_with_cssSelector_newtab(String identifier) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.findElement(By.cssSelector(identifier)).click();
		driver.switchTo().window(tabs.get(1));
	}

	public static void switch_nexttab() {
		Actions action = new Actions(driver);
		// Switch to Second Tab
		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
	}

	public static void switch_previoustab() {
		Actions action = new Actions(driver);
		// Switch to First Tab
		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();

	}

	public static void browser_back() {
		driver.navigate().back();
	}

	public static void close_browser() {
		driver.close();
	}

}
