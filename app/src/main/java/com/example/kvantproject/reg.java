package com.example.kvantproject;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//import com.example.kvantproject.MainActivity;
import com.example.kvantproject.R;


public class reg extends AppCompatActivity implements View.OnClickListener {
    EditText etName, etPassword;

    Intent intent;

    public static final String PREFS_NAME = "MyPrefsLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);

        Button btnAdd = findViewById(R.id.registr);
        btnAdd.setOnClickListener(this);

        Button btnRead = findViewById(R.id.button_login);
        btnRead.setOnClickListener(this);

        etName = (EditText) findViewById(R.id.edit_user);
        etPassword = (EditText) findViewById(R.id.edit_password);


    }

    @Override
    protected void onResume() {
        super.onResume();

        intent = new Intent(reg.this, MainActivity.class);
        Log.i("Mlog","ща резюм работает");


        SharedPreferences settings = getSharedPreferences(reg.PREFS_NAME, 0);
        //Get "hasLoggedIn" value. If the value doesn't exist yet false is returned

        if(settings.getBoolean("hasLoggedIn", false))
        {
            setContentView(R.layout.activity_main);
            Log.i("Mlog","корорче сработало по резюму");
        }

    }
    @Override
    public void onClick(View view) {
        String name = etName.getText().toString();
        String password = etPassword.getText().toString();


        ContentValues contentValues = new ContentValues();

        int id = view.getId();
        if (id == R.id.registr) {

            Toast toast = Toast.makeText(getApplicationContext(),
                    "вы успешно зарегались", Toast.LENGTH_SHORT);
            toast.show();
        } else if (id == R.id.button_login) {
            Toast toast = Toast.makeText(getApplicationContext(),
                    "вы успешно вошли", Toast.LENGTH_SHORT);
            toast.show();
            setContentView(R.layout.activity_main);

            //User has successfully logged in, save this information
            // We need an Editor object to make preference changes.
            SharedPreferences settings = getSharedPreferences(reg.PREFS_NAME, 0); // 0 - for private mode
            SharedPreferences.Editor editor = settings.edit();

            //Set "hasLoggedIn" to true
            editor.putBoolean("hasLoggedIn", true);

            // Commit the edits!
            editor.commit();

            Log.i("Mlog","корорче теперь фолс по идеи");
        }
    }
}