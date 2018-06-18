package ua.moses.prestamag.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class ProductDetails {
    private int id;
    private List<LocalizedTitle> name;
    private double price;
    @SerializedName("id_default_image")
    private int idDefaultImage;
    @SerializedName("manufacturer_name")
    private String manufacturerName;
    private List<LocalizedTitle> description;
    private Association associations;

    public ProductDetails(int id, List<LocalizedTitle> name, double price, int idDefaultImage, String manufacturerName, List<LocalizedTitle> description, Association associations) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.idDefaultImage = idDefaultImage;
        this.manufacturerName = manufacturerName;
        this.description = description;
        this.associations = associations;
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

    public String getManufacturerName() {
        return manufacturerName;
    }

    public Association getAssociations() {
        return associations;
    }
}
