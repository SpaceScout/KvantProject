package com.example.kvantproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class oplata extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oplata);
        int balance = 100;
        int price = 25;
        Button oplatit2 = findViewById(R.id.button);
        oplatit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int balance2 = balance - price;
                }
                catch (Error error){
                    Toast error_oplata = Toast.makeText(getApplicationContext(),"Произошла ошибка", Toast.LENGTH_SHORT);
                    error_oplata.show();
                }
                finally {
                    Toast oplata = Toast.makeText(getApplicationContext(),"Прошла оплата проезда", Toast.LENGTH_SHORT);
                    oplata.show();
                }
            }
        });
    }
}
