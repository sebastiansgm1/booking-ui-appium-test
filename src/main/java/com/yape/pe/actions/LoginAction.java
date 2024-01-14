package com.yape.pe.actions;

import static com.yape.pe.pages.LoginPage.BTN_CLOSE_LOGIN;

import net.serenitybdd.core.steps.UIInteractions;

public class LoginAction extends UIInteractions {

  public void closeLoginScreen() {
    $(BTN_CLOSE_LOGIN).click();
  }
}
