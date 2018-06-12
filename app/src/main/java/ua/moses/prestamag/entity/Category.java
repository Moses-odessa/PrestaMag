package ua.moses.prestamag.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {
    private int id;
    @SerializedName("id_parent")
    private int idParent;
    private List<LocalizedTitle> name;

    public Category(int id, int idParent, List<LocalizedTitle> name) {
        this.id = id;
        this.idParent = idParent;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //todo made getName and setName by lang id
    public String getName() {
        return name.get(0).getValue();
    }

    public void setName(String name) {
        this.name.get(0).setValue(name);
    }

    public int getIdParent() {
        return idParent;
    }
}
