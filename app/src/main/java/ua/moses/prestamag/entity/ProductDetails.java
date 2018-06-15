package ua.moses.prestamag.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductDetails {
    private int id;
    private List<LocalizedTitle> name;
    private double price;
    @SerializedName("id_default_image")
    private int idDefaultImage;
    @SerializedName("manufacturer_name")
    private String manufacturerName;
    private List<LocalizedTitle> description;
    private List<Integer> images;

    public ProductDetails(int id, List<LocalizedTitle> name, double price, int idDefaultImage, List<LocalizedTitle> description, List<Integer> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.idDefaultImage = idDefaultImage;
        this.description = description;
        this.images = images;
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

    public String getDescription() {
        return description.get(0).getValue();
    }

    public List<Integer> getImages() {
        return images;
    }
}
