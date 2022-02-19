package edu.neaga.complexe.http;

import edu.neaga.complexe.models.ComplexObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Service {
    @GET("exos/truc/complexe")
    Call<ComplexObject> getComplexObject(@Query("name") String name);
}
