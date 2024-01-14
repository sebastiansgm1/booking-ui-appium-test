package com.yape.pe.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HotelAndRoomPage extends PageObject {

  public static final By LIST_HOTELS = By.xpath(
      "//android.widget.FrameLayout[@resource-id='com.booking:id/results_list_facet']//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup");
  public static final By BTN_SELECT_ROOM = By.id("com.booking:id/select_room_cta");
  public static final By BTN_RESERVE_THIS_ROOM = By.id(
      "com.booking:id/recommended_block_reserve_button");
}
