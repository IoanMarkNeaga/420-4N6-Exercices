package edu.neaga.simple.http;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitUtil {
    public static Service get() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl("https://exercices-web.herokuapp.com/")
                .build();

        return retrofit.create(Service.class);
    }
}
