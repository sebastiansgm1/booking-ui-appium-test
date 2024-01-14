package com.yape.pe.pages;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getProxiedDriver;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import java.time.temporal.ChronoUnit;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.steps.StepInterceptor;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneralPageObject extends PageObject {

  protected AndroidDriver androidDriver;
  protected TouchAction action;
  protected static final Logger LOGGER = LoggerFactory.getLogger(StepInterceptor.class);

  public GeneralPageObject() {
    androidDriver = getProxiedDriver();
    action = new TouchAction(getProxiedDriver());
  }

  public void scrollToElement(WebElementFacade element) {
    setImplicitTimeout(1, ChronoUnit.SECONDS);
    while (!element.isVisible()) {
      scrollDown(1);
    }
    resetImplicitTimeout();
  }

  public void scrollDown(int amountScroll) {
    for (int i = 0; i < amountScroll; i++) {
      Dimension dimensions = androidDriver.manage().window().getSize();
      int startX = dimensions.width / 2;
      int startY = (int) (dimensions.height * 0.6);
      int endY = (int) (dimensions.height * 0.3);
      action
          .press(point(startX, startY))
          .waitAction(waitOptions(ofSeconds(1)))
          .moveTo(point(startX, endY))
          .release()
          .perform();
    }
  }
}
