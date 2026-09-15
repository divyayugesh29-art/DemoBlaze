package com.base;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.List;

public abstract class Base_Class {
    public static WebDriver driver;
    //1.Browswer Launch
    protected static WebDriver launchBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO LAUNCH BROWSER");
        }
        driver.manage().window().maximize();
        return driver;
    }

    //2.Close Browser
    protected static void closeBrowser() {
        try {
            driver.close();
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO CLOSE BROWSER");
        }}
    //3.Quit Browser
    protected static void quitBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO QUIT BROWSER");
        }}
    //4&5&6&7 Navigation Commands
    protected static void navigateTo(String url) {
        try {
            driver.navigate().to(url);
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO NAVIGATE TO URL");
        }}
    protected static void navigateBack() {
        try {
            driver.navigate().back();
        } catch (Exception e) {
            Assert.fail("Error:Failed to navigate back");
        }}
    protected static void navigateForward() {
        try {
            driver.navigate().forward();
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO NAVIGATE FORWARD");
        }}
    protected static void navigateRefresh() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO REFRESH PAGE");
        }}
    //8.get() command
    protected static void launchUrl(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO GET URL");
        }}
    //9.Alert() commands
    protected static void alertAccept() {
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO ACCEPT ALERT");
        }}
    protected static void alertDismiss() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO DISMISS ALERT");
        }}
    protected static void alertSendKeys(String value) {
        try {
            driver.switchTo().alert().sendKeys(value);
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO SEND KEYS TO ALERT");
        }}
    protected static String getAlertText() {

        try {
            String text1 = driver.switchTo().alert().getText();
            return text1;

        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO GET TEXT FROM ALERT");
        }
        return null;
    }
    //10.Action class commands
    protected static void mouseHover(WebElement element) {
        Actions actions = new Actions(driver);
        try {
            actions.moveToElement(element).build().perform();
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO HOVER MOUSE");
        }}
    protected static void rightClick(WebElement element) {
        Actions actions = new Actions(driver);
        try {
            actions.contextClick(element).build().perform();
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO RIGHT CLICK");
        }}
    protected static void doubleClick(WebElement element) {
        Actions actions = new Actions(driver);
        try {
            actions.doubleClick(element).build().perform();
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO DOUBLE CLICK");
        }}
    protected static void dragAndDrop(WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        try {
            actions.dragAndDrop(source, target).build().perform();
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO DRAG AND DROP");
        }}
    protected static void clickAndHold(WebElement element) {
        Actions actions = new Actions(driver);
        try {
            actions.clickAndHold(element).build().perform();
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO CLICK AND HOLD");
        }}
    protected static void actionSendKeys(WebElement element, String value) {
        Actions actions=new Actions(driver);
        try {
            actions.moveToElement(element).sendKeys(value).perform();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING ACTION SEND KEYS");
        }}
    //11.Frames Commands
    protected static void switchToFrame(int index) {
        try {
            driver.switchTo().frame(index);
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO SWITCH TO FRAME");
        }}
    protected static void switchToFrame(String nameOrId) {
        try {
            driver.switchTo().frame(nameOrId);
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO SWITCH TO FRAME");
        }}
    protected static void switchToFrame(WebElement element) {
        try {
            driver.switchTo().frame(element);
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO SWITCH TO FRAME");
        }}
    protected static void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO SWITCH TO DEFAULT CONTENT");
        }}
    protected static void switchToParentFrame() {
        try {
            driver.switchTo().parentFrame();
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO SWITCH TO PARENT FRAME");
        }}
    //12.ROBOT Class Commands
    protected static void robotKeyPress(int keyEvent) throws AWTException {
        Robot robot=new Robot();
        try {
            robot.keyPress(keyEvent);
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO PRESS KEY");
        }}
    protected static void robotKeyRelease(int keyEvent) throws AWTException {
        Robot robot=new Robot();
        try {
            robot.keyRelease(keyEvent);
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO RELEASE KEY");
        }}
    protected void robotMousePress(int buttons) throws AWTException {
        Robot robot=new Robot();
        try {
            robot.mousePress(buttons);
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO PRESS MOUSE");
        }}
    protected void robotMouseRelease(int buttons) throws AWTException {
        Robot robot=new Robot();
        try {
            robot.mouseRelease(buttons);
        } catch (Exception e) {
            Assert.fail("ERROR:FAILED TO RELEASE MOUSE");
        }}
    //13.Window Handles commands
    protected static String getWindowHandle() {
        String windowHandle = "";
        try {
            windowHandle  = driver.getWindowHandle();
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED TO GET WINDOW HANDLE");
        }
        return windowHandle ;
    }

    protected static Set<String> getWindowHandles() {
        Set<String> windowHandles = null;
        try {
            windowHandles = driver.getWindowHandles();
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED TO GET WINDOW HANDLES");
        }
        return windowHandles;
    }
    //14.Drop Down Commands
    protected static void selectOption(WebElement element, String type, String value) {
        Select select = new Select(element);
        try {
            if (type.equalsIgnoreCase("value")) {
                select.selectByValue(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.selectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("text")) {
                select.selectByVisibleText(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING   VALUE SELECTION");
        }
    }

    protected static void deSelectOption(WebElement element, String type, String value) {
        Select select = new Select(element);
        try {
            if (type.equalsIgnoreCase("value")) {
                select.deselectByValue(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.deselectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("text")) {
                select.deselectByVisibleText(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING VALUE DESELECTION");
        }
    }
    //15.CHECKBOX Commands
    protected static void checkBox(WebElement element, boolean check) {
        try {
            if (check && !element.isSelected()) {
                element.click();
            } else if (!check && element.isSelected()) {
                element.click();
            }
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING CHECKBOX HANDLING");
        }
    }
    //16-18 STATE CHECKS
    protected static boolean isEnable(WebElement element) {
        boolean flag = false;
        try {
            flag = element.isEnabled();
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING IS ENABLE CHECK");
        }
        return flag;
    }

    protected static boolean isDisplayed(WebElement element) {
        boolean flag = false;
        try {
            flag = element.isDisplayed();
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING IS DISPLAYED CHECK");
        }
        return flag;
    }

    protected static boolean isSelected(WebElement element) {
        boolean flag = false;
        try {
            flag = element.isSelected();
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING IS SELECTED CHECK");
        }
        return flag;
    }
    //19.GET OPTIONS
    protected static List<String> getOptions(WebElement element) {
        List<String> optionList = new ArrayList<>();
        try {
            Select select = new Select(element);
            for (WebElement option : select.getOptions()) {
                optionList.add(option.getText());
            }
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING GET OPTIONS");
        }
        return optionList;
    }
    //20 GET URL & TITLE
    protected static String getTitle() {
        String title = "";
        try {
            title = driver.getTitle();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING GET TITLE");
        }
        return title;
    }
    //21 Get Current URL
    protected static String getCurrentUrl() {
        String url = "";
        try {
            url = driver.getCurrentUrl();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING GET CURRENT URL");
        }
        return url;
    }
    // ===================================================================
    // 22-23. GET TEXT / GET ATTRIBUTE
    // ===================================================================
    protected static void getText(WebElement element) {

        try {
          String  text = element.getText();
            System.out.println(text);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING GET TEXT");
        }

    }

    protected static String getAttribute(WebElement element, String attributeName) {
        String value = "";
        try {
            value = element.getAttribute(attributeName);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING GET ATTRIBUTE");
        }
        return value;
    }

    // 24. WAITS
    protected static void implicitWait(int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING IMPLICIT WAIT");
        }
    }

    protected static WebElement waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = null;
        try {
            el = wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING WAIT FOR VISIBILITY");
        }
        return el;
    }

    protected static WebElement waitForClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement el = null;
        try {
            el = wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING WAIT FOR CLICKABLE");

        }
        return el;
    }

    // 25. SEND KEYS

    protected static void passInput(WebElement element, String value) {
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING VALUE PASSING");
        }
    }
    // 26. Get First Selected options
    protected static String getFirstSelectedOption(WebElement element) {
        String value = "";
        try {
            Select select = new Select(element);
            value = select.getFirstSelectedOption().getText();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING GET FIRST SELECTED OPTION");
        }
        return value;
    }
    //27.Get all selected options

    protected static List<String> getAllSelectedOptions(WebElement element) {
        List<String> values = new ArrayList<>();
        try {
            Select select = new Select(element);
            for (WebElement option : select.getAllSelectedOptions()) {
                values.add(option.getText());
            }
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING GET ALL SELECTED OPTIONS");
        }
        return values;
    }
    //28. Is Multiple
    protected static boolean isMultiple(WebElement element) {
        boolean flag = false;
        try {
            Select select = new Select(element);
            flag = select.isMultiple();
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING MULTIPLE CHECK");
        }
        return flag;
    }
    //29.click
    protected static void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING ELEMENT CLICKING");
        }
    }
    //30.Radio Button
    protected static void radioButtonSelect(WebElement element) {
        try {
            if (!element.isSelected()) {
                element.click();
            }
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING RADIO BUTTON SELECTION");
        }
    }
    //31.JavaScript Executor Command
    protected static void jsClick(WebElement element) {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        try {
            js.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            Assert.fail("ERROR : FAILED DURING JS CLICK");
        }
    }
    //32. ScreenShot
    protected static String takeScreenshot(String screenshotName) {
        String destinationPath = "";
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            destinationPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "_" + timeStamp + ".png";
            File destination = new File(destinationPath);
            Files.createDirectories(Paths.get(System.getProperty("user.dir") + "/screenshots/"));
            Files.copy(source.toPath(), destination.toPath());
        } catch (Exception e) {
            Assert.fail("ERROR : OCCURE DURING TAKE SCREENSHOT");
        }
        return destinationPath;
    }
}















