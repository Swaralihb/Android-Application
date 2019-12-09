package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;

public class DisplayRecycler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(DisplayRecycler.this,MainActivity.class);
        startActivity(intent);
    }
}
