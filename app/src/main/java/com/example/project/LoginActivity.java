package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {        //Will be created once the screen is launched
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);                //setting of layout file

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       getSupportActionBar().setTitle("Help Assistant");
        Button login=(Button)findViewById(R.id.login);
        final EditText mail=(EditText)findViewById(R.id.mail);
        final EditText password=(EditText)findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //VALIDATION:

                String validemail = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +

                        "\\@" +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +

                        "(" +

                        "\\." +

                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +

                        ")+";


                String email = mail.getText().toString();
                DatabaseAccessUser databaseAccessUser=new DatabaseAccessUser(getApplicationContext());

                Matcher matcher= Pattern.compile(validemail).matcher(email);
                int cnt=0;

                //Comparison of email address

                    if (email.isEmpty()||!matcher.matches()) {
                        mail.setError("Enter email");
                        Toast.makeText(getApplicationContext(), "Enter Valid Email-Id", Toast.LENGTH_LONG).show();
                    }

                        String passwordInput = password.getText().toString();

                    //Comparison of password
                        if (passwordInput.isEmpty() || passwordInput.length() <8 ) {
                            password.setError("password can't be empty");
                            Toast.makeText(getApplicationContext(), "Password can't be empty.", Toast.LENGTH_LONG).show();
                           // Toast.makeText(getApplicationContext(), "password too long ", Toast.LENGTH_LONG).show();
                            cnt++;

                        }

                    if(cnt==0) {
                        Boolean check=true;
                        //Boolean check=databaseAccessUser.getData(email,passwordInput);
                        if(check) {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Not a registered user? Please register",Toast.LENGTH_LONG).show();
                        }
                    }
            }
        });

    }
}
