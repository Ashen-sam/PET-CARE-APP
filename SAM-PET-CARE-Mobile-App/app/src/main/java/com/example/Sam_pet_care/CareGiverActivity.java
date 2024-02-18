package com.example.Sam_pet_care;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cleanme.R;

public class CareGiverActivity extends AppCompatActivity {
    EditText EditTextName, EditTextAddress, EditTextReview;
    Button ButtonNewWork, ButtonAddReview, ButtonViewReviews;

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caregiver);

        dbHelper=new DBHelper(this);
        dbHelper.OpenDB();

        EditTextName=(EditText)  findViewById(R.id.txt_RevName);
        EditTextAddress=(EditText) findViewById(R.id.txt_RevAddress);
        EditTextReview=(EditText) findViewById(R.id.txt_YourReview);

        ButtonNewWork=(Button) findViewById(R.id.btn_NewWork);
        ButtonAddReview=(Button) findViewById(R.id.btn_AddReview);
        ButtonViewReviews=(Button) findViewById(R.id.btn_VeiwReview);

        ButtonNewWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CareGiverActivity.this,PostedAdsActivity.class));
            }
        });

        ButtonAddReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (EditTextName.getText().toString().isEmpty()||
                EditTextAddress.getText().toString().isEmpty()||
                EditTextReview.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Fields can't be empty",Toast.LENGTH_LONG).show();
                }
                else {
                    ClnReviews clnReviews=new ClnReviews(EditTextName.getText().toString(),
                            EditTextAddress.getText().toString(),
                            EditTextReview.getText().toString());
                    if (dbHelper.SaveCleanerReview(clnReviews))
                    {
                        Toast.makeText(getApplicationContext(),"Feedback Added Successfully",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"Feedback not Added",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        ButtonViewReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CareGiverActivity.this,AllReviewsActivity.class));
            }
        });
    }
}