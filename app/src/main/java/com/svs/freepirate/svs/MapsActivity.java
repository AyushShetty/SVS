package com.svs.freepirate.svs;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
     public static Double lat    =   19.042447;
     public static Double lon    =   73.025014;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        myRef.child("longitude").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                lon = dataSnapshot.getValue(Double.class);
                String text ="Longitude:-"+lon;
                Toast.makeText(MapsActivity.this,text ,Toast.LENGTH_SHORT).show();
                newfunction1(mMap);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());

            }
        });
        myRef.child("latitude").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                lat =   dataSnapshot.getValue(Double.class);
                String text ="Latitude:-"+lat;
                Toast.makeText(MapsActivity.this,text ,Toast.LENGTH_SHORT).show();
                newfunction1(mMap);
                //String value = value1.toString();
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    //@Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //delay();
        String text =lat+" , "+lon;
        Toast.makeText(MapsActivity.this,text ,Toast.LENGTH_LONG).show();
        // Add a marker in Sydney and move the camera
        //while(true) {
            LatLng host = new LatLng(lat, lon);
            //mMap.addMarker(new MarkerOptions().position(host).title("Hospital2 with available Treatment found here!"));
            //mMap.moveCamera(CameraUpdateFactory.newLatLng(host));
           // newfunction1(mMap);
        //}
    }
    public void newfunction1(GoogleMap googleMap) {
        mMap = googleMap;
        String text =lat+" , "+lon;
        Toast.makeText(MapsActivity.this,text ,Toast.LENGTH_LONG).show();
        // Add a marker in Sydney and move the camera
        //while(true) {
        LatLng host = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(host).title("Hospital1 with available Treatment found here!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(host));

        //}
    }
}
