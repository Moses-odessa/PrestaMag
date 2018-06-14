package ua.moses.prestamag.controller;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.moses.prestamag.entity.Category;
import ua.moses.prestamag.entity.Product;
import ua.moses.prestamag.view.ViewsManager;

public class DataController {
    private PrestashopClient client;
    private ViewsManager viewsManager;

    public DataController(ViewsManager viewsManager) {
        this.viewsManager = viewsManager;
        this.client =  new PrestashopClient(viewsManager.getContext());
    }

    public void updateCategoriesList(final int parentCategoryId) {
        Call<Map<String, List<Category>>> call = client.getService().listCategories(parentCategoryId);
        call.enqueue(new Callback<Map<String, List<Category>>>() {
            @Override
            public void onResponse(@NonNull Call<Map<String, List<Category>>> call, @NonNull Response<Map<String, List<Category>>> response) {
                final List<Category> categoriesList = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null && response.body().size() > 0) {
                    categoriesList.addAll(response.body().get("categories"));
                }
                if (parentCategoryId != 0) {
                    Call<Map<String, List<Category>>> callParent = client.getService().categoryById(parentCategoryId);
                    Map<String, List<Category>> body;
                    callParent.enqueue(new Callback<Map<String, List<Category>>>() {
                        @Override
                        public void onResponse(Call<Map<String, List<Category>>> call, Response<Map<String, List<Category>>> response) {
                            Category category;
                            if (response.body() != null && response.body().size() > 0) {
                                category = response.body().get("categories").get(0);
                                category.setName("...");
                                category.setId(category.getIdParent());
                                categoriesList.add(0, category);
                            }
                            viewsManager.updateCategories(categoriesList);
                        }

                        @Override
                        public void onFailure(Call<Map<String, List<Category>>> call, Throwable t) {

                        }
                    });

                } else {
                    viewsManager.updateCategories(categoriesList);
                }
            }

            @SuppressLint("ShowToast")
            @Override
            public void onFailure(@NonNull Call<Map<String, List<Category>>> call, @NonNull Throwable t) {
                Toast.makeText(viewsManager.getContext(), "Connection error!!!\n" + t.getMessage(), Toast.LENGTH_LONG);
                //viewsManager.updateCategories(categoriesList);
            }
        });

    }

    public void updateGoodsList(int parentCategoryId) {
        Call<Map<String, List<Product>>> call = client.getService().listProducts(parentCategoryId);
        call.enqueue(new Callback<Map<String, List<Product>>>() {
            @Override
            public void onResponse(@NonNull Call<Map<String, List<Product>>> call, @NonNull Response<Map<String, List<Product>>> response) {
                final List<Product> productsList = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null && response.body().size() > 0) {
                    productsList.addAll(response.body().get("products"));
                }
                viewsManager.updateProducts(productsList, client.getOkHttpClient());
            }

            @SuppressLint("ShowToast")
            @Override
            public void onFailure(@NonNull Call<Map<String, List<Product>>> call, @NonNull Throwable t) {
                Toast.makeText(viewsManager.getContext(), "Connection error!!!\n" + t.getMessage(), Toast.LENGTH_LONG);
                //viewsManager.updateCategories(categoriesList);
            }
        });
    }

    public void update(int parentCategoryId) {
        updateCategoriesList(parentCategoryId);
        updateGoodsList(parentCategoryId);
    }
}
