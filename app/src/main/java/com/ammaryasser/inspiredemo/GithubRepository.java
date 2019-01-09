package com.ammaryasser.inspiredemo;

import com.ammaryasser.inspiredemo.services.GithubService;

import java.util.ArrayList;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import io.reactivex.BackpressureStrategy;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class GithubRepository {
    GithubService githubService;

    @Inject
    public GithubRepository(GithubService githubService) {
        this.githubService = githubService;
    }

    public LiveData<ArrayList<RepositoryModel>> getAllRepository() {
        return LiveDataReactiveStreams.fromPublisher(githubService.getRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.computation())
                .doOnNext(list -> {
                    Timber.e(list.toString());
                })
                .doOnError(Timber::e)
                .toFlowable(BackpressureStrategy.BUFFER));
//        ArrayList<RepositoryModel> repositoryModels = new ArrayList<>();
//        repositoryModels.add(new RepositoryModel("name", "name", "https://placehold.it/10x10"));
//        MutableLiveData<ArrayList<RepositoryModel>> arrayListMutableLiveData = new MutableLiveData<>();
//        arrayListMutableLiveData.postValue(repositoryModels);
//        return arrayListMutableLiveData;
    }
}
