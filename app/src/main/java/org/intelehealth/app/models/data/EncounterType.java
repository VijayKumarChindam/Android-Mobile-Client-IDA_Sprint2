package org.intelehealth.app.models.data;

import com.google.gson.annotations.SerializedName;


public class EncounterType {

  @SerializedName("display")
  public
  String display;

  public EncounterType(String display) {
    this.display = display;
  }
}