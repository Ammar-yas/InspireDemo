package com.ammaryasser.inspiredemo.modules;

import android.content.Context;

import com.ammaryasser.inspiredemo.scopes.GithubApplicationScope;

import java.io.File;

import androidx.annotation.NonNull;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    @GithubApplicationScope
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @GithubApplicationScope
    public HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                Timber.i(message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return httpLoggingInterceptor;
    }

    @Provides
    @GithubApplicationScope
    public Cache provideCache(File cacheFile) {
        int tenMegaBytes = 10 * 1000 * 1000;
        return new Cache(cacheFile, tenMegaBytes);
    }

    @Provides
    @GithubApplicationScope
    public File providesFile(Context context) {
        String cacheFileName = "okhttp_cache";
        return new File(context.getCacheDir(), cacheFileName);
    }

}
