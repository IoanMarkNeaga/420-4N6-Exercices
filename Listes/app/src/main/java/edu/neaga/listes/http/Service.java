package edu.neaga.listes.http;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("exos/long/list")
    Call<List<Long>> getLongList();
}
