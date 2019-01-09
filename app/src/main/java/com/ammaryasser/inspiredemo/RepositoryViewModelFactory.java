package com.ammaryasser.inspiredemo;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

public class RepositoryViewModelFactory implements ViewModelProvider.Factory {

    private GithubRepository githubRepository;

    @Inject
    public RepositoryViewModelFactory(GithubRepository githubRepository) {
        this.githubRepository = githubRepository;
    }

    @NonNull
    @Override
    public RepositoryViewModel create(@NonNull Class modelClass) {
        return new RepositoryViewModel(githubRepository);
    }
}
