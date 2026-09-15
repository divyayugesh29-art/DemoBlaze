package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.AddressPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage extends Base_Class implements AddressPageInterfaceElements {
    @FindBy(id=name_id)
    private static WebElement name;
    @FindBy(id=country_id)
    private static WebElement country;
    @FindBy(id=city_id)
    private static WebElement city;
    @FindBy(id=card_id)
    private static WebElement card;
    @FindBy(id=month_id)
    private static WebElement month;
    @FindBy(id=year_id)
    private static WebElement year;
    @FindBy(xpath = purchaseButton_xpath)
    private static WebElement purchaseButton;
    @FindBy(xpath = successMessage_xpath)
    private static WebElement successMessage;
    @FindBy(xpath=orderMessage_xpath)
    private static WebElement orderMessage;
    @FindBy(xpath = okButton_xpath)
    private static WebElement okButton;
    @FindBy(id = logOutButton_id)
    private static WebElement logoutButton;



    public  AddressPage() {

        PageFactory.initElements(driver, this);
    }
    public static void addressPage() throws InterruptedException {
        Thread.sleep(3000);
        passInput(name, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("name"));
        passInput(country,PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("country"));
        passInput(city,PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("city"));
        passInput(card,PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("card"));
        passInput(month,PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("month"));
        passInput(year,PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("year"));
        clickOnElement(purchaseButton);
        getText(successMessage);
        getText(orderMessage);
        takeScreenshot("OrderMessage");
        Thread.sleep(3000);
        clickOnElement(okButton);
        Thread.sleep(3000);
        clickOnElement(logoutButton);
    }

}
