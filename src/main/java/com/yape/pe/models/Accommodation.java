package com.yape.pe.models;

import java.util.Map;

public class Accommodation {

  private String destination;
  private String checkin;
  private String checkout;
  private int roomsNumber;
  private int adultsNumber;
  private int childrenNumber;
  private String childrenAge;

  public Accommodation(String destination, String checkin, String checkout, int roomsNumber,
      int adultsNumber, int childrenNumber, String childrenAge) {
    this.destination = destination;
    this.checkin = checkin;
    this.checkout = checkout;
    this.roomsNumber = roomsNumber;
    this.adultsNumber = adultsNumber;
    this.childrenNumber = childrenNumber;
    this.childrenAge = childrenAge;
  }

  public String getDestination() {
    return destination;
  }

  public String getCheckin() {
    return checkin;
  }

  public String getCheckout() {
    return checkout;
  }

  public int getRoomsNumber() {
    return roomsNumber;
  }

  public int getAdultsNumber() {
    return adultsNumber;
  }

  public int getChildrenNumber() {
    return childrenNumber;
  }

  public String getChildrenAge() {
    return childrenAge;
  }

  public static Accommodation getAccommodationModel(Map<String, String> data) {
    return new Accommodation(data.get("Destination"), data.get("Checkin"),
        data.get("Checkout"), Integer.parseInt(data.get("Rooms Number")),
        Integer.parseInt(data.get("Adults Number")), Integer.parseInt(data.get("Children Number")),
        data.get("Children age"));
  }
}
