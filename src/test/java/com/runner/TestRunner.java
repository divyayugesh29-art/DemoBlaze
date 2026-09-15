package com.runner;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;

public class TestRunner extends Base_Class {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("browser"));
        launchUrl(PageObjectManager.getPageObjectManager().getFileReaderManager().getDataProperty("url"));
        PageObjectManager.getPageObjectManager().getLoginPage().validLogin();
        PageObjectManager.getPageObjectManager().getSearchPage().searchProduct();
        PageObjectManager.getPageObjectManager().getCheckPage().checkProduct();
        PageObjectManager.getPageObjectManager().getAddressPage().addressPage();
    }

}
