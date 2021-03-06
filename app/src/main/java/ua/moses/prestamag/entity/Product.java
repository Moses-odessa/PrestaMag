package ua.moses.prestamag.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ua.moses.prestamag.controller.PrestashopClient;

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

    public int getIdDefaultImage() {
        return idDefaultImage;
    }

}
