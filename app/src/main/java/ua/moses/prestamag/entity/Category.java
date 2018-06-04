package ua.moses.prestamag.entity;

public class Category {
    int id;
    String name;
    int parentId;

    public Category(int id, String name, int parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
