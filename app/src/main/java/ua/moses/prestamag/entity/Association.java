package ua.moses.prestamag.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Association {
    List<IdEntity> categories;
    List<IdEntity> images;
    List<IdEntity> combinations;
    @SerializedName("product_option_values")
    List<IdEntity> productOptionValues;
    @SerializedName("stock_availables")
    List<IdAttributeEntity> stockAvailables;

    public Association(List<IdEntity> categories, List<IdEntity> images, List<IdEntity> combinations, List<IdEntity> productOptionValues, List<IdAttributeEntity> stockAvailables) {
        this.categories = categories;
        this.images = images;
        this.combinations = combinations;
        this.productOptionValues = productOptionValues;
        this.stockAvailables = stockAvailables;
    }

    public List<IdEntity> getCategories() {
        return categories;
    }

    public List<IdEntity> getImages() {
        return images;
    }

    public List<IdEntity> getCombinations() {
        return combinations;
    }

    public List<IdEntity> getProductOptionValues() {
        return productOptionValues;
    }

    public List<IdAttributeEntity> getStockAvailables() {
        return stockAvailables;
    }
}
