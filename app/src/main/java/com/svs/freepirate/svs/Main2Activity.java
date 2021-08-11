package com.svs.freepirate.svs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final EditText editText1 = (EditText)findViewById(R.id.editText1);
        final EditText editText2 = (EditText)findViewById(R.id.editText2);
        final EditText editText3 = (EditText)findViewById(R.id.editText3);
        final Button button2 = (Button) findViewById(R.id.button2);
        //editText1.setText("Google is your friend.", TextView.BufferType.EDITABLE);

        myRef.child("disease").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                editText1.setText(value, TextView.BufferType.EDITABLE);
                editText1.setEnabled(false);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
                editText1.setText( "Failed to read value.", TextView.BufferType.EDITABLE);
                editText1.setEnabled(false);
            }
        });
        myRef.child("prob").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Double value1 =   dataSnapshot.getValue(Double.class);
                String value = value1.toString();
                editText2.setText(value);
                editText2.setEnabled(false);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
                editText2.setText( "Failed to read value.", TextView.BufferType.EDITABLE);
                editText1.setEnabled(false);
            }
        });
        myRef.child("cure").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                editText3.setText(value, TextView.BufferType.EDITABLE);
                editText3.setEnabled(false);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
                editText3.setText( "Failed to read value.", TextView.BufferType.EDITABLE);
                editText3.setEnabled(false);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                myRef.setValue("New2");
                // Do something in response to button click
               // myRef.child("flag").setValue(1);
                startActivity(new Intent(Main2Activity.this, MapsActivity.class));

            }
        });
    }
}
