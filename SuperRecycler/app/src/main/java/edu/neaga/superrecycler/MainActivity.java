package edu.neaga.superrecycler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;

import java.time.LocalDateTime;
import java.util.Random;

import edu.neaga.superrecycler.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    SuperAdapter adapter = new SuperAdapter();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        prepareList();
        fillRecycler();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void prepareList() {
        for (int i = 0; i < 1000; i++) {
            Secret secret = new Secret("Item " + i, new Random().nextLong());
            adapter.localDataSet.add(secret);
        }
        adapter.notifyDataSetChanged();
    }

    private void fillRecycler() {
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        recyclerView.setAdapter(adapter);
    }
}