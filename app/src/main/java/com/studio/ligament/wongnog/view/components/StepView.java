package com.studio.ligament.wongnog.view.components;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.studio.ligament.wongnog.R;
import com.studio.ligament.wongnog.activities.MapsActivity;
import com.studio.ligament.wongnog.data.models.Step;

public class StepView extends FrameLayout {
    @Bind(R.id.step_description_text)
    TextView stepDescriptionTextView;
    @Bind(R.id.step_image)
    ImageView stepImageView;

//    @Bind(R.id.fragment_map_container)
//    MapsActivity mapsActivity;
//
//    private GoogleMap mMap;

    public StepView(Context context, Step step) {
        super(context);
        setup(step);
    }

    private void setup(Step step) {
        inflate(getContext(), R.layout.view_step, this);
        ButterKnife.bind(this);

//        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
//        android.support.v4.app.FragmentTransaction fragmentTransaction = getLayoutTransition();
//        fragmentTransaction.add(R.id.fragment_map_container, mapFragment);
//        fragmentTransaction.commit();
//        mapFragment.getMapAsync(this);

//        FragmentManager fm = getSupportFragmentManager();
//        SupportMapFragment supportMapFragment =  SupportMapFragment.newInstance();
//        fm.beginTransaction().replace(R.id.fragment_map_container, supportMapFragment).commit();

//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);

        stepDescriptionTextView.setText(step.description());
        if (!TextUtils.isEmpty(step.imageUrl())) {
            Picasso.with(getContext())
                    .load(step.imageUrl())
                    .into(stepImageView);
            stepImageView.setVisibility(View.VISIBLE);
        }
    }
}
