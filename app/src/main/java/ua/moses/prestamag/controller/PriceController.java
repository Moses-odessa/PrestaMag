package ua.moses.prestamag.controller;

import java.util.ArrayList;
import java.util.List;

import ua.moses.prestamag.entity.Category;

public class PriceController {
    public List<Category> getCategoriesList(int parentCategoryId){
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Category 1", 0));
        categoryList.add(new Category(2, "Category 2", 0));
        categoryList.add(new Category(3, "Category 3", 0));
        return categoryList;
    }
}
