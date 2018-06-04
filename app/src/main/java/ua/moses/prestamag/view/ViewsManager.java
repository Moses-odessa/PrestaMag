package ua.moses.prestamag.view;

import android.content.Context;
import android.widget.ListView;

import ua.moses.prestamag.controller.PriceController;

public class ViewsManager {
    private Context context;
    private ListView listGroups;
    private ListView listGoods;
    private PriceController priceController;
    private int currentGroupId = 0;

    public ViewsManager(Context context, ListView listGroups, ListView listGoods, PriceController priceController) {
        this.context = context;
        this.listGroups = listGroups;
        this.listGoods = listGoods;
        this.priceController = priceController;
    }

    public void update(){
        listGroups.setAdapter(new CategoriesAdapter(priceController.getCategoriesList(0), context));
    }
}
