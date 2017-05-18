package com.studio.ligament.wongnog.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.etsy.android.grid.StaggeredGridView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.google.firebase.auth.FirebaseAuth;
import com.studio.ligament.wongnog.R;
import com.studio.ligament.wongnog.data.models.Channel;
import com.studio.ligament.wongnog.data.models.UserFirebase;
import com.studio.ligament.wongnog.data.services.ChannelService;
import com.studio.ligament.wongnog.data.services.SuggestionService;
import com.studio.ligament.wongnog.view.adapters.RecipeListAdapter;
import com.studio.ligament.wongnog.view.components.DrawerHeaderView;
import com.studio.ligament.wongnog.view.components.SearchView;
import rx.Subscription;
import rx.android.app.AppObservable;
import rx.subscriptions.Subscriptions;

public class MainActivity extends BaseActivity {

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.search_view)
    SearchView searchView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.channel_recipe_list)
    StaggeredGridView recipeListView;

    private RecipeListAdapter recipeListAdapter;
    private Subscription channelsSubscription = Subscriptions.empty();
    private Subscription querySubscription = Subscriptions.empty();
    private Subscription suggestionsSubscription = Subscriptions.empty();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupViews();
        setupActionBar();
    }

    @Override
    protected void onDestroy() {
        channelsSubscription.unsubscribe();
        querySubscription.unsubscribe();
        suggestionsSubscription.unsubscribe();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_settings:
//                return true;
//            case R.id.action_logout:
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(this, SignInActivity.class));
//                finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
//
//        return super.onOptionsItemSelected(item);
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
    }

    private void setupViews() {
        navigationView.addHeaderView(new DrawerHeaderView(this));

        channelsSubscription = AppObservable.bindActivity(this, new ChannelService().getList())
                .subscribe(this::setupViews);
        querySubscription = AppObservable.bindActivity(this, searchView.observe())
                .subscribe(this::updateSuggestions);

        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                finish();
                return true;
            } else if (id == R.id.navigation_near) {
                startActivity(new Intent(MainActivity.this, INearMapsActivity.class));
                finish();
                return true;
            } else if (id == R.id.navigation_signout) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this, SignInActivity.class));
                finish();
                return true;
            }
            return false;
        });
    }

    private void updateSuggestions(String query) {
        suggestionsSubscription.unsubscribe();
        suggestionsSubscription = AppObservable.bindActivity(this, new SuggestionService().get(query))
                .subscribe(searchView::updateSuggestions);
    }

    private void setupViews(List<Channel> channels) {
        LayoutInflater layoutInflater = getLayoutInflater();

        View header = layoutInflater.inflate(R.layout.list_header_channel_recipe, null);
        recipeListView.addHeaderView(header);

        recipeListAdapter = new RecipeListAdapter(this, channels.get(0).recipes());
        recipeListView.setAdapter(recipeListAdapter);
    }
}
