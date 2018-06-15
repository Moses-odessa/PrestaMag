package ua.moses.prestamag.controller;

import android.content.Context;

import java.io.File;

import okhttp3.Cache;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrestashopClient {
    public static final String BASE_URL = "http://homey.in.ua/api/";
    private final String SECURITY_KEY = "CM67C92UKYFPE2U7837YH4HGDBV78FBH";
    private OkHttpClient okHttpClient;
    private Retrofit retrofit;
    private final int CACHE_SIZE = 50;

    public PrestashopClient(Context context) {
        File httpCacheDirectory = new File(context.getCacheDir(), ".responsesCache");
        int cacheSize = CACHE_SIZE * 1024 * 1024; // 10 MB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        this.okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .authenticator((route, response) -> {
                    String credential = Credentials.basic(SECURITY_KEY, "");
                    return response.request().newBuilder()
                            .header("Authorization", credential)
                            .build();
                })
                .build();

        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(this.okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public PrestashopService getService() {
        return retrofit.create(PrestashopService.class);
    }
}
