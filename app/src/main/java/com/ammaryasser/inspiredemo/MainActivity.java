package com.ammaryasser.inspiredemo;

import android.os.Bundle;

import com.ammaryasser.inspiredemo.components.DaggerMainActivityComponent;
import com.ammaryasser.inspiredemo.components.MainActivityComponent;
import com.ammaryasser.inspiredemo.modules.HomeActivityModule;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Inject
    RepoAdapter repoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
                .homeActivityModule(new HomeActivityModule(this))
                .githubApplicationComponent(App.get(this).getAppComponent())
                .build();
        mainActivityComponent.inject(this);
        RecyclerView recyclerView = findViewById(R.id.repositoriesRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(repoAdapter);
        ArrayList<RepositoryModel> repositoryModels = new ArrayList<>();
        repositoryModels.add(new RepositoryModel("TEST REPO", "this is a test repository", "https://i.chzbgr.com/full/3154883328/h46B58259/"));
        repoAdapter.setRepositories(repositoryModels);
    }
}
