package ua.moses.prestamag.view;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import ua.moses.prestamag.controller.PriceController;

public class ViewsManager {
    private Context context;
    private ListView listCategories;
    private ListView listGoods;
    private PriceController priceController;
    private int currentCategoryId = 0;

    public void setCurrentCategoryId(int currentCategoryId) {
        this.currentCategoryId = currentCategoryId;
    }

    public int getCurrentCategoryId() {
        return currentCategoryId;
    }

    public ViewsManager(Context context, ListView listCategories, ListView listGoods, PriceController priceController) {
        this.context = context;
        this.listCategories = listCategories;
        this.listGoods = listGoods;
        this.priceController = priceController;

    }

    public void update(){
        listCategories.setAdapter(new CategoriesAdapter(priceController.getCategoriesList(currentCategoryId), context));
    }
}
