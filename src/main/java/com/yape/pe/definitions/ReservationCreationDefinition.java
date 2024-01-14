package com.yape.pe.definitions;

import com.yape.pe.actions.BookingSummaryAction;
import com.yape.pe.actions.FillPersonalInformationAction;
import com.yape.pe.actions.LoginAction;
import com.yape.pe.actions.PaymentInformationAction;
import com.yape.pe.actions.SearchAccommodationAction;
import com.yape.pe.actions.SelectAccomodationAction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import net.thucydides.core.annotations.Steps;

public class ReservationCreationDefinition {

  @Steps
  LoginAction loginAction;
  @Steps
  SearchAccommodationAction searchAccommodationAction;
  @Steps
  SelectAccomodationAction selectAccomodationAction;
  @Steps
  FillPersonalInformationAction fillPersonalInformationAction;
  @Steps
  BookingSummaryAction bookingSummaryAction;
  @Steps
  PaymentInformationAction paymentInformationAction;

  @Given("I enter the booking app without logging in")
  public void EnterAndCloseLogin() {
    loginAction.closeLoginScreen();
  }

  @When("I look for accommodation with the following information")
  public void searchAccommodation(
      List<Map<String, String>> accommodationData) {
    searchAccommodationAction.search(accommodationData.get(0));
  }

  @When("select item {int} And I choose the first room")
  public void selectHotelAndRoom(int hotel) {
    selectAccomodationAction.selectHotelAndRoom(hotel);
  }

  @When("Diligence of personal information")
  public void fillPersonalInformation(List<Map<String, String>> personalInformationData) {
    fillPersonalInformationAction.completePersonalInformationForm(personalInformationData.get(0));
    bookingSummaryAction.confirmBooking();
  }

  @When("Enter payment information")
  public void enterPaymentInformation(List<Map<String, String>> paymentData) {
    paymentInformationAction.fillPaymentInformation(paymentData.get(0));
  }

  @Then("The reservation will be created correctly")
  public void verifyBooking() {
    paymentInformationAction.verifyBookingInformation();
  }

}
