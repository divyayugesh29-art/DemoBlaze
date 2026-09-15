package com.pageobjectmodel;

import com.base.Base_Class;
import com.interfaceelements.SearchProductInterfaceElements;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.SortedMap;

public class SearchPage extends Base_Class implements SearchProductInterfaceElements {

    @FindBy(linkText = linkText_laptop)
    private static WebElement laptop;
    @FindBy(linkText = linkText_sony)
    private static WebElement sony;
    @FindBy(linkText = linkText_cart)
    private static WebElement AddToCart;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    public static void searchProduct() throws InterruptedException {
        clickOnElement(laptop);
        clickOnElement(sony);
        Thread.sleep(5000);
        clickOnElement(AddToCart);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

    }


}
