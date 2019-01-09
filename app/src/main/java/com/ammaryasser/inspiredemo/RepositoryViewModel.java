package com.ammaryasser.inspiredemo;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class RepositoryViewModel extends ViewModel {

    private GithubRepository githubRepository;

    public RepositoryViewModel(GithubRepository githubRepository) {
        this.githubRepository = githubRepository;
    }

    public LiveData<ArrayList<RepositoryModel>> getRepositoryList() {
        return githubRepository.getAllRepository();
    }

}
