package com.example.worldskill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {

      Button button, button2;
      EditText email, password;

      RequestQueue queue;
    final String api = "https://reqres.in/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openstartpage();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openregisterpage();
            }
        });

    }
    public void openstartpage(){
        Intent intent = new Intent(this, StartPage.class);
        startActivity(intent);
    }
    public void openregisterpage(){
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }

}