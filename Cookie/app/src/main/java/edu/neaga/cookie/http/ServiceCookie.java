package edu.neaga.cookie.http;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceCookie {
    @GET("exos/cookie/echo")
    Call<String> cookieEcho();
}
