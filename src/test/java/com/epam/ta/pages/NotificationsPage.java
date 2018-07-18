package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationsPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    // Подготовка элементов страницы.
    @FindBy(css = "#user-links > li:nth-child(1) > span > a > svg")
    private WebElement button_notifications;

    @FindBy(xpath = "//*[@id=\"notification-center\"]/div[2]/div[2]/div/p/a")
    private WebElement hrefNotificationSettings;

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div[2]/div[1]/h2")
    private WebElement message_notifications;

    @FindBy(css = "body > div.position-relative.js-header-wrapper > header > div > div:nth-child(1) > div > a > svg")
    private WebElement home;

    public NotificationsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnNotifications() {
        button_notifications.click();
        logger.info("Go to <Notification> explored successfully");
    }

    public void clickOnNotificationsSettings() {
        hrefNotificationSettings.click();
        logger.info("Go to <Your notification settings> explored successfully");
    }

    public void goHome() {
        if(message_notifications.isDisplayed()){
            home.click();
        }
    }

    @Override
    public void openPage() {

    }
}
