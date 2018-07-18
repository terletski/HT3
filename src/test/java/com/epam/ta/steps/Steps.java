package com.epam.ta.steps;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Steps {
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser()
	{
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver()
	{
		DriverSingleton.closeDriver();
	}

	public void loginGithub(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
		logger.info("Actual username: " + actualUsername);
		return actualUsername.equals(username);
	}

	public boolean createNewRepository(String repositoryName, String repositoryDescription)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnCreateNewRepositoryButton();
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		String expectedRepoName = createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
		return expectedRepoName.equals(createNewRepositoryPage.getCurrentRepositoryName());
	}

	public boolean currentRepositoryIsEmpty()
	{
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.isCurrentRepositoryEmpty();
	}

	public boolean clickOnSubscribeAndUnsubscribe() {
		SubscribePage subscribePage = new SubscribePage(driver);
		subscribePage.clickOnExplore();
		subscribePage.clickOnSubscribe();
		subscribePage.clickOnDaily();
		subscribePage.clickOnExplore();
		subscribePage.clickOnSelectDaily();
		subscribePage.clickOnButtonUnsubscribe();
		return subscribePage.messageUnSubscribedEquals("Unsubscribed");
	}

	public Steps clickOnGreatNewGist() {
		CreateNewGistPage createNewGistPage = new CreateNewGistPage(driver);
		createNewGistPage.clickOnCreateNew();
		createNewGistPage.setName("Github");
		createNewGistPage.setCode("TestGithub");
		createNewGistPage.getName();
		createNewGistPage.getCode();
		createNewGistPage.clickOnCreatePublicGist();
		return this;
	}

	public boolean checkingMarketplace(){
		MarketplacePage marketplacePage = new MarketplacePage(driver);
		marketplacePage.clickOnMarketplace();
		marketplacePage.clickOnViewAll();
		marketplacePage.clickOnTesting();
		return marketplacePage.messageTestingEquals("Testing");
	}

	public boolean changeNotifications(){
		NotificationsPage notificationsPage = new NotificationsPage(driver);
		notificationsPage.clickOnNotifications();
		notificationsPage.clickOnNotificationsSettings();
		notificationsPage.goHome();
		return true;
	}
}





