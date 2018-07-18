package com.epam.ta.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SubscribePage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    // Подготовка элементов страницы.
    @FindBy(xpath = "/html/body/div[1]/header/div/div[2]/div[1]/ul/li[4]/a")
    private WebElement hrefExplore;

    @FindBy(xpath = "/html/body/div[4]/div[2]/div/aside/form/div/button")
    private WebElement button_menu_subscribe;

    @FindBy(xpath = "//*[@id=\"newsletter\"]/form/div/div/div/div/label[1]/span")
    private WebElement button_daily;

    @FindBy(xpath = "//*[@id=\"newsletter\"]/h2/span")
    private WebElement message_subscribed;

    @FindBy(xpath = "//*[@id=\"newsletter\"]/form/div/button/span")
    private WebElement select_button_daily;

    @FindBy(xpath = "//*[@id=\"newsletter\"]/form/div/div/div/div/a/span")
    private WebElement button_unsibscribe;

    @FindBy(xpath = "//*[@id=\"js-pjax-container\"]/div/div/div[2]/div[1]/h1")
    private WebElement message_unsubscribed;


    public SubscribePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

        public void clickOnExplore()
    {
        hrefExplore.click();
        logger.info("Go to <Explore> explored successfully");
    }

    public void clickOnSubscribe()
    {
        button_menu_subscribe.click();
        logger.info("Click to <Subscribe> button explored successfully");
    }

    public void clickOnDaily()
    {
        button_daily.click();
        logger.info("Click to <Daily> button explored successfully");
    }

    public void clickOnSelectDaily(){
        select_button_daily.click();
        logger.info("Click to <Select Daily> button explored successfully");
    }

    public void clickOnButtonUnsubscribe(){
        button_unsibscribe.click();
        logger.info("Click to <Select Unsubscribe> button explored successfully");
    }

    public boolean messageUnSubscribedEquals(String search_string) {
        return message_unsubscribed.getText().equals(search_string);
    }

    @Override
    public void openPage() {

    }
}


