package edu.neaga.superrecycler;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;

public class Secret {
    public String nom;
    public LocalDateTime date;
    public Long nbGrand;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Secret(String nom, Long nbGrand) {
        this.nom = nom;
        this.date = LocalDateTime.now();
        this.nbGrand = nbGrand;
    }
}
