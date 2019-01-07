package com.ammaryasser.inspiredemo.services;

import com.ammaryasser.inspiredemo.RepositoryModel;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GithubService {
    @GET("repositories")
    public Observable<ArrayList<RepositoryModel>> getRepositories();
}
