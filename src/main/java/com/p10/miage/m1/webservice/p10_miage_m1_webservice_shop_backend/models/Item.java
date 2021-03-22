package com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Item {
    private String label;
    private String brand;
    private String category;
    private double price;
    private String picture;

    public Item() {
    }

    public Item(String label, String brand, String category, double price, String picture) {
        this.label = label;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.picture = picture;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 && Objects.equals(label, item.label) && Objects.equals(brand, item.brand) && Objects.equals(picture, item.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, brand, price, picture);
    }
}
