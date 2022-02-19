package edu.neaga.complexe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import edu.neaga.complexe.databinding.ActivityMainBinding;
import edu.neaga.complexe.http.Service;
import edu.neaga.complexe.models.ComplexObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://exercices-web.herokuapp.com/")
                .build();
        Service service = retrofit.create(Service.class);

        String name = "Ioan";
        service.getComplexObject(name).enqueue(new Callback<ComplexObject>() {
            @Override
            public void onResponse(Call<ComplexObject> call, Response<ComplexObject> response) {
                if (response.isSuccessful()) {
                    ComplexObject object = response.body();
                    String text =
                            "a = " + object.a +
                                    "\nb = " + object.b;

                    if (object.c.length != 0) {
                        text += "\nc = " + object.c[0];
                        for (int i = 1; i < object.c.length; i++) {
                            text += ", " + object.c[i];
                        }
                    }
                    binding.objet.setText(text);
                } else {
                    Log.i("RETROFIT", response.code() + "");
                }
            }

            @Override
            public void onFailure(Call<ComplexObject> call, Throwable t) {
                Log.i("RETROFIT", t.getMessage());
            }
        });
    }
}