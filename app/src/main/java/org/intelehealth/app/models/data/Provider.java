package org.intelehealth.app.models.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Provider {

  @SerializedName("uuid")
  String uuid;
  @SerializedName("display")
  public
  String  display;
  @SerializedName("links")
  ArrayList<Links> links;

  public Provider(String uuid, String display, ArrayList<Links> links) {
    this.uuid = uuid;
    this.display = display;
    this.links = links;
  }
}