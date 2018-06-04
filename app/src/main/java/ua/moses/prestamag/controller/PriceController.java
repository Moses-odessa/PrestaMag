package ua.moses.prestamag.controller;

import java.util.ArrayList;
import java.util.List;

import ua.moses.prestamag.entity.Category;
import ua.moses.prestamag.entity.Good;

public class PriceController {
    public List<Category> getCategoriesList(int parentCategoryId){
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Category 1", 0));
        categoryList.add(new Category(2, "Category 2", 0));
        categoryList.add(new Category(3, "Category 3", 0));
        return categoryList;
    }

    public List<Good> getGoodsList(int parentCategoryId){
        List<Good> categoryList = new ArrayList<>();
        categoryList.add(new Good(1, "Good 1", 1, "", 100, ""));
        categoryList.add(new Good(2, "Good 2", 2, "", 110, ""));
        categoryList.add(new Good(3, "Good 3", 3, "", 120, ""));
        return categoryList;
    }
}
