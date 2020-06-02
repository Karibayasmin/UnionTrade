package com.elegantwizardry.uniontrade;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyClickListener {

    private RecyclerView recyclerView;
    private HomePageAdapter homePageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.homepage_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        HomePageViewModel homePageViewModel = ViewModelProviders.of(this).get(HomePageViewModel.class);
        homePageViewModel.homePageReport();

        homePageViewModel.getHomePageMutableLiveData().observe(this, homePage -> {
            if(homePage != null && homePage.getReportList() != null){
                homePageAdapter = new HomePageAdapter(this, homePage.getReportList(), this);
                recyclerView.setAdapter(homePageAdapter);
                Log.d("issue","Working...");
            }

        });

         homePageViewModel.getErrorResponse().observe(this, errorResponse -> {
             Log.d("issue","NotWorking...");
             if (errorResponse != null) {
                 Toast.makeText(this, "Error: " + errorResponse, Toast.LENGTH_LONG).show();
             }
        });
    }

    @Override
    public void myOnClick(HomePage.Report report) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("key_data", report);
        startActivity(intent);
    }
}