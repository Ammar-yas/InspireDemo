package com.ammaryasser.inspiredemo.modules;

import com.ammaryasser.inspiredemo.MainActivity;
import com.ammaryasser.inspiredemo.RepoAdapter;
import com.ammaryasser.inspiredemo.scopes.MainActivityScope;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeActivityModule {

    private final MainActivity mainActivity;

    public HomeActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public RepoAdapter providesRepositoryAdapter(Picasso picasso) {
        return new RepoAdapter(mainActivity, picasso);
    }
}
