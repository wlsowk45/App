package com.example.hyeokjin.knumeal;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    UiSettings mapSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //restaurant 정보 MainActivity에서부터 받아


        if (mMap != null) {
            try {

                mapSettings = mMap.getUiSettings();
                mMap.setMyLocationEnabled(true);
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                mapSettings.setZoomControlsEnabled(true);


            }catch(SecurityException e){
                e.printStackTrace();
            }

        }
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
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;

        final ArrayList<Restaurant> restaurants;
        Intent intent = getIntent();
        restaurants = intent.getParcelableArrayListExtra("ToMap");

        //애니메이션 없이 LatLng로 옮김
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(
                new LatLng(35.885501,128.611328)    //쪽문 CU
        ));

        //구글맵에서 zoom level 은 1~23
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(16);
        //애니메이션 적용
        googleMap.animateCamera(zoom);

        ArrayList<MarkerOptions> markers = new ArrayList<MarkerOptions>();
        for(int i=0;i<restaurants.size();i++)
        {
            //MarkerOption에는 Position, Title, Snippet, Alpha, Icon
            MarkerOptions marker = new MarkerOptions();
            marker.position(new LatLng(restaurants.get(i).getLatitude(),restaurants.get(i).getLongitude()));
            marker.title(restaurants.get(i).getName());
            marker.snippet("snippet은 여기");
            markers.add(marker);
            googleMap.addMarker(marker).showInfoWindow();
        }


       /* mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                MarkerOptions mOptions = new MarkerOptions();
                // 마커 타이틀
                mOptions.title("마커 좌표");
                Double latitude = point.latitude;//위도
                Double longitude = point.longitude;//경도
                mOptions.snippet(latitude.toString()+","+longitude.toString());
                //latlng : 위도 경도 쌍을 나타냄
                mOptions.position(new LatLng(latitude,longitude));
                //마커(핀) 추가
                googleMap.addMarker(mOptions);
            }
        });*/

        // Add a marker in Sydney and move the camera

        /*
        LatLng seoul_station = new LatLng(37.555744, 126.970431);
        mMap.addMarker(new MarkerOptions().position(seoul_station).title("서울역"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seoul_station));
        */
    }
}