package org.intelehealth.app.models.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Attributes {

  @SerializedName("display")
  String display;
  @SerializedName("uuid")
  String uuid;
  @SerializedName("attributeType")
  AttributeType attributeType;
  @SerializedName("value")
  String value;
  @SerializedName("voided")
  Boolean voided;
  @SerializedName("links")
  ArrayList<Links> links;
  @SerializedName("resourceVersion")
  String resourceVersion;

  public Attributes(String display, String uuid, AttributeType attributeType, String value, Boolean voided, ArrayList<Links> links, String resourceVersion) {
    this.display = display;
    this.uuid = uuid;
    this.attributeType = attributeType;
    this.value = value;
    this.voided = voided;
    this.links = links;
    this.resourceVersion = resourceVersion;
  }



}