package com.runner;

import com.base.Base_Class;
import com.utility.ReadExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class TestRunnerXml extends Base_Class {
    public static void main(String[] args) throws InterruptedException {

        driver =launchBrowser("edge");
        driver.manage().window().maximize();
        driver.get("https://www.youtube.com/");
        String search = ReadExcelData.getParticularData(1, 0);
        driver.findElement(By.name("search_query")).sendKeys(search);
        driver.findElement(By.xpath("//button[@title='Search']")).click();
        Thread.sleep(3000);
        String path = takeScreenshot("searchPage");
        System.out.println("Screenshot saved at: " + path);


    }
}
