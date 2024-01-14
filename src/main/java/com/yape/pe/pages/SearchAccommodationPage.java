package com.yape.pe.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class SearchAccommodationPage extends PageObject {

  public static final By TV_ENTER_DESTINATION = By.id(
      "com.booking:id/facet_search_box_basic_field_label");
  public static final By ET_ENTER_DESTINATION = By.id(
      "com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content");
  public static final By IMG_DESTINATION = By.id(
      "com.booking:id/view_disambiguation_destination_icon");
  public static final By BTN_SELECT_DATE = By.id("com.booking:id/facet_date_picker_confirm");
  public static final By BTN_SELECT_QUANTITIES = By.id(
      "com.booking:id/facet_search_box_accommodation_occupancy");
  public static final By BTN_ADD = By.xpath(
      "//android.widget.Button[@resource-id='com.booking:id/bui_input_stepper_add_button']");
  public static final By BTN_REMOVE = By.xpath(
      "//android.widget.Button[@resource-id='com.booking:id/bui_input_stepper_remove_button']");
  public static final By TV_QUANTITY = By.xpath(
      "//android.widget.TextView[@resource-id='com.booking:id/bui_input_stepper_value']");
  public static final By BTN_OK = By.id("android:id/button1");
  public static final By BTN_APPLY_QUIANTITIES = By.id("com.booking:id/group_config_apply_button");
  public static final By BTN_SEARCH = By.id("com.booking:id/facet_search_box_cta");


}
