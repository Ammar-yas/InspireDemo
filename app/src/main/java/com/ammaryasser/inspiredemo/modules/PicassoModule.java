package com.ammaryasser.inspiredemo.modules;

import android.content.Context;

import com.ammaryasser.inspiredemo.scopes.GithubApplicationScope;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module(includes = {ContextModule.class, NetworkModule.class})
public class PicassoModule {

    @Provides
    @GithubApplicationScope
    public Picasso providesPicasso(Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    @GithubApplicationScope
    public OkHttp3Downloader providesOkhttpDownloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }

}
