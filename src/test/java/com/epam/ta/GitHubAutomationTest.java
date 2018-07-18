package com.epam.ta;

import com.epam.ta.pages.CreateNewGistPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.ta.steps.Steps;

public class GitHubAutomationTest
{
	WebDriver driver = null;
	CreateNewGistPage page = PageFactory.initElements(driver, CreateNewGistPage.class);
	private Steps steps;
	private final String USERNAME = "testautomationuser";
	private final String PASSWORD = "Time4Death!";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test (dependsOnMethods = "oneCanLoginGithub")
	public void oneCanCreateProject()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.createNewRepository("testRepo", "auto-generated test repo"));
		Assert.assertTrue(steps.currentRepositoryIsEmpty());
		// do not use lots of asserts
	}

	@Test(description = "Login to Github")
	public void oneCanLoginGithub()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}

	@Test(description = "Subscribe and Unsubscribe")
	public void oneCanSubscribeAndUnsubscribe(){
		steps.loginGithub(USERNAME, PASSWORD);
		steps.clickOnSubscribeAndUnsubscribe();
		Assert.assertTrue(steps.clickOnSubscribeAndUnsubscribe());
	}

	@Test(description = "Create new Gist")
	public  void oneCanCreateNewGist(){
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.fail("It is not possible to edit the form --> [org.openqa.selenium.ElementNotInteractableException: Element <span> is not reachable by keyboard]");
		steps.clickOnGreatNewGist();
		Assert.assertEquals(page.getName(), "Github", "Unable to fill 'name' field");
		Assert.assertEquals(page.getCode(), "TestGithub", "Unable to fill 'description' field");

	}

	@Test(description = "Marketplace check")
	public void	oneCanCheckMarketplace(){
		steps.loginGithub(USERNAME, PASSWORD);
		steps.checkingMarketplace();
		Assert.assertTrue(steps.checkingMarketplace());
	}

	@Test(description = "Notification settings changing")
	public void	oneCanChangeNotificationSettings() {
		steps.loginGithub(USERNAME, PASSWORD);
		steps.changeNotifications();
		Assert.assertTrue(steps.changeNotifications());
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}
}
