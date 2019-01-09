package com.ammaryasser.inspiredemo.modules;

import android.content.Context;

import com.ammaryasser.inspiredemo.GithubRepository;
import com.ammaryasser.inspiredemo.MainActivity;
import com.ammaryasser.inspiredemo.RepositoryViewModelFactory;
import com.ammaryasser.inspiredemo.scopes.MainActivityScope;
import com.ammaryasser.inspiredemo.services.GithubService;

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

    @Provides
    @MainActivityScope
    public RepositoryViewModelFactory providesFactory(GithubRepository githubRepository) {
        return new RepositoryViewModelFactory(githubRepository);
    }

    @Provides
    @MainActivityScope
    public GithubRepository providesRepository(GithubService githubService) {
        return new GithubRepository(githubService);
    }
}
