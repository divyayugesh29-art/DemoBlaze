package com.interfaceelements;

public interface AddressPageInterfaceElements {
    String name_id="name";
    String country_id="country";
    String city_id="city";
    String card_id="card";
    String month_id="month";
    String year_id="year";
    String purchaseButton_xpath ="//button[text()='Purchase']";
    String successMessage_xpath="//*[text()='Thank you for your purchase!']";
    String orderMessage_xpath="/html/body/div[10]/p";
    String okButton_xpath = "//button[@tabindex='1']";
    String logOutButton_id ="logout2";

}


