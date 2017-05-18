package com.studio.ligament.wongnog.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.studio.ligament.wongnog.R;
import com.studio.ligament.wongnog.data.models.Recipe;
import com.studio.ligament.wongnog.view.adapters.UserRecipeListAdapter;
import com.studio.ligament.wongnog.view.components.DividerItemDecoration;

public class UserRecipeListFragment extends Fragment {

    @Bind(R.id.scroll)
    RecyclerView userRecipeListView;

    private UserRecipeListAdapter userRecipeListAdapter;

    public static Fragment newInstance() {
        UserRecipeListFragment fragment = new UserRecipeListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_recipe_list, container, false);
        ButterKnife.bind(this, view);
        setupViews();
        return view;
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    private void setupViews() {
        userRecipeListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        userRecipeListView.setHasFixedSize(false);
        userRecipeListAdapter = new UserRecipeListAdapter(Recipe.dummies());
        userRecipeListView.addItemDecoration(new DividerItemDecoration(getActivity()));
        userRecipeListView.setAdapter(userRecipeListAdapter);
    }
}
