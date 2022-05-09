package org.intelehealth.app.models.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Results {

  @SerializedName("uuid")
  String uuid;
  @SerializedName("patient")
  Patient patient;
  @SerializedName("location")
  Location location;
  @SerializedName("encounters")
  public
  ArrayList<Encounters> encounters;
  @SerializedName("attributes")
  ArrayList<Attributes> attributes;

  public Results(String uuid, Patient patient, Location location, ArrayList<Encounters> encounters, ArrayList<Attributes> attributes) {
    this.uuid = uuid;
    this.patient = patient;
    this.location = location;
    this.encounters = encounters;
    this.attributes = attributes;
  }
}