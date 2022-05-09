package org.intelehealth.app.models.data;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class VisitData {

        @SerializedName("results" )
        public
        ArrayList<Results> results;

        public VisitData(ArrayList<Results> results) {
                this.results = results;
        }
}