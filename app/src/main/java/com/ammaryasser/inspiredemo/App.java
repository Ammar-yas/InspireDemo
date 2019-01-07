package com.ammaryasser.inspiredemo;

import android.app.Activity;
import android.app.Application;

import com.ammaryasser.inspiredemo.components.DaggerGithubApplicationComponent;
import com.ammaryasser.inspiredemo.components.GithubApplicationComponent;
import com.ammaryasser.inspiredemo.modules.ContextModule;

import timber.log.Timber;

public class App extends Application {

    private GithubApplicationComponent githubApplicationComponent;

    public static App get(Activity activity) {
        return (App) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        githubApplicationComponent = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }

    public GithubApplicationComponent getAppComponent() {
        return githubApplicationComponent;
    }
}
