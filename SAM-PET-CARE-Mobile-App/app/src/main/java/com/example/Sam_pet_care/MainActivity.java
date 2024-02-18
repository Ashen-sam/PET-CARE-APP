package com.example.Sam_pet_care;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cleanme.R;


public class MainActivity extends AppCompatActivity {
Button ButtonCallLogin, ButtonCallRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ButtonCallLogin=(Button) findViewById(R.id.btnCallLogin);
       ButtonCallRegister=(Button) findViewById(R.id.btnCallRegister);

       ButtonCallLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intentLogin=new Intent(MainActivity.this,LoginActivity1.class);
               startActivity(intentLogin);
           }
       });

       ButtonCallRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intentSign=new Intent(MainActivity.this,SignUp.class);
               startActivity(intentSign);
           }
       });
    }
}