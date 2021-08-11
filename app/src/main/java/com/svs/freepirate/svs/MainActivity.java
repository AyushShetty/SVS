package com.svs.freepirate.svs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("message");

        //myRef.setValue("NEW");
        myRef.child("flag").setValue(0);
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        final Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        final Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
        final Button button1 = (Button) findViewById(R.id.button);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.symptom_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);
        spinner5.setAdapter(adapter);
        button1.setEnabled(false);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                myRef.setValue("New2");
                // Do something in response to button click
                myRef.child("flag").setValue(1);
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                String spinner1val = spinner1.getItemAtPosition(i).toString();
                if(spinner1val=="")
                {button1.setEnabled(false);}
                else    button1.setEnabled(true);
                myRef.child("Symptom1").setValue(spinner1val);
            }
            public void onNothingSelected(
                    AdapterView<?> adapterView) {
                button1.setEnabled(false);
            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                String spinner2val = spinner2.getItemAtPosition(i).toString();
                if(spinner2val=="")
                {button1.setEnabled(false);}
                else    button1.setEnabled(true);
                myRef.child("Symptom2").setValue(spinner2val);
                //button1.setEnabled(true);
            }
            public void onNothingSelected(
                    AdapterView<?> adapterView) {
                button1.setEnabled(false);
            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                final String spinner3val = spinner3.getItemAtPosition(i).toString();
                if(spinner3val=="")
                {button1.setEnabled(false);}
                else    button1.setEnabled(true);
                myRef.child("Symptom3").setValue(spinner3val);
                //button1.setEnabled(true);
            }
            public void onNothingSelected(
                    AdapterView<?> adapterView) {
                button1.setEnabled(false);
            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                String spinner4val = spinner4.getItemAtPosition(i).toString();
                if(spinner4val=="")
                {button1.setEnabled(false);}
                else    button1.setEnabled(true);
                myRef.child("Symptom4").setValue(spinner4val);
                //button1.setEnabled(true);
            }
            public void onNothingSelected(
                    AdapterView<?> adapterView) {
                button1.setEnabled(false);
            }
        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(
                    AdapterView<?> adapterView, View view,
                    int i, long l) {
                String spinner5val = spinner5.getItemAtPosition(i).toString();
                if(spinner5val=="")
                {button1.setEnabled(false);}
                else    button1.setEnabled(true);
                myRef.child("Symptom5").setValue(spinner5val);//button1.setEnabled(true);
            }
            public void onNothingSelected(
                    AdapterView<?> adapterView) {
                button1.setEnabled(false);
            }
        });
    }
}
