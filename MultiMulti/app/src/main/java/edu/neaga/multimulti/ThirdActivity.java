package edu.neaga.multimulti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import edu.neaga.multimulti.databinding.ActivityMainBinding;
import edu.neaga.multimulti.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {
    private ActivityThirdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityThirdBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.one:
                i = new Intent(this, MainActivity.class);
                break;
            case R.id.two:
                i = new Intent(this, SecondActivity.class);
                break;
            case R.id.three:
                i = new Intent(this, ThirdActivity.class);
                break;
            default:
                i = new Intent();
                break;
        }
        startActivity(i);
        return true;
    }
}