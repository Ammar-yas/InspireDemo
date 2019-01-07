package com.ammaryasser.inspiredemo.modules;

import android.content.Context;

import com.ammaryasser.inspiredemo.scopes.GithubApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @GithubApplicationScope
    public Context providesContext() {
        return context;
    }
}
