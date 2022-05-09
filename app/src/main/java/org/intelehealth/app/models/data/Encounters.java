package org.intelehealth.app.models.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Encounters {
  @SerializedName("display")
  String display;
  @SerializedName("encounterDatetime")
  public
  String encounterDatetime;
  @SerializedName("voided")
  Boolean voided;
  @SerializedName("encounterType")
  public
  EncounterType encounterTypes;
  @SerializedName("encounterProviders")
  public
  ArrayList<EncounterProviders> encounterProviders;

  public Encounters(String display, String encounterDatetime, Boolean voided, EncounterType encounterTypes, ArrayList<EncounterProviders> encounterProviders) {
    this.display = display;
    this.encounterDatetime = encounterDatetime;
    this.voided = voided;
    this.encounterTypes = encounterTypes;
    this.encounterProviders = encounterProviders;
  }
}