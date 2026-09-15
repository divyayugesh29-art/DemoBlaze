package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.LoginPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base_Class implements LoginPageInterfaceElements {
    @FindBy (id=login_id)
        private static WebElement login;
    @FindBy (id=username_id)
    private static WebElement username;
    @FindBy (id=password_id)
    private static WebElement password;
    @FindBy (xpath=signin_xpath)
    private static WebElement signin;

    @FindBy (id = title_id)
    private static WebElement title;

    public LoginPage() {

        PageFactory.initElements(driver, this);
    }

    public static void validLogin() throws InterruptedException {
        clickOnElement(login);
        Thread.sleep(2000);
        passInput(username, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("username"));
        passInput(password, PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("password"));
        clickOnElement(signin);
        Thread.sleep(5000);
        getText(title);
        takeScreenshot("LoginPage");
    }

}
