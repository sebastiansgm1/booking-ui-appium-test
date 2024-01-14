package com.yape.pe.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class SummaryBookingPage extends PageObject {

  public static final By BTN_LAST_STEP = By.id("com.booking:id/action_button");
  public static final By TV_TOTAL_SUMMARY = By.xpath(
      "//android.widget.LinearLayout[@resource-id='com.booking:id/informative_cta_view_price_container']//android.widget.TextView[@resource-id='com.booking:id/title']");

}
