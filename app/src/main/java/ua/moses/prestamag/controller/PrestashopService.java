package ua.moses.prestamag.controller;


import android.content.Context;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.moses.prestamag.entity.Category;
import ua.moses.prestamag.entity.Product;

public interface PrestashopService {

    @GET("categories/?output_format=JSON&display=[id,name,id_parent]")
    Call<Map<String, List<Category>>> listCategories(@Query("filter[id_parent]") int... filter);

    @GET("categories/?output_format=JSON&display=[id,name,id_parent]")
    Call<Map<String, List<Category>>> categoryById(@Query("filter[id]") int... filter);

    @GET("products/?output_format=JSON&display=[id,name,price,id_default_image]")
    Call<Map<String, List<Product>>> listProducts(@Query("filter[id_category_default]") int... filter);
}
