package ua.moses.prestamag.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Product {
    private int id;
    private List<LocalizedTitle> name;
    private double price;
    @SerializedName("id_default_image")
    private int idDefaultImage;

    public Product(int id, List<LocalizedTitle> name, double price, int idDefaultImage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.idDefaultImage = idDefaultImage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name.get(0).getValue();
    }

    public double getPrice() {
        return price;
    }

    public String getDefaultFotoLink() { //todo The full list is: "cart_default", "home_default", "large_default", "medium_default", "small_default", "thickbox_default"
        return "http://homey.in.ua/api/images/products/" + id + "/" + idDefaultImage + "/cart_default";
    }
}
