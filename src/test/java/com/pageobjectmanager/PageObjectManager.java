package com.pageobjectmanager;

import com.pageobjectmodel.AddressPage;
import com.pageobjectmodel.CheckPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.SearchPage;
import com.utility.FileReaderManager;

public class PageObjectManager {
    private FileReaderManager fileReaderManager;
    private static PageObjectManager pageObjectManager;
    private LoginPage loginPage;
    private SearchPage searchPage;
    private CheckPage checkPage;
    public AddressPage addressPage;


    public FileReaderManager getFileReaderManager(){
        if(fileReaderManager==null){
            fileReaderManager =new FileReaderManager();
        }
        return fileReaderManager;
    }
    public static PageObjectManager getPageObjectManager(){
        if(pageObjectManager==null){
            pageObjectManager=new PageObjectManager();
        }
        return pageObjectManager;

    }
    public LoginPage getLoginPage(){
        if(loginPage==null){
            loginPage=new LoginPage();
        }
        return loginPage;
    }
    public SearchPage getSearchPage(){
        if(searchPage==null){
            searchPage=new SearchPage();
        }
        return searchPage;
    }
    public CheckPage getCheckPage(){
        if(checkPage==null){
            checkPage=new CheckPage();
        }
        return checkPage;
    }
    public AddressPage getAddressPage(){
        if(addressPage==null) {
            addressPage = new AddressPage();
        }
        return addressPage;
        }
    }


