package org.intelehealth.app.models.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class EncounterRole {

  @SerializedName("uuid")
  String uuid;
  @SerializedName("display")
  public
  String  display;
  @SerializedName("links")
  List<Links> links;

  public EncounterRole(String uuid, String display, List<Links> links) {
    this.uuid = uuid;
    this.display = display;
    this.links = links;
  }
}