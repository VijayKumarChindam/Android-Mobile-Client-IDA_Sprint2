package org.intelehealth.app.models.data;

import com.google.gson.annotations.SerializedName;


public class Location {

  @SerializedName("display")
  String display;

  public Location(String display) {
    this.display = display;
  }
}