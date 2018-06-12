package ua.moses.prestamag.controller;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ua.moses.prestamag.entity.Category;
import ua.moses.prestamag.entity.Good;

public interface PrestashopService {
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://homey.in.ua/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    @Headers("authorization: Basic Q002N0M5MlVLWUZQRTJVNzgzN1lINEhHREJWNzhGQkg6")
    @GET("categories/?output_format=JSON&display=[id,name,id_parent]")
    Call<Map<String,List<Category>>> listCategories(@Query("filter[id_parent]") int... filter);

    @Headers("authorization: Basic Q002N0M5MlVLWUZQRTJVNzgzN1lINEhHREJWNzhGQkg6")
    @GET("categories/?output_format=JSON&display=[id,name,id_parent]")
    Call<Map<String,List<Category>>> categoryById(@Query("filter[id]") int... filter);

    @GET("products/?display=[id,name,price,id_default_image]&filter[id_category_default]=[{id}]")
    Call<List<Good>> listGoods(@Path("id") int parentCategoryId);
}
