package org.intelehealth.app.models.data;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class Patient {

  @SerializedName("uuid")
  String uuid;
  @SerializedName("identifiers")
  ArrayList<Identifiers> identifiers;
  @SerializedName("person")
  Person person;

  public Patient(String uuid, ArrayList<Identifiers> identifiers, Person person) {
    this.uuid = uuid;
    this.identifiers = identifiers;
    this.person = person;
  }
}