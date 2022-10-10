package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.PropertiesFile;

public class MainPage extends BasePage {
	
	public MainPage() {
		driver.get(PropertiesFile.readPropertiesFile("URL"));
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".nav__personal  .nav__link > .nav__link-text")
	private WebElement toSignInBtnLocator;
	
	@FindBy(css = ".drawer__view > div:nth-of-type(1) .tablist > button:nth-of-type(2)")
	private WebElement switchToLogInWithMail;
	
	@FindBy(css = "input#authLogin")
	private WebElement userTextBox;
	
	@FindBy(css = "input#loginPassword")
	private WebElement passwordTextBox;
	
	@FindBy(css = ".button.button--action")
	private WebElement logInBtnLocator;
	
	@FindBy(css = ".button.button--action")
	private WebElement validateLogInSuccess;
	
	@FindBy(css = ".nav__item.nav__item--dropdown.nav__item--user > .nav__link > .nav__link-icon")
	private WebElement logoProfile;
	
	@FindBy(css = ".nav__dropdown-logout")
	private WebElement logOutBtnLocator;
	
	@FindBy(tagName = "a")
	private List<WebElement>links;
	
	public MainPage logInOperation(String email, String password) throws InterruptedException {
		
		toSignInBtnLocator.click();
		switchToLogInWithMail.click();
		userTextBox.sendKeys(email);
		passwordTextBox.sendKeys(password);
		Thread.sleep(1000);
		validateLogInSuccess.click();
		
		return this;
	}
	
	public MainPage logOutOperation() {
		
		action.moveToElement(logoProfile).build().perform();
		logOutBtnLocator.click();
		
		return this;
	}
	
	public boolean isVisibleProfileLogo() {
		return logoProfile.isDisplayed();
	}
	
	
	public List<WebElement> getAllLinks(){
		return links;
	}
	
	
	
	
	
	

}
