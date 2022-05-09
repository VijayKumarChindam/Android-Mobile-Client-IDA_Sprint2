package org.intelehealth.app.models.data;

import com.google.gson.annotations.SerializedName;


public class Person {

  @SerializedName("display")
  String display;
  @SerializedName("gender")
  String gender;
  @SerializedName("age")
  Integer age;
  @SerializedName("birthdate")
  String birthdate;

  public Person(String display, String gender, Integer age, String birthdate) {
    this.display = display;
    this.gender = gender;
    this.age = age;
    this.birthdate = birthdate;
  }
}