package tests;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import dataClasses.FooterData;
import pages.MainPage;
import pages.partsOfPage.FooterMenu;
import utils.CheckBrokenLinks;
import utils.PropertiesFile;

public class Tests1 extends BaseTest {

	@Test
	public void successLogInTest() throws InterruptedException {

		MainPage mainPage = new MainPage();
		mainPage.logInOperation(PropertiesFile.readPropertiesFile("email"),
				PropertiesFile.readPropertiesFile("password"));

		Assert.assertTrue(mainPage.isVisibleProfileLogo());

		mainPage.logOutOperation();

	}

	@Test
	public void checkFooterPosotionsWithClasses() {

		FooterMenu footerMenu = new FooterMenu();

		FooterData expectedData = new FooterData("Авто с пробегом", "Новые авто", true, "YouTube", true);
		FooterData actualData = new FooterData(footerMenu.getAutoWithMiles(), footerMenu.getNewCars(),
				footerMenu.validateYoutueIcon(), footerMenu.getYoutube(), footerMenu.validateAndroidBlock());

		Assert.assertTrue(EqualsBuilder.reflectionEquals(expectedData, actualData));

	}

	@Test
	public void checkFooterPositions() {

		FooterMenu footerMenu = new FooterMenu();

		Map<String, Object> expectedAttributes = new HashMap<>();

		expectedAttributes.put(FooterMenu.AutiWithMiles, "Авто с пробегом");
		expectedAttributes.put(FooterMenu.NewCars, "Новые авто");
		expectedAttributes.put(FooterMenu.YouTubeIcon, true);
		expectedAttributes.put(FooterMenu.YouTube, "YouTube");
		expectedAttributes.put(FooterMenu.AndroidBlock, true);

		Map<String, Object> actualAttributes = footerMenu.getActualAttributes();

		Assert.assertEquals(actualAttributes, expectedAttributes);

	}

	//@Test
	public void findBrokenLinks() {

		MainPage mainPage = new MainPage();
		List<WebElement> links = mainPage.getAllLinks();

		System.out.println("Number of links are: " + links.size());

		List<String> urlList = new ArrayList<>();

		for (WebElement e : links) {
			String url = e.getAttribute("href");
			urlList.add(url);
			// CheckBrokenLinks.checkBrokenLinks(url);

		}

		urlList.parallelStream().forEach(x -> CheckBrokenLinks.checkBrokenLinks(x));

		Assert.assertEquals(CheckBrokenLinks.brokenLinks.size(), 0);

	}
	
	@Test
	public void navigateOnThePage() {
		
	}
	
	
	
	

}
