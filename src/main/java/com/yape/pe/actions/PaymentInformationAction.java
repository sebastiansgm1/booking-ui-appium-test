package com.yape.pe.actions;

import static com.yape.pe.models.PaymentInformation.getPaymentInformationModel;
import static com.yape.pe.pages.PaymentInformationPage.ET_CARD_NAME;
import static com.yape.pe.pages.PaymentInformationPage.ET_CARD_NUMBER;
import static com.yape.pe.pages.PaymentInformationPage.ET_DUE_DATE;
import static com.yape.pe.pages.PaymentInformationPage.TV_ADDRESS;
import static com.yape.pe.pages.PaymentInformationPage.TV_CITY_COUNTRY;
import static com.yape.pe.pages.PaymentInformationPage.TV_EMAIL;
import static com.yape.pe.pages.PaymentInformationPage.TV_MOBILE;
import static com.yape.pe.pages.PaymentInformationPage.TV_NAME;
import static com.yape.pe.pages.PaymentInformationPage.TV_SUMARY_ACCOMMODATION;
import static com.yape.pe.pages.PaymentInformationPage.TV_TOTAL_PAYMENT;
import static com.yape.pe.utilities.SessionVariables.SESSION_ACCOMMODATION;
import static com.yape.pe.utilities.SessionVariables.SESSION_PERSONAL;
import static com.yape.pe.utilities.SessionVariables.SESSION_TOTAL_PERSONAL_INFORMATION;
import static com.yape.pe.utilities.SessionVariables.SESSION_TOTAL_SUMMARY;

import com.yape.pe.models.Accommodation;
import com.yape.pe.models.PaymentInformation;
import com.yape.pe.models.PersonalInformation;
import com.yape.pe.pages.GeneralPageObject;
import java.util.Map;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.SoftAssertions;
import org.fluentlenium.core.annotation.Page;

public class PaymentInformationAction extends UIInteractions {

  @Page
  GeneralPageObject generalPageObject;

  @Step
  public void fillPaymentInformation(Map<String, String> paymentData) {
    PaymentInformation paymentInformation = getPaymentInformationModel(paymentData);
    typeInto($(ET_CARD_NUMBER), paymentInformation.getCardNumber());
    typeInto($(ET_CARD_NAME), paymentInformation.getCardName());
    typeInto($(ET_DUE_DATE), paymentInformation.getDueDate());
  }

  @Step("Personal information validation and total ammount")
  public void verifyBookingInformation() {
    generalPageObject.scrollToElement($(TV_MOBILE));
    String totalPersonalInformation = Serenity.sessionVariableCalled(
        SESSION_TOTAL_PERSONAL_INFORMATION.getVariableName());
    String totalSummary = Serenity.sessionVariableCalled(SESSION_TOTAL_SUMMARY.getVariableName());
    PersonalInformation personalInformation = Serenity.sessionVariableCalled(
        SESSION_PERSONAL.getVariableName());
    Accommodation accommodation = Serenity.sessionVariableCalled(
        SESSION_ACCOMMODATION.getVariableName());
    String currentTotal = $(TV_TOTAL_PAYMENT).getText().substring(2);
    String currentName = $(TV_NAME).getText();
    String currentEmail = $(TV_EMAIL).getText();
    String currentAddress = $(TV_ADDRESS).getText();
    String currentCityCountry = $(TV_CITY_COUNTRY).getText();
    String currentMobile = $(TV_MOBILE).getText();
    String currentAccomodation[] = $(TV_SUMARY_ACCOMMODATION).getText().split(",");

    SoftAssertions softly = new SoftAssertions();
    softly.assertThat(
        totalPersonalInformation.compareTo(currentTotal));
    softly.assertThat(
        totalSummary.compareTo(currentTotal));
    softly.assertThat(
        currentName.compareTo(
            personalInformation.getFirstName() + " " + personalInformation.getLastName()));
    softly.assertThat(currentEmail.compareTo(personalInformation.getEmail()));
    softly.assertThat(currentAddress.compareTo(
        personalInformation.getAddress() + ", " + personalInformation.getZipCode()));
    softly.assertThat(currentCityCountry.compareTo(
        personalInformation.getCity() + ", " + personalInformation.getCountry()));
    softly.assertThat(currentMobile.compareTo(personalInformation.getMobile()));
    softly.assertThat(
        currentAccomodation[1].contains(String.valueOf(accommodation.getRoomsNumber())));
    softly.assertThat(
        currentAccomodation[1].contains(String.valueOf(accommodation.getAdultsNumber())));
    softly.assertThat(
        currentAccomodation[2].contains(String.valueOf(accommodation.getChildrenNumber())));
    softly.assertAll();
  }

}
