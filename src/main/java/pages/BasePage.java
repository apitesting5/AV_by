package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class BasePage {

	protected static WebDriver driver;
	Actions action = new Actions(driver);

	public static void setDriver(WebDriver webdriver) {

		driver = webdriver;

	}
}
