package com.example.prattoy.student;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Double newlat=null;
    private Double newlng=null;
    public Double la;
    public Double lt;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference reference = database.getReference("location");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String latitu = dataSnapshot.child("0").getValue().toString();
                    String longitu= dataSnapshot.child("1").getValue().toString();
                    la = Double.parseDouble(latitu);
                    lt = Double.parseDouble(longitu);

                    if (newlat != la || newlng !=lt){
                        if (marker == null){
                            getmap();
                        }
                        else{
                            marker.remove();
                            getmap();
                        }

                    }
                    newlat = la;
                    newlng = lt;

        }
        private void getmap(){
            LatLng bus1 = new LatLng(la, lt);
            marker = mMap.addMarker(new MarkerOptions().position(bus1).title("Bus 1"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(bus1));
            CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(la,lt)).zoom(17).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
    });
    }
}