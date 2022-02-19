package edu.neaga.simple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import edu.neaga.simple.databinding.ActivityMainBinding;
import edu.neaga.simple.http.RetrofitUtil;
import edu.neaga.simple.http.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> {
            String input = binding.numberText.getText().toString().trim();
            if (input.isEmpty()) { input = "0"; }
            Service service = RetrofitUtil.get();
            service.doubleNumber(input).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, response.body().toString(), Toast.LENGTH_SHORT).show();
                    } else {
                        Log.e("RETROFIT", response.message());
                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.e("RETROFIT", t.getMessage());
                }
            });
        });
    }
}