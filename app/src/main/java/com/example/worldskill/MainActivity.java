package com.example.worldskill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

      Button button, button2;
      EditText email, password;

      RequestQueue queue;
    final String api = "https://wshk1920.herokuapp.com/api/login";

    public String getApi(String email) {
        return api;
    }

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
                openstartpage(email.getText().toString(), password.getText().toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openregisterpage();
            }
        });
        queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, api, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                MainActivity.this.email.checkInputConnectionProxy(email);
                MainActivity.this.password.checkInputConnectionProxy(password);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void openstartpage(String s, String toString) {
        if (email.equals(api.contentEquals("email")) && (password.equals(api.contentEquals("password")))) {
            Intent intent = new Intent(this, RegisterPage.class);
            startActivity(intent);
        } else {
            return;
        }
    }

    public void openregisterpage(){
        Intent intent = new Intent(this, RegisterPage.class);
        startActivity(intent);
    }

}