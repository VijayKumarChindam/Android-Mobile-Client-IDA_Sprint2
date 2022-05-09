package org.intelehealth.app.auth;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BasicAuthClient {
    OkHttpClient client=new OkHttpClient.Builder()
            .addInterceptor(new BasicAuthInterceptor("doctor1", "Doctor123"))
            .build();
    Gson gson= new GsonBuilder()
            .setLenient()
            .create();
    Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("https://demo.intelehealth.org")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
