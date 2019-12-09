package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class RatingFragment extends AppCompatActivity {
    public RatingBar ratingBar;
    public TextView txtRatingValue;
    public TextView submit;
    public Button submitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);
        submit=(TextView)findViewById(R.id.submitview);
        submit.setVisibility(View.INVISIBLE);
        submitbtn=(Button)findViewById(R.id.submit);
        final ArrayList<String>Ratings;
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                txtRatingValue.setText("Your rating for app is:" +rating+"\nYour feedback is Valuable for us !! ");
            }
        });
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit.setVisibility(View.VISIBLE);
                submit.setText("Submitted");
            }
        });
    }
}
