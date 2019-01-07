package com.ammaryasser.inspiredemo.components;


import com.ammaryasser.inspiredemo.MainActivity;
import com.ammaryasser.inspiredemo.modules.HomeActivityModule;
import com.ammaryasser.inspiredemo.scopes.MainActivityScope;

import dagger.Component;

@MainActivityScope
@Component(modules = HomeActivityModule.class, dependencies = GithubApplicationComponent.class)
public interface MainActivityComponent {
    public void inject(MainActivity mainActivity);
}

