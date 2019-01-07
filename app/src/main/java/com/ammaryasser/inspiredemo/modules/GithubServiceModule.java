package com.ammaryasser.inspiredemo.modules;

import com.ammaryasser.inspiredemo.scopes.GithubApplicationScope;
import com.ammaryasser.inspiredemo.services.GithubService;
import com.ammaryasser.inspiredemo.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkModule.class)
public class GithubServiceModule {

    @Provides
    @GithubApplicationScope
    public GithubService getGithubService(Retrofit githubRetrofit) {
        return githubRetrofit.create(GithubService.class);
    }

    @Provides
    @GithubApplicationScope
    public Gson providesGson() {
        return new GsonBuilder()
                //. register adapter time adapter
                .create();
    }

    @Provides
    @GithubApplicationScope
    public Retrofit getRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl(Constants.GITHUB_BASE_URL)
                .build();
    }

}
