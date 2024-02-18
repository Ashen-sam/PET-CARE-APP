package com.example.Sam_pet_care;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cleanme.R;

public class SignUp extends AppCompatActivity {
    EditText EditTextEmail,EditTextPassword,EditTextConPassword;
    Spinner SpinnerUserType;
    Button ButtonSignUp;

    private DBHelper dbHelper;

    String UserType[]={"Customer","Caregiver"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();

        EditTextEmail=(EditText) findViewById(R.id.txt_Sign_Email);
        EditTextPassword=(EditText) findViewById(R.id.txt_SignPass);
        EditTextConPassword=(EditText) findViewById(R.id.txt_SignConPass);
        ButtonSignUp=(Button) findViewById(R.id.btn_SignUp);

        SpinnerUserType=(Spinner) findViewById(R.id.sp_UserType);

        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_spinner_item,UserType);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerUserType.setAdapter(ad);

        ButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EditTextEmail.getText().toString().isEmpty() ||
                        EditTextPassword.getText().toString().isEmpty()||
                        EditTextConPassword.getText().toString().isEmpty() )
                {
                    Toast.makeText(getApplicationContext(),"Fields can't be blank",Toast.LENGTH_LONG).show();
                }
                else if (EditTextPassword.getText().toString().length()<4)
                {
                    Toast.makeText(getApplicationContext(),"Password must have more than 4 characters",Toast.LENGTH_LONG).show();
                }
                else if (!EditTextPassword.getText().toString().equals(EditTextConPassword.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(),"Password and confirm password should match.",Toast.LENGTH_LONG).show();
                }
                else
                {
                    User user=new User(EditTextEmail.getText().toString(),
                            EditTextPassword.getText().toString(),
                            SpinnerUserType.getSelectedItem().toString());
                    if (dbHelper.SignUpUser(user))
                    {
                        Toast.makeText(getApplicationContext(),"User Registered Successfully",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"User Registrations failed",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}