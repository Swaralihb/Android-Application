package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.Hospital.DatabaseAccess;
import com.example.project.Hospital.MainAdapter;
import com.example.project.MedicalStore.DatabaseAccessM;

import java.util.ArrayList;

public class SkipActivity extends AppCompatActivity {

    //Basic widgets

    public Button Hbutton;
    public Button Mbutton;
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {            //Will be created once the app is launched
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip);

       Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Start Hospital code
        Hbutton = findViewById(R.id.Hbutton);
        Mbutton = findViewById(R.id.Mbutton);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);

        final Spinner spinner = (Spinner) findViewById(R.id.hospSpinner);
        spinner.bringToFront();
        final ArrayAdapter<CharSequence> adaptersp = ArrayAdapter.createFromResource(this, R.array.Area, android.R.layout.simple_spinner_dropdown_item);

        adaptersp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptersp);

        final int[] check = {0};

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            //if any of the item is selected
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner.setSelection(i, false);
                if (++check[0] > 1) {

                    //cases for each selection
                    switch (i) {
                        case 1:
                            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                            databaseAccess.open();

                            ArrayList<String> dispAll = databaseAccess.getData("Kothrud");
                            ArrayList<String> contAll = databaseAccess.getContact();
                            ArrayList<String> locAll = databaseAccess.getLocation();

                            RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);
                            break;
                        case 2:
                            databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                            databaseAccess.open();
                            dispAll = databaseAccess.getData("KasbaPeth");
                            contAll = databaseAccess.getContact();
                            locAll = databaseAccess.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);
                            break;
                        case 3:
                            databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                            databaseAccess.open();
                            dispAll = databaseAccess.getData("Shivajinagar");
                            contAll = databaseAccess.getContact();
                            locAll = databaseAccess.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);


                            break;

                        case 4:
                            databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                            databaseAccess.open();
                            dispAll = databaseAccess.getData("VadgaonSheri");
                            contAll = databaseAccess.getContact();
                            locAll = databaseAccess.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;
                        case 5:
                            databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                            databaseAccess.open();
                            dispAll = databaseAccess.getData("PuneCantonment");
                            contAll = databaseAccess.getContact();
                            locAll = databaseAccess.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;
                        case 6:
                            databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
                            databaseAccess.open();
                            dispAll = databaseAccess.getData("Parvati");
                            contAll = databaseAccess.getContact();
                            locAll = databaseAccess.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        //Start Medical code

        final Spinner medspinner = (Spinner) findViewById(R.id.medSpinner);
        medspinner.bringToFront();
        final ArrayAdapter<CharSequence> adaptermed = ArrayAdapter.createFromResource(this, R.array.AreaMed, android.R.layout.simple_spinner_dropdown_item);

        adaptersp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medspinner.setAdapter(adaptermed);

        final int[] checkm = {0};

        medspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            //if any of the items is selected
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                medspinner.setSelection(i, false);
                if (++checkm[0] > 1) {

                    switch (i) {
                        case 1:

                            DatabaseAccessM databaseAccessM = DatabaseAccessM.getInstance(getApplicationContext());
                            databaseAccessM.open();

                            ArrayList<String> dispAll = databaseAccessM.getData("Kothrud");
                            ArrayList<String> contAll = databaseAccessM.getContact();
                            ArrayList<String> locAll = databaseAccessM.getLocation();
                            RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;
                        case 2:
                            databaseAccessM = DatabaseAccessM.getInstance(getApplicationContext());
                            databaseAccessM.open();
                            dispAll = databaseAccessM.getData("KasbaPeth");
                            contAll = databaseAccessM.getContact();
                            locAll = databaseAccessM.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);
                            break;
                        case 3:
                            databaseAccessM = DatabaseAccessM.getInstance(getApplicationContext());
                            databaseAccessM.open();
                            dispAll = databaseAccessM.getData("Shivajinagar");
                            contAll = databaseAccessM.getContact();
                            locAll = databaseAccessM.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;

                        case 4:
                            databaseAccessM = DatabaseAccessM.getInstance(getApplicationContext());
                            databaseAccessM.open();
                            dispAll = databaseAccessM.getData("VadgaonSheri");
                            contAll = databaseAccessM.getContact();
                            locAll = databaseAccessM.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;
                        case 5:
                            databaseAccessM = DatabaseAccessM.getInstance(getApplicationContext());
                            databaseAccessM.open();
                            dispAll = databaseAccessM.getData("PuneCantonment");
                            contAll = databaseAccessM.getContact();
                            locAll = databaseAccessM.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;
                        case 6:
                            databaseAccessM = DatabaseAccessM.getInstance(getApplicationContext());
                            databaseAccessM.open();
                            dispAll = databaseAccessM.getData("Parvati");
                            contAll = databaseAccessM.getContact();
                            locAll = databaseAccessM.getLocation();
                            //RecyclerView.Adapter adapter;
                            adapter = new MainAdapter(dispAll, contAll, locAll);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);

                            break;

                    }
                }
            }

            //if nothing is selected
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


    }
}
