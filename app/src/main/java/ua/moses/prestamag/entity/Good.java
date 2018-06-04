package ua.moses.prestamag.entity;

public class Good {
    private int id;
    private String name;
    private double price;
    private String imageLink;

    public Good(int id, String name, double price, String imageLink) {
        this.id = id;
        this.name = name;
          this.price = price;
        this.imageLink = imageLink;
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
