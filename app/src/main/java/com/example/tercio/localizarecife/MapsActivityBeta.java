package com.example.rodri.localizarecife;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.drawable.Icon;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivityBeta extends FragmentActivity implements OnMapReadyCallback {
    double latitude;
    double longitude;
    LatLng localizacao = new LatLng(-8.039872, -34.921929);

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_beta);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        /*LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
        setUpMap(mMap);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    private void setUpMap(GoogleMap mMap) {
        latitude = -8.045586;
        longitude = -34.886363;
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("Academia da Cidade -Santo Amaro"));

        latitude = -8.081159;
        longitude = -34.877008;
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("Academia da Cidade - Brasilia Teimosa"));

        latitude = -8.070055;
        longitude = -34.896960;
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(" ACADEMIA DA CIDADE  - Ilha de Joana Bezerra"));

        latitude = -8.046607;
        longitude = 34.913966;
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(" ACADEMIA DA CIDADE  - Torre"));

        latitude = -8.057554;
        longitude = -34.931274;
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(" ACADEMIA DA CIDADE  - Cordeiro"));

        latitude = -8.067184;
        longitude = -34.927536;
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(" ACADEMIA DA CIDADE  - San Martins"));

        latitude = -8.073626;
        longitude = -34.918611;
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(" ACADEMIA DA CIDADE - Mustardinha"));

        latitude = -8.097178;
        longitude =  -34.935891;
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(" ACADEMIA DA CIDADE - Areias "));

        latitude = -8.096810;
        longitude = -34.924750;
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(" ACADEMIA DA CIDADE xx - Areias"));

        latitude = -8.100004;
        longitude = -34.908950;
        mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title(" ACADEMIA DA CIDADE xx -Ibiribeira"));





        CameraUpdate location = CameraUpdateFactory.newLatLngZoom(localizacao, 17);
        float f = (float) 11.7;
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(f);

        mMap.moveCamera(location);
        mMap.animateCamera(zoom, 3000, null);

        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        /*final GoogleMap.OnInfoWindowClickListener infoWindow = new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Toast.makeText(this, "santo", Toast.LENGTH_SHORT).show();

            }
        }*/
    }

    public void sateliteView(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        //CameraUpdate location = CameraUpdateFactory.newLatLngZoom(localizacao, 15);
        //CameraUpdate zoom = CameraUpdateFactory.zoomTo(17);

        //mMap.moveCamera(location);
        //mMap.animateCamera(zoom, 3000, null);
    }

    public void normalView(View view) {
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        //CameraUpdate location = CameraUpdateFactory.newLatLngZoom(localizacao,15);
       // CameraUpdate zoom = CameraUpdateFactory.zoomTo(17);

       // mMap.moveCamera(location);
       // mMap.animateCamera(zoom, 3000, null);

    }



    public void locationAtual(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);

    }
}

