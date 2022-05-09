package org.intelehealth.app.auth;

import org.intelehealth.app.models.data.VisitData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DemoRemoteService {
    @GET("/openmrs/ws/rest/v1/visit?includeInactive=false&v=custom:(uuid,patient:(uuid,identifiers:(identifier),person:(display,gender,age,birthdate)),location:(display),encounters:(display,encounterDatetime,voided,encounterType:(display),encounterProviders),attributes)")
    Call<VisitData> getAllData();
}