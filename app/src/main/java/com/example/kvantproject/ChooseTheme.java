package com.example.kvantproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseTheme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_theme);
        Toast toast1 = Toast.makeText(getApplicationContext(), "Выбрана светлая тема", Toast.LENGTH_LONG);
        Toast toast2 = Toast.makeText(getApplicationContext(), "Выбрана темная тема", Toast.LENGTH_LONG);

        RadioGroup themeChooser = findViewById(R.id.theme_choose);
        themeChooser.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.light_theme:
                        //getApplication().setTheme(R.style.Theme_MyTheme);
                        //recreate();
                        setTheme(R.style.Theme_MyTheme);
                        toast1.show();
                        break;
                    case R.id.dark_theme:
                        //getApplication().setTheme(R.style.Theme_MyThemeNight);
                        //recreate();
                        setTheme(R.style.Theme_MyThemeNight);
                        toast2.show();
                        break;
                    default:
                        break;
                }
            }
        });
    }

}
