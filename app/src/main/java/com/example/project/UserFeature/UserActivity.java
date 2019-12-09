package com.example.project.UserFeature;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project.R;

import java.util.ArrayList;


public class UserActivity extends AppCompatActivity {

    public Button addButton;
    public Button showButton;
    public EditText edit;
    public RecyclerView.LayoutManager layoutManager;
    public RecyclerView.Adapter adapter;
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setContentView(R.layout.activity_user);
        addButton=findViewById(R.id.addnote);
        showButton=findViewById(R.id.shownote);
        edit=findViewById(R.id.edit);
        //edit.setVisibility(View.INVISIBLE);
        final UserNotesDatabaseHelper user=new UserNotesDatabaseHelper(this);

        layoutManager=new LinearLayoutManager(this);
        recyclerView=findViewById(R.id.notes_recycler_view);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //edit.setVisibility(View.VISIBLE);
                String n=new String();
                n=edit.getText().toString();
                user.insertNote(n);

            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.setVisibility(View.INVISIBLE);
                ArrayList<String> note=user.getAllNotes();
                adapter=new UserNoteAdapter(note);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);

            }
        });
    }
}