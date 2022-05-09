package org.intelehealth.app.models.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class EncounterProviders {

  @SerializedName("uuid")
  String uuid;
  @SerializedName("provider")
  public
  Provider provider;
  @SerializedName("encounterRole")
  public
  EncounterRole encounterRole;
  @SerializedName("voided")
  Boolean voided;
  @SerializedName("links")
  ArrayList<Links> links;
  @SerializedName("resourceVersion")
  String resourceVersion;

  public EncounterProviders(String uuid, Provider provider, EncounterRole encounterRole, Boolean voided, ArrayList<Links> links, String resourceVersion) {
    this.uuid = uuid;
    this.provider = provider;
    this.encounterRole = encounterRole;
    this.voided = voided;
    this.links = links;
    this.resourceVersion = resourceVersion;
  }
}