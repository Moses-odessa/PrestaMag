package ua.moses.prestamag.controller;


import android.content.Context;

import java.io.File;
import java.util.List;
import java.util.Map;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import ua.moses.prestamag.entity.Category;
import ua.moses.prestamag.entity.Product;

public interface PrestashopService {

    static Retrofit retrofit(Context context) {
        File httpCacheDirectory = new File(context.getCacheDir(), ".responsesCache");
        int cacheSize = 10 * 1024 * 1024; // 10 MB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();

        return new Retrofit.Builder()
                .baseUrl("http://homey.in.ua/api/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Headers("authorization: Basic Q002N0M5MlVLWUZQRTJVNzgzN1lINEhHREJWNzhGQkg6")
    @GET("categories/?output_format=JSON&display=[id,name,id_parent]")
    Call<Map<String, List<Category>>> listCategories(@Query("filter[id_parent]") int... filter);

    @Headers("authorization: Basic Q002N0M5MlVLWUZQRTJVNzgzN1lINEhHREJWNzhGQkg6")
    @GET("categories/?output_format=JSON&display=[id,name,id_parent]")
    Call<Map<String, List<Category>>> categoryById(@Query("filter[id]") int... filter);

    @Headers("authorization: Basic Q002N0M5MlVLWUZQRTJVNzgzN1lINEhHREJWNzhGQkg6")
    @GET("products/?output_format=JSON&display=[id,name,price,id_default_image]")
    Call<Map<String, List<Product>>> listProducts(@Query("filter[id_category_default]") int... filter);
}
