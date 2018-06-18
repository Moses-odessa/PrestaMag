package ua.moses.prestamag.entity;

class IdAttributeEntity {
    private int id;
    private int id_product_attribute;

    public IdAttributeEntity(int id, int id_product_attribute) {
        this.id = id;
        this.id_product_attribute = id_product_attribute;
    }

    public int getId() {
        return id;
    }

    public int getId_product_attribute() {
        return id_product_attribute;
    }
}
