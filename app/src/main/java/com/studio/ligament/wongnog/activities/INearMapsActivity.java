package com.studio.ligament.wongnog.activities;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.studio.ligament.wongnog.R;
import com.studio.ligament.wongnog.utils.DisplayUtils;

import butterknife.Bind;

public class INearMapsActivity extends BaseActivity implements OnMapReadyCallback {

//    @Bind(R.id.toolbar_map)
//    Toolbar toolbar;

    private GoogleMap mMap;
    Marker mMarker;
    LocationManager lm;
    double lat, lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inear_maps);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_map);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        setupActionBar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    LocationListener listener = new LocationListener() {
        public void onLocationChanged(Location loc) {
            LatLng coordinate = new LatLng(loc.getLatitude()
                    , loc.getLongitude());
            lat = loc.getLatitude();
            lng = loc.getLongitude();

            if(mMarker != null)
                mMarker.remove();

            mMarker = mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    coordinate, 16));
        }

        public void onStatusChanged(String provider, int status
                , Bundle extras) {}
        public void onProviderEnabled(String provider) {}
        public void onProviderDisabled(String provider) {}
    };

    public void onResume() {
        super.onResume();

        lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        boolean isNetwork = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        boolean isGPS = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);

        if(isNetwork) {
            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 10, listener);
            Location loc = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if(loc != null) {
                lat = loc.getLatitude();
                lng = loc.getLongitude();
            }
        }

        if(isGPS) {
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, listener);
            Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if(loc != null) {
                lat = loc.getLatitude();
                lng = loc.getLongitude();
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng you = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(you).title("You"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(you));

        mMap.addMarker(new MarkerOptions().position(
                new LatLng(16.746269, 100.202677))
                .title("ก๋วยเตี๋ยวนำชัยประตู4")
                .snippet("เมนูแนะนำ: เส้นใหญ่เย็นตาโฟ"));
        mMap.addMarker(new MarkerOptions().position(
                new LatLng(16.746578, 100.203215))
                .title("ครัวปิยะวรรณ")
                .snippet("เมนูแนะนำ: กระเพราไข่เยี่ยวม้า"));
        mMap.addMarker(new MarkerOptions().position(
                new LatLng(16.746560, 100.203532))
                .title("ถุงนม")
                .snippet("เมนูแนะนำ: ปังเย็น"));
        mMap.addMarker(new MarkerOptions().position(
                new LatLng(16.746560, 100.203532))
                .title("ต๋องแจ๋วฮ้อน 99")
                .snippet("เมนูแนะนำ: แจ๋วฮ้อนี"));
        mMap.addMarker(new MarkerOptions().position(
                new LatLng(16.747112, 100.204406))
                .title("ป้ากรไก่อบโค้ก")
                .snippet("เมนูแนะนำ: ข้าวไก่อบโค้ก - ข้าวแจ่วเอ็นไก่"));
        mMap.addMarker(new MarkerOptions().position(
                new LatLng(16.747112, 100.204406))
                .title("ร้านก๋วยเตี๋ยวพี่นก")
                .snippet("เมนูแนะนำ: ข้าวลาบ - ก๋วยเตี๋ยวแซบแห้ง"));
        mMap.addMarker(new MarkerOptions().position(
                new LatLng(16.747112, 100.204406))
                .title("ร้านข้าวผัด")
                .snippet("เมนูแนะนำ: กระเพราหมูกรอบ"));
        mMap.addMarker(new MarkerOptions().position(
                new LatLng(16.753477, 100.196417))
                .title("ร้านป้าอาจ")
                .snippet("เมนูแนะนำ: กระะเพราหมูสับ"));
        mMap.addMarker(new MarkerOptions().position(
                new LatLng(16.753431, 100.196143))
                .title("ร้านลุงเชฟ ไข่เจียวลอยฟ้า")
                .snippet("เมนูแนะนำ: ไข่เจียวขยี"));
        mMap.addMarker(new MarkerOptions().position(
                new LatLng(16.753547, 100.196226))
                .title("ร้านลูกชิ้นนายฮุย")
                .snippet("เมนูแนะนำ: ก๋วยเตี๋ยวไข่"));
        mMap.addMarker(new MarkerOptions().position(
                new LatLng(16.753519, 100.196196))
                .title("ร้านแชมป์")
                .snippet("เมนูแนะนำ: น้ำตกเนื่อเปื่อย"));
        mMap.addMarker(new MarkerOptions().position(
                new LatLng(16.753314, 100.196067))
                .title("สถานีรสแจ่ม")
                .snippet("เมนูแนะนำ: ผัดไทยไข่เจียวกุ้งสด"));
    }

    public void onPause() {
        super.onPause();
        lm.removeUpdates(listener);
    }
}
