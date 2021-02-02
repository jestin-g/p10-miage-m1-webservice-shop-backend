package com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Category {
    private String label;

    public Category() {
    }

    public Category(String label) {
        this.label = label;
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
}
