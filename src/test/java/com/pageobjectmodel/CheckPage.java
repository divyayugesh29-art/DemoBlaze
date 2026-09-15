package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.CheckOutInterfaceElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckPage extends Base_Class implements CheckOutInterfaceElements {
    @FindBy(linkText=linkText_cart)
    private static WebElement addCart;

    @FindBy(xpath = order_xpath)
    private static WebElement placeOrder;

    public CheckPage() {
        PageFactory.initElements(driver, this);
    }

    public static void checkProduct() throws InterruptedException {
        clickOnElement(addCart);
        Thread.sleep(3000);
        takeScreenshot("CartPage");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
        clickOnElement(placeOrder);


    }

}
