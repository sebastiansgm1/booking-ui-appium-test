package com.yape.pe.actions;

import static com.yape.pe.pages.HotelAndRoomPage.BTN_RESERVE_THIS_ROOM;
import static com.yape.pe.pages.HotelAndRoomPage.BTN_SELECT_ROOM;
import static com.yape.pe.pages.HotelAndRoomPage.LIST_HOTELS;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class SelectAccomodationAction extends UIInteractions {

  @Step
  public void selectHotelAndRoom(int item) {
    $$(LIST_HOTELS).get((item + 1)).click();
    $(BTN_SELECT_ROOM).click();
    $(BTN_RESERVE_THIS_ROOM).click();
  }
}
