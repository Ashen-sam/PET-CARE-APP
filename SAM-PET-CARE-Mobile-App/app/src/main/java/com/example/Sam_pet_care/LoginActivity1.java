package com.example.Sam_pet_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cleanme.R;

import java.util.ArrayList;

public class LoginActivity1 extends AppCompatActivity {
    EditText EditTextEmail1,EditTextPassword1;
    Button ButtonLogin1;

    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);

        db=new DBHelper(this);
        db.OpenDB();

        EditTextEmail1=(EditText) findViewById(R.id.txt_L1_Email);
        EditTextPassword1=(EditText) findViewById(R.id.txt_L1_Password);
        ButtonLogin1=(Button)findViewById(R.id.btnLogin1);

        ButtonLogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<User> userDetails=db.ValidLogin(EditTextEmail1.getText().toString(),EditTextPassword1.getText().toString());

                if (userDetails.size()!=0)
                {
                    User user = userDetails.get(0);
                    String UserType = user.getUserType();

                    Toast.makeText(getApplicationContext(), "User Logged Successfully " + UserType, Toast.LENGTH_LONG).show();

                    if (UserType.equals("Customer")) {
                        startActivity(new Intent(LoginActivity1.this,CustomerActivity2.class));
                    }
                    else
                    {
                        startActivity(new Intent(LoginActivity1.this, CareGiverActivity.class));
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid User",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}