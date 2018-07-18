package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketplacePage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();

    // Подготовка элементов страницы.
    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[1]/ul/li[3]/a")
    private WebElement hrefMarketplace;

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div[2]/div/div[1]/div/div[1]/a[1]")
    private WebElement button_view_all;

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div[2]/div/div[1]/nav/ul[2]/li[14]/a")
    private WebElement hrefTesting;

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div[1]/div/h1")
    private WebElement message_testing;


    public MarketplacePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnMarketplace()
    {
        hrefMarketplace.click();
        logger.info("Go to <Marketplace> explored successfully");
    }

    public void clickOnViewAll()
    {
        button_view_all.click();
        logger.info("Go to <View All> explored successfully");
    }

    public void clickOnTesting()
    {
        hrefTesting.click();
        logger.info("Go to <Testing> explored successfully");
    }

    public boolean messageTestingEquals(String search_string) {
        return message_testing.getText().equals(search_string);
    }

    @Override
    public void openPage() {

    }
}
