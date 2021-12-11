package com.example.kvantproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class reg extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText password;
    private Button login;

    //число для подсчета попыток
    int numberOfRemainingLoginAttempts = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);

        username = findViewById(R.id.edit_user);
        password = findViewById(R.id.edit_password);
        Button login = findViewById(R.id.button_login);

        login.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        // Если введенные логин и пароль будут словом "admin",
        // показываем Toast сообщение об успешном входе:
        if (username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Вы успешно вошли", Toast.LENGTH_SHORT).show();
            // Выполняем переход на другой экран:
            Intent intent = new Intent(reg.this, MainActivity.class);
            startActivity(intent);
        }
        // В другом случае выдаем сообщение с ошибкой
        else {
            Toast.makeText(getApplicationContext(), "Неправильные данные", Toast.LENGTH_SHORT).show();
            numberOfRemainingLoginAttempts--;

            }
    }
}