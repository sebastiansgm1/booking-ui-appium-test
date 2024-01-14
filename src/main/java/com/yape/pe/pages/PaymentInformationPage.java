package com.yape.pe.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaymentInformationPage extends PageObject {

  public static final By TV_TOTAL_PAYMENT = By.xpath(
      "//android.widget.LinearLayout[@resource-id='com.booking:id/informative_cta_view_price_container']//android.widget.TextView[@resource-id='com.booking:id/subtitle']");
  public static final By ET_CARD_NUMBER = By.id("com.booking:id/new_credit_card_number_edit");
  public static final By ET_CARD_NAME = By.id("com.booking:id/new_credit_card_holder_edit");
  public static final By ET_DUE_DATE = By.id("com.booking:id/new_credit_card_expiry_date_edit");
  public static final By TV_NAME = By.id("com.booking:id/name");
  public static final By TV_EMAIL = By.id("com.booking:id/email");
  public static final By TV_ADDRESS = By.id("com.booking:id/address_zip");
  public static final By TV_CITY_COUNTRY = By.id("com.booking:id/city_country");
  public static final By TV_MOBILE = By.id("com.booking:id/phone");
  public static final By TV_SUMARY_ACCOMMODATION = By.id("com.booking:id/subtitle");

}
