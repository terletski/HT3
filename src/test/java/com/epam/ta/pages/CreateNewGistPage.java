package com.epam.ta.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewGistPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    // Подготовка элементов страницы.
    @FindBy(css = "#user-links > li:nth-child(2) > details > summary > svg")
    private WebElement buttonCreateNew;

    @FindBy(xpath = "//*[@id=\"user-links\"]/li[2]/details/ul/a[3]")
    private WebElement buttonNewGist;

    @FindBy(xpath = "//*[@id=\"gists\"]/div[2]/div/div[1]/div[2]/input[2]")
    private WebElement formFileName;

    @FindBy(xpath = "//*[@id=\"gists\"]/div[2]/div/div[2]/div/div[5]/div[1]/div/div/div/div[5]/div/pre")
    private WebElement formCodeLine;

    @FindBy(xpath = "//*[@id=\"new_gist\"]/div/div[2]/button[1]")
    private WebElement buttonCreatePublicGist;

    @FindBy(xpath = "//*[@id=\"new_gist\"]/div/button")
    private WebElement buttonCreateFile;


    public CreateNewGistPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnCreateNew()
    {
        buttonCreateNew.click();
        buttonNewGist.click();
        logger.info("Go to <Your notification settings> explored successfully");
    }


    public void clickOnCreatePublicGist()
    {
        buttonCreatePublicGist.click();
    }

    public CreateNewGistPage setName(String value) {
        formFileName.clear();
        formFileName.sendKeys(value);
        return this;
    }

    public CreateNewGistPage setCode(String value) {
        formFileName.clear();
        formCodeLine.sendKeys(value);
        return this;
    }

    public String getName() {
        return formFileName.getAttribute("value");
    }

    public String getCode() {
        return formCodeLine.getAttribute("value");
    }

    @Override
    public void openPage() {

    }
}
