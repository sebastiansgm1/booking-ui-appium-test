package com.yape.pe.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class PersonalInformationPage extends PageObject {

  public static final By ET_FIRST_NAME = By.xpath(
      " //javaClass[@resource-id='com.booking:id/bstage1_contact_firstname_value']/android.widget.EditText");
  public static final By ET_LAST_NAME = By.xpath(
      "//javaClass[@resource-id='com.booking:id/bstage1_contact_lastname_value']/android.widget.EditText");
  public static final By ET_EMAIL = By.xpath(
      "//javaClass[@resource-id='com.booking:id/bstage1_contact_email_value']/android.widget.AutoCompleteTextView");
  public static final By ET_ADDRESS = By.xpath(
      "//javaClass[@resource-id='com.booking:id/bstage1_contact_address_value']/android.widget.EditText");
  public static final By ET_ZIP_CODE = By.xpath(
      "//javaClass[@resource-id='com.booking:id/bstage1_contact_zipcode_value']/android.widget.EditText");
  public static final By ET_CITY = By.xpath(
      "//javaClass[@resource-id='com.booking:id/bstage1_contact_city_value']/android.widget.EditText");
  public static final By ET_COUNTRY = By.xpath(
      "//javaClass[@resource-id='com.booking:id/bstage1_contact_country_value']/android.widget.AutoCompleteTextView");
  public static final By ET_MOBILE = By.xpath(
      "//javaClass[@resource-id='com.booking:id/bstage1_contact_telephone_value']/android.widget.EditText");
  public static final By RBT_TRIP_BUSINESS = By.id("com.booking:id/business_purpose_business");
  public static final By RBT_TRIP_LEISURE = By.id("com.booking:id/business_purpose_leisure");
  public static final By TV_TOTAL = By.xpath(
      "//android.widget.LinearLayout[@resource-id='com.booking:id/informative_cta_view_price_container']//android.widget.TextView[@resource-id='com.booking:id/title']");
  public static final By BTN_NEXT_STEP = By.id("com.booking:id/action_button");

}
