package com.studio.ligament.wongnog.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.studio.ligament.wongnog.R;
import com.studio.ligament.wongnog.data.models.Model;
import com.studio.ligament.wongnog.data.models.User;
import com.studio.ligament.wongnog.data.models.UserFirebase;
import com.studio.ligament.wongnog.view.Transition;
import com.studio.ligament.wongnog.view.components.UserProfileHeaderView;
import com.studio.ligament.wongnog.view.fragments.UserRecipeListFragment;

public class UserProfileActivity extends BaseActivity {
    private static final String EXTRA_USER = "user";

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.user_profile_header)
    UserProfileHeaderView userProfileHeaderView;
//    @Bind(R.id.view_pager)
//    ViewPager viewPager;
//    @Bind(R.id.pager_tabs)
//    TabLayout tabLayout;

    public static void launch(Activity activity, User user, Transition transition) {
        Intent intent = new Intent(activity, UserProfileActivity.class);
        intent.putExtra(EXTRA_USER, user.toJson());
        Transition.putTransition(intent, transition);
        activity.startActivity(intent);
        transition.overrideOpenTransition(activity);
    }

    @Override
    public void finish() {
        super.finish();
        Transition.getTransition(getIntent()).overrideCloseTransition(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);
        User user = Model.fromJson(getIntent().getStringExtra(EXTRA_USER), User.class);

        UserFirebase userFirebase = Model.fromJson(getIntent().getStringExtra(EXTRA_USER), UserFirebase.class);

        setupActionBar();
//        setupViewPager();
        setupViews(userFirebase);
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    private void setupViewPager() {
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(UserRecipeListFragment.newInstance(), "Tab 1");
        pagerAdapter.addFragment(UserRecipeListFragment.newInstance(), "Tab 2");
//        viewPager.setAdapter(pagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViews(User user) {
        userProfileHeaderView.setUser(user);
    }
    private void setupViews(UserFirebase userFirebase) {
        userProfileHeaderView.setUser(userFirebase);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private static class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragments = new ArrayList<>();
        private final List<String> titles = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            titles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
