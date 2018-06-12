package ua.moses.prestamag.view;

import android.content.Context;
import android.widget.ListView;

import java.util.List;

import ua.moses.prestamag.entity.Category;
import ua.moses.prestamag.entity.Good;

public class ViewsManager {
    private Context context;
    private ListView listCategories;
    private ListView listGoods;

    public ViewsManager(Context context, ListView listCategories, ListView listGoods) {
        this.context = context;
        this.listCategories = listCategories;
        this.listGoods = listGoods;

    }

    public void updateGoods(List<Good> goodsList){
        listGoods.setAdapter(new GoodsAdapter(goodsList, context));
    }

    public void updateCategories(List<Category> categoriesList) {
        listCategories.setAdapter(new CategoriesAdapter(categoriesList, context));
    }


    public Context getContext() {
        return context;
    }
}
