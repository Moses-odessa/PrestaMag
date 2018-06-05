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
        categoryList.add(new Good(1, "Good 1", 100, ""));
        categoryList.add(new Good(2, "Good 2", 200, ""));
        categoryList.add(new Good(3, "Good 3", 300, ""));
        categoryList.add(new Good(4, "Good 11", 100, ""));
        categoryList.add(new Good(5, "Good 21", 200, ""));
        categoryList.add(new Good(6, "Good 31", 300, ""));
        categoryList.add(new Good(7, "Good 12", 100, ""));
        categoryList.add(new Good(8, "Good 22", 200, ""));
        categoryList.add(new Good(9, "Good 32", 300, ""));
        categoryList.add(new Good(10, "Good 13", 100, ""));
        categoryList.add(new Good(11, "Good 23", 200, ""));
        categoryList.add(new Good(12, "Good 33", 300, ""));
        categoryList.add(new Good(13, "Good 1", 100, ""));
        categoryList.add(new Good(14, "Good 2", 200, ""));
        categoryList.add(new Good(15, "Good 3", 300, ""));
        categoryList.add(new Good(16, "Good 11", 100, ""));
        categoryList.add(new Good(17, "Good 21", 200, ""));
        categoryList.add(new Good(18, "Good 31", 300, ""));
        categoryList.add(new Good(19, "Good 12", 100, ""));
        categoryList.add(new Good(20, "Good 22", 200, ""));
        categoryList.add(new Good(21, "Good 32", 300, ""));
        categoryList.add(new Good(22, "Good 13", 100, ""));
        categoryList.add(new Good(23, "Good 23", 200, ""));
        categoryList.add(new Good(24, "Good 33", 300, ""));
        return categoryList;
    }
}
