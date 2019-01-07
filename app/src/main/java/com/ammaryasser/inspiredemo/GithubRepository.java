package com.ammaryasser.inspiredemo;

import com.ammaryasser.inspiredemo.services.GithubService;

import javax.inject.Inject;

public class GithubRepository {
    GithubService githubService;

    @Inject
    public GithubRepository(GithubService githubService) {
        this.githubService = githubService;
    }

    public void getAllRepository() {
//        githubService.getRepositories()
//                .observeOn(AndroidSchedulers.mainThread())
//                .unsubscribeOn(Schedulers.computation())
//                .subscribe((ArrayList<RepositoryModel> repositoryModels) -> );

    }
}
