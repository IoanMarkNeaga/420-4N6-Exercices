package edu.neaga.communicationactivite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.neaga.communicationactivite.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.button.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("text", binding.editText.getText().toString());
            startActivity(i);
        });
    }
}