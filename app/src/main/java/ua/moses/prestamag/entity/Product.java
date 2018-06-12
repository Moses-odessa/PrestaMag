package ua.moses.prestamag.entity;

import java.util.List;

public class Product {
    private int id;
    private List<LocalizedTitle> name;
    private double price;
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
}
