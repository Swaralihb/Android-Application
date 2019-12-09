package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterationForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {        //Will be created once the app is launched
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupform);                    //Setting up of a layout file
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Basic widgets
        Button register =(Button)findViewById(R.id.register);
        EditText name=(EditText)findViewById(R.id.name);
        EditText username=(EditText)findViewById(R.id.username);
        EditText mail=(EditText)findViewById(R.id.mail);
        EditText password=(EditText)findViewById(R.id.password);
        EditText confirmpassword=(EditText)findViewById(R.id.confirmpassword);

        name.getText();
        username.getText();
        mail.getText();
        password.getText();
        confirmpassword.getText();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {            //Click of register button

                Intent i = new Intent(RegisterationForm.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
