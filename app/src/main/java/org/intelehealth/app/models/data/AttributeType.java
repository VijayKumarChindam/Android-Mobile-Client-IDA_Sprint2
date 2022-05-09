package org.intelehealth.app.models.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class AttributeType {

  @SerializedName("uuid")
  String uuid;
  @SerializedName("display")
  String display;
  @SerializedName("links")
  ArrayList<Links> links;

  public AttributeType(String uuid, String display, ArrayList<Links> links) {
    this.uuid = uuid;
    this.display = display;
    this.links = links;
  }
}