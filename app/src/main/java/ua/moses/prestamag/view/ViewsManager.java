package ua.moses.prestamag.view;

import android.content.Context;
import android.widget.ListView;

import java.util.List;

import okhttp3.OkHttpClient;
import ua.moses.prestamag.entity.Category;
import ua.moses.prestamag.entity.Product;

public class ViewsManager {
    private Context context;
    private ListView listCategories;
    private ListView listGoods;

    public ViewsManager(Context context, ListView listCategories, ListView listGoods) {
        this.context = context;
        this.listCategories = listCategories;
        this.listGoods = listGoods;

    }

    public void updateProducts(List<Product> goodsList, OkHttpClient okHttpClient){
        listGoods.setAdapter(new ProductsAdapter(goodsList, context, okHttpClient));
    }

    public void updateCategories(List<Category> categoriesList) {
        listCategories.setAdapter(new CategoriesAdapter(categoriesList, context));
    }


    public Context getContext() {
        return context;
    }
}
