package com.ammaryasser.inspiredemo.components;


import com.ammaryasser.inspiredemo.modules.GithubServiceModule;
import com.ammaryasser.inspiredemo.modules.PicassoModule;
import com.ammaryasser.inspiredemo.scopes.GithubApplicationScope;
import com.ammaryasser.inspiredemo.services.GithubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

@GithubApplicationScope
@Component(modules = {GithubServiceModule.class, PicassoModule.class})
public interface GithubApplicationComponent {

    Picasso getPicasso();

    GithubService getGithubService();

}
