package edu.neaga.listes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.neaga.listes.databinding.ActivityMainBinding;
import edu.neaga.listes.http.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private LongAdapter longAdapter = new LongAdapter(new ArrayList<>());

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

        binding.longs.setAdapter(longAdapter);
        binding.longs.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        service.getLongList().enqueue(new Callback<List<Long>>() {
            @Override
            public void onResponse(Call<List<Long>> call, Response<List<Long>> response) {
                if (response.isSuccessful()) {
                    List<Long> longList = response.body();
                    longAdapter = new LongAdapter(longList);
                    binding.longs.setAdapter(longAdapter);
                    longAdapter.notifyDataSetChanged();
                } else {
                    Log.e("RETROFIT", response.code()+"");
                }
            }
            @Override
            public void onFailure(Call<List<Long>> call, Throwable t) {
                Log.e("RETROFIT", t.getMessage());
            }
        });
    }
}