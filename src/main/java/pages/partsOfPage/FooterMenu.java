package pages.partsOfPage;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.BasePage;
import utils.PropertiesFile;

public class FooterMenu extends BasePage {

	public FooterMenu() {
		driver.get(PropertiesFile.readPropertiesFile("URL"));
		PageFactory.initElements(driver, this);
	}

	// Разделы

	@FindBy(css = "div:nth-of-type(1) > .footer__list > li:nth-of-type(1)")
	private WebElement autoWithMiles;

	@FindBy(css = "div:nth-of-type(1) > .footer__list > li:nth-of-type(2)")
	private WebElement newCars;

	@FindBy(css = "div:nth-of-type(1) > .footer__list > li:nth-of-type(3)")
	private WebElement motorCycles;

	@FindBy(css = "div:nth-of-type(1) > .footer__list > li:nth-of-type(4)")
	private WebElement trucks;

	@FindBy(css = "div:nth-of-type(1) > .footer__list > li:nth-of-type(5)")
	private WebElement buses;

	// Social Media

	@FindBy(css = "div:nth-of-type(3) > ul:nth-of-type(2) > li:nth-of-type(1)")
	private WebElement youtube;

	@FindBy(css = "div:nth-of-type(3) > ul:nth-of-type(2) > li:nth-of-type(1) > .footer__link > img")
	private WebElement youtubeIcon;

	@FindBy(css = "div:nth-of-type(3) > ul:nth-of-type(2) > li:nth-of-type(2)")
	private WebElement instagram;

	@FindBy(css = "div:nth-of-type(3) > ul:nth-of-type(2) > li:nth-of-type(3)")
	private WebElement telegram;

	// Блоки

	@FindBy(css = ".footer__app-links > li:nth-of-type(1)")
	private WebElement androidBlock;
	
	// Keys for Map
	
	public static String AutiWithMiles = "Авто с пробегом";
	public static String NewCars = "Новые авто";
	public static String YouTubeIcon = "ЮтубИконка";
	public static String YouTube = "Ютуб";
	public static String AndroidBlock = "АндроидБлок";

	public Map<String, Object> getActualAttributes() {
		
		Map<String, Object> attributes = new HashMap<String, Object>();
		
		attributes.put(AutiWithMiles, getAutoWithMiles());
		attributes.put(NewCars, getNewCars());
		attributes.put(YouTubeIcon, validateYoutueIcon());
		attributes.put(YouTube, getYoutube());
		attributes.put(AndroidBlock, validateAndroidBlock());
		
		return attributes;

	}

	public String getAutoWithMiles() {
		return autoWithMiles.getText();
	}

	public String getNewCars(){
		return newCars.getText();
	}

	public boolean validateYoutueIcon() {
		return youtubeIcon.isDisplayed();
	}

	public String getYoutube(){
		return youtube.getText();
	}

	public boolean validateAndroidBlock() {
		return androidBlock.isDisplayed();
	}

}
