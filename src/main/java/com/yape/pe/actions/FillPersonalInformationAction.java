package com.yape.pe.actions;

import static com.yape.pe.models.PersonalInformation.getPersonalInformationModel;
import static com.yape.pe.pages.PersonalInformationPage.BTN_NEXT_STEP;
import static com.yape.pe.pages.PersonalInformationPage.ET_ADDRESS;
import static com.yape.pe.pages.PersonalInformationPage.ET_CITY;
import static com.yape.pe.pages.PersonalInformationPage.ET_COUNTRY;
import static com.yape.pe.pages.PersonalInformationPage.ET_EMAIL;
import static com.yape.pe.pages.PersonalInformationPage.ET_FIRST_NAME;
import static com.yape.pe.pages.PersonalInformationPage.ET_LAST_NAME;
import static com.yape.pe.pages.PersonalInformationPage.ET_MOBILE;
import static com.yape.pe.pages.PersonalInformationPage.ET_ZIP_CODE;
import static com.yape.pe.pages.PersonalInformationPage.RBT_TRIP_BUSINESS;
import static com.yape.pe.pages.PersonalInformationPage.RBT_TRIP_LEISURE;
import static com.yape.pe.pages.PersonalInformationPage.TV_TOTAL;
import static com.yape.pe.utilities.SessionVariables.SESSION_PERSONAL;
import static com.yape.pe.utilities.SessionVariables.SESSION_TOTAL_PERSONAL_INFORMATION;

import com.yape.pe.models.PersonalInformation;
import com.yape.pe.pages.GeneralPageObject;
import java.util.Map;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class FillPersonalInformationAction extends UIInteractions {

  @Page
  GeneralPageObject generalPageObject;

  @Step
  public void completePersonalInformationForm(Map<String, String> personalInformationData) {
    PersonalInformation personalInformation = getPersonalInformationModel(personalInformationData);
    Serenity.setSessionVariable(SESSION_PERSONAL.getVariableName()).to(personalInformation);
    $(ET_FIRST_NAME).sendKeys(personalInformation.getFirstName());
    $(ET_LAST_NAME).sendKeys(personalInformation.getLastName());
    $(ET_EMAIL).sendKeys(personalInformation.getEmail());
    $(ET_ADDRESS).sendKeys(personalInformation.getAddress());
    generalPageObject.scrollDown(1);
    $(ET_ZIP_CODE).sendKeys(personalInformation.getZipCode());
    $(ET_CITY).sendKeys(personalInformation.getCity());
    typeInto($(ET_COUNTRY), personalInformation.getCountry());
    $(ET_MOBILE).sendKeys(personalInformation.getMobile());
    selectTripType(personalInformation.getTripReason());
    String totalPersonalInformation = $(TV_TOTAL).getText().substring(2);
    Serenity.setSessionVariable(SESSION_TOTAL_PERSONAL_INFORMATION.getVariableName())
        .to(totalPersonalInformation);
    $(BTN_NEXT_STEP).click();
  }

  private void selectTripType(String reason) {
    if (reason.equals("Negocios")) {
      $(RBT_TRIP_BUSINESS).click();
    } else if (reason.equals("Ocio")) {
      $(RBT_TRIP_LEISURE).click();
    }
  }
}
