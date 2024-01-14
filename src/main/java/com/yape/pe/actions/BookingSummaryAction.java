package com.yape.pe.actions;

import static com.yape.pe.pages.SummaryBookingPage.BTN_LAST_STEP;
import static com.yape.pe.pages.SummaryBookingPage.TV_TOTAL_SUMMARY;
import static com.yape.pe.utilities.SessionVariables.SESSION_TOTAL_SUMMARY;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

public class BookingSummaryAction extends PageObject {

  @Step
  public void confirmBooking() {
    String totalPersonalInformation = $(TV_TOTAL_SUMMARY).getText().substring(3);
    Serenity.setSessionVariable(SESSION_TOTAL_SUMMARY.getVariableName())
        .to(totalPersonalInformation);
    $(BTN_LAST_STEP).click();
  }

}
