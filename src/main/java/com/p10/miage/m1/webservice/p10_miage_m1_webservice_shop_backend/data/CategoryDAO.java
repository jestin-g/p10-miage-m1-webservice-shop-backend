package com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.data;

import com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.models.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryDAO {

    private static CategoryDAO instance;

    private static List<Category> categories = new ArrayList<>();

    static {
        categories.add(new Category(1, false, "PC Portable", null));
        categories.add(new Category(2, false, "PC de Bureau", null));
        categories.add(new Category(3, false, "Accessoires", null));
        categories.add(new Category(4, true, "Ordinateurs", Arrays.asList(categories.get(0), categories.get(1), categories.get(2))));

        categories.add(new Category(5, false, "Smart Phone", null));
        categories.add(new Category(6, false, "Tel fixe", null));
        categories.add(new Category(7, false, "Accessoires", null));
        categories.add(new Category(8, true, "Téléphonies", Arrays.asList(categories.get(4), categories.get(5), categories.get(6))));

        categories.add(new Category(9, false, "Disque dur", null));
        categories.add(new Category(10, false, "Clé USB", null));
        categories.add(new Category(11, false, "Accessoires", null));
        categories.add(new Category(12, true, "Téléphonies", Arrays.asList(categories.get(8), categories.get(9), categories.get(10))));
    }

    private CategoryDAO() {
    }

    public static CategoryDAO getInstance() {
        if (instance == null)
            instance = new CategoryDAO();
        return instance;
    }

    public List<Category> all() {
        return categories;
    }

    public List<Category> allOrganized() {
        return this.all()
                .stream()
                .filter(Category::isMain)
                .collect(Collectors.toList());
    }

    public Optional<Category> get(int id) {
        Category category = categories.get(id);
        return Optional.ofNullable(category);
    }

}
