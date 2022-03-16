package com.example.kvantproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        int theme = sp.getInt("THEME", R.style.Theme_AppCompat_Light);
        setTheme(theme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button settingsBtn = findViewById(R.id.settings);
        settingsBtn.setOnClickListener(this);

        }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(this, ActivityTwoSettings.class);
        startActivity(intent);
        }
    }