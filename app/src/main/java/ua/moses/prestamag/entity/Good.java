package ua.moses.prestamag.entity;

public class Good {
    private int id;
    private String name;
    private double price;
    private int idDefaultImage;

    public Good(int id, String name, double price, int idDefaultImage) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.idDefaultImage = idDefaultImage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
