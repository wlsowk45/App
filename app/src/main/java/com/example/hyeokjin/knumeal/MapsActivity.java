package com.example.hyeokjin.knumeal;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback,
        GoogleMap.OnMyLocationButtonClickListener {

    private boolean isGPSEnabled = false;
    private boolean isNetWorkEnabled = false;
    private GoogleMap mMap;
    private LocationManager locationManager = null;
    UiSettings mapSettings;
    TextView textView_distance, textView_time;

    double mLatitude;
    double mLongitude;
    ArrayList<Restaurant> result_restaurant = new ArrayList<Restaurant>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        textView_distance = (TextView) findViewById(R.id.textView_distance);
        textView_time = (TextView) findViewById(R.id.textView_time);

        //표시할 list 받음
        Intent intent = getIntent();
        result_restaurant = intent.getParcelableArrayListExtra("ToMap");


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    private void updateLocationUI() {
        if (mMap == null) return;

        try {
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
        }
         catch( SecurityException e1){

        Log.e("Exception %s", e1.getMessage());
    }

}

    public boolean onMyLocationButtonClick(){
        Toast.makeText(this,"MyLocation button clicked",Toast.LENGTH_SHORT).show();
        return false;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //ACCESS_COARSE_LOCATION 권한
        if(requestCode==1){
            //권한받음
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                requestMyLocation();
            }
            //권한못받음
            else{
                Toast.makeText(this, "권한없음", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    //나의 위치 요청
    public void requestMyLocation(){
        if(ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getApplicationContext(),"GPS를 받아올 수 없습니다.",Toast.LENGTH_SHORT).show();
            return;
        }
        //요청 최소시간 1000ms(1초) 최소 거리 10미
        //if(isGPSEnabled)
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
        //else if(isNetWorkEnabled)
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,1000,1,locationListener);
        //else

    }

    //위치정보 구하기 리스너
    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            if(ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                return;
            }
            //나의 위치를 한번만 가져오기 위해
            locationManager.removeUpdates(locationListener);

            if(location.getProvider().equals(LocationManager.GPS_PROVIDER)) {
                //위도 경도
                mLatitude = location.getLatitude();   //위도
                mLongitude = location.getLongitude(); //경도
                Toast.makeText(getApplicationContext(),"get by GPS",Toast.LENGTH_SHORT).show();
            }
            else {
                mLatitude = location.getLatitude();   //위도
                mLongitude = location.getLongitude(); //경도
                Toast.makeText(getApplicationContext(),"get by NETWORK",Toast.LENGTH_SHORT).show();
            }

            // 맵생성
            SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
            //콜백클래스 설정
            mapFragment.getMapAsync(MapsActivity.this);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) { Log.d("gps", "onStatusChanged"); }

        @Override
        public void onProviderEnabled(String provider) { }

        @Override
        public void onProviderDisabled(String provider) { }
    };


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    public double getDistance(LatLng LatLng1, LatLng LatLng2) {
        double distance;
        Location locationA = new Location("A");
        locationA.setLatitude(LatLng1.latitude);
        locationA.setLongitude(LatLng1.longitude);
        Location locationB = new Location("B");
        locationB.setLatitude(LatLng2.latitude);
        locationB.setLongitude(LatLng2.longitude);
        distance = locationA.distanceTo(locationB);

        return distance;
    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        double parseBefore;
        double distance; // 식당 ~ 내 위치

        LatLng myPosition = new LatLng(mLatitude,mLongitude);
        LatLng restaurant_pos = new LatLng(result_restaurant.get(0).getLatitude(),result_restaurant.get(0).getLongitude());
        LatLng ilchungdam = new LatLng(35.888605,128.612187);
        LatLng center = new LatLng(mLatitude+restaurant_pos.latitude/2,mLongitude+restaurant_pos.longitude/2);

        //Toast.makeText(getApplicationContext(),"lat = "+mLatitude+"\nlong = "+mLongitude,Toast.LENGTH_SHORT).show();
        parseBefore = getDistance(myPosition,restaurant_pos);
        distance = Double.parseDouble(String.format("%.2f",parseBefore));

        textView_distance.setText("거리 : "+distance+"m");
        textView_time.setText("시간 : "+Math.round(distance/60.0)+"분");


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        if (mMap != null) {
            try {

                mapSettings = mMap.getUiSettings();
                mMap.setMyLocationEnabled(false);
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                mapSettings.setZoomControlsEnabled(true);


            } catch (SecurityException e) {
                e.printStackTrace();
            }

        }

        //GPS 켜져있는지 체크
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            //GPS 설정 화면으
            Intent intent_GPS = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            intent_GPS.addCategory(Intent.CATEGORY_DEFAULT);
            startActivity(intent_GPS);
            finish();
        }

        /////수정중
        isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetWorkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);


        //마시멜로 이상
        if (Build.VERSION.SDK_INT >= 23) {
            //권한 없을경우
            if (ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                    ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            }
            //권한 있을경우
            else {
                requestMyLocation();
            }
        } else { //마시멜로 아래
            requestMyLocation();
        }


        updateLocationUI();



        CameraPosition cp = new CameraPosition.Builder().target(myPosition).zoom(15).build();
        //애니메이션 없이 LatLng로 옮김
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cp));
        //googleMap.moveCamera(CameraUpdateFactory.newLatLng(ilchungdam));//일청담

            //구글맵에서 zoom level 은 1~23
        //CameraUpdate zoom = CameraUpdateFactory.zoomTo(16);
            //애니메이션 적용
        //googleMap.animateCamera(zoom);

        ArrayList<MarkerOptions> markers = new ArrayList<MarkerOptions>();

        //MarkerOption에는 Position, Title, Snippet, Alpha, Icon
        MarkerOptions marker = new MarkerOptions();
        marker.position(restaurant_pos);
        marker.title(result_restaurant.get(0).getName());
        marker.snippet(result_restaurant.get(0).getLatitude()+" "+result_restaurant.get(0).getLongitude());
        markers.add(marker);
        googleMap.addMarker(marker).showInfoWindow();

    }
}