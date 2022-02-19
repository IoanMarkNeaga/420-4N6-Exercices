package edu.neaga.simple.http;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {
    @GET("exos/long/double/{number}/")
    Call<String> doubleNumber(@Path("number") String number);
}
