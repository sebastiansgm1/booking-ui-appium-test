package com.yape.pe.models;

import java.util.Map;

public class PaymentInformation {

  private String cardNumber;
  private String cardName;
  private String dueDate;

  public PaymentInformation(String cardNumber, String cardName, String dueDate) {
    this.cardNumber = cardNumber;
    this.cardName = cardName;
    this.dueDate = dueDate;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public String getCardName() {
    return cardName;
  }

  public String getDueDate() {
    return dueDate;
  }

  public static PaymentInformation getPaymentInformationModel(Map<String, String> data) {
    return new PaymentInformation(data.get("Card number"), data.get("Card name"),
        data.get("Due date"));
  }
}
