package com.example.Sam_pet_care;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cleanme.R;

import java.util.ArrayList;

public class PostedAdsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> id, name, address, phone, nic, property, bedrooms, bathrooms, times;
    DBHelper db;
    AdsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posted_ads);

        db = new DBHelper(this);

        id = new ArrayList<>();
        name = new ArrayList<>();
        address = new ArrayList<>();
        phone = new ArrayList<>();
        nic = new ArrayList<>();
        property = new ArrayList<>();
        bedrooms = new ArrayList<>();
        bathrooms = new ArrayList<>();
        times = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);

        adapter = new AdsAdapter(this, id, name, address, phone, nic, property, bedrooms, bathrooms, times);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

        Button confirmJobButton = findViewById(R.id.confirmJobButton);
        confirmJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform any logic related to confirming the job here

                // Display a confirmation message
                showToast("Confirmed successfully");
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void displaydata() {
        Cursor cursor = db.getdata();
        if (cursor.getCount() == 0) {
            Toast.makeText(PostedAdsActivity.this, "No Data Exists", Toast.LENGTH_SHORT).show();
            return;
        } else {
            while (cursor.moveToNext()) {
                id.add(cursor.getString(0));
                name.add(cursor.getString(1));
                address.add(cursor.getString(2));
                phone.add(cursor.getString(3));
                nic.add(cursor.getString(4));
                property.add(cursor.getString(5));
                bedrooms.add(cursor.getString(6));
                bathrooms.add(cursor.getString(7));
                times.add(cursor.getString(8));
            }
        }
    }
}