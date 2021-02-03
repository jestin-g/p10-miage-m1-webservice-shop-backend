package com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@XmlRootElement
public class Category {
    private int id;
    private boolean isMain;
    private String label;
    private List<Category> subCategories;

    public Category() {
    }

    public Category(int id, boolean isMain, String label, List<Category> subCategories) {
        this.id = id;
        this.isMain = isMain;
        this.label = label;
        this.subCategories = subCategories;
    }

    public int getId() {
        return id;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(label, category.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }
}
