package org.intelehealth.app.models.data;

import com.google.gson.annotations.SerializedName;


public class Identifiers {

  @SerializedName("identifier")
  String  identifier;

  public Identifiers(String identifier) {
    this.identifier = identifier;
  }
}