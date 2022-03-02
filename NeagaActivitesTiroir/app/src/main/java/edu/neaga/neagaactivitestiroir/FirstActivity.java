package edu.neaga.neagaactivitestiroir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import edu.neaga.neagaactivitestiroir.databinding.ActivityFirstBinding;

public class FirstActivity extends AppCompatActivity {
    ActivityFirstBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirstBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setTitle("Activité 1");
    }
}