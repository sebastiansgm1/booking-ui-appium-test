package com.yape.pe.models;

import java.util.Map;

public class PersonalInformation {

  private String firstName;
  private String lastName;
  private String email;
  private String address;
  private String zipCode;
  private String city;
  private String country;
  private String mobile;
  private String tripReason;

  public PersonalInformation(String firstName, String lastName, String email, String address,
      String zipCode, String city, String country, String mobile, String tripReason) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.address = address;
    this.zipCode = zipCode;
    this.city = city;
    this.country = country;
    this.mobile = mobile;
    this.tripReason = tripReason;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  public String getZipCode() {
    return zipCode;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  public String getMobile() {
    return mobile;
  }

  public String getTripReason() {
    return tripReason;
  }

  public static PersonalInformation getPersonalInformationModel(Map<String, String> data) {
    return new PersonalInformation(data.get("Firtsname"), data.get("Lastname"),
        data.get("Email"), data.get("Address"),
        data.get("Zip code"), data.get("City"),
        data.get("Country"), data.get("Mobile"), data.get("Trip reason"));
  }
}
