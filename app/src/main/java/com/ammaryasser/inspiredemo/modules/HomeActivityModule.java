package com.ammaryasser.inspiredemo.modules;

import android.content.Context;

import com.ammaryasser.inspiredemo.MainActivity;
import com.ammaryasser.inspiredemo.scopes.MainActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeActivityModule {

    private final MainActivity mainActivity;

    public HomeActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

//    @Provides
//    @MainActivityScope
//    public RepoAdapter providesRepositoryAdapter(Picasso picasso) {
//        return new RepoAdapter(mainActivity, picasso);
//    }

    @Provides
    @MainActivityScope
    public Context providesActivityContext() {
        return mainActivity;
    }
}
