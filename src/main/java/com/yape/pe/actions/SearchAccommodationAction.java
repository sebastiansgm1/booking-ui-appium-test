package com.yape.pe.actions;

import static com.yape.pe.models.Accommodation.getAccommodationModel;
import static com.yape.pe.pages.SearchAccommodationPage.BTN_ADD;
import static com.yape.pe.pages.SearchAccommodationPage.BTN_APPLY_QUIANTITIES;
import static com.yape.pe.pages.SearchAccommodationPage.BTN_OK;
import static com.yape.pe.pages.SearchAccommodationPage.BTN_REMOVE;
import static com.yape.pe.pages.SearchAccommodationPage.BTN_SEARCH;
import static com.yape.pe.pages.SearchAccommodationPage.BTN_SELECT_DATE;
import static com.yape.pe.pages.SearchAccommodationPage.BTN_SELECT_QUANTITIES;
import static com.yape.pe.pages.SearchAccommodationPage.ET_ENTER_DESTINATION;
import static com.yape.pe.pages.SearchAccommodationPage.IMG_DESTINATION;
import static com.yape.pe.pages.SearchAccommodationPage.TV_ENTER_DESTINATION;
import static com.yape.pe.pages.SearchAccommodationPage.TV_QUANTITY;
import static com.yape.pe.utilities.SessionVariables.SESSION_ACCOMMODATION;

import com.yape.pe.models.Accommodation;
import com.yape.pe.pages.GeneralPageObject;
import java.util.Map;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

public class SearchAccommodationAction extends UIInteractions {

  @Page
  GeneralPageObject generalPageObject;

  @Step("Fill information and search accomodation")
  public void search(Map<String, String> accommodationData) {
    Accommodation accommodation = getAccommodationModel(accommodationData);
    Serenity.setSessionVariable(SESSION_ACCOMMODATION.getVariableName()).to(accommodation);
    $(TV_ENTER_DESTINATION).click();
    $(ET_ENTER_DESTINATION).sendKeys(accommodation.getDestination());
    $$(IMG_DESTINATION).get(0).waitUntilVisible().click();
    selectDate(accommodation.getCheckin());
    selectDate(accommodation.getCheckout());
    $(BTN_SELECT_DATE).click();
    $(BTN_SELECT_QUANTITIES).click();
    addQuantityRoom(accommodation.getRoomsNumber());
    addAdult(accommodation.getAdultsNumber());
    selectChildrenQuantity(accommodation.getChildrenAge());
    $(BTN_APPLY_QUIANTITIES).click();
    $(BTN_SEARCH).waitUntilVisible().click();
  }

  /**
   * Este metodo busca la fecha por medio del scroll en el calendario y selecciona el dia por medio
   * del content-desc
   */
  private void selectDate(String date) {
    WebElementFacade dateElement = $("//android.view.View[@content-desc='{0}']", date);
    generalPageObject.scrollToElement(dateElement);
    dateElement.click();
  }

  private void addQuantityRoom(int number) {
    int roomQuantity = Integer.parseInt($$(TV_QUANTITY).get(0).getText());
    if (roomQuantity != number) {
      for (int i = 1; i < number; i++) {
        $$(BTN_ADD).get(0).click();
      }
    }
  }

  private void addAdult(int number) {
    int adultQuantity = Integer.parseInt($$(TV_QUANTITY).get(1).getText());
    if (adultQuantity < number) {
      int limit = number - adultQuantity;
      for (int i = 0; i < limit; i++) {
        $$(BTN_ADD).get(1).click();
      }
    } else if (adultQuantity > number) {
      int limit = adultQuantity - number;
      for (int i = 0; i < limit; i++) {
        $$(BTN_REMOVE).get(1).click();
      }
    }
  }

  private void selectChildrenQuantity(String age) {
    $$(BTN_ADD).get(2).click();
    WebElementFacade ageElement = $("//android.widget.Button[@text='{0}']", age);
    generalPageObject.scrollToElement(ageElement);
    ageElement.click();
    $(BTN_OK).click();
  }
}
