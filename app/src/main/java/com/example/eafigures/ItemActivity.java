package com.example.eafigures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        String Type=getIntent().getStringExtra("Type");


        Toast.makeText(this, ""+Type, Toast.LENGTH_SHORT).show();
    }
}