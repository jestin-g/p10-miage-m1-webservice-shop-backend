package com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.data;

import com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.models.Category;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class CategoryDAO implements DAO<Category> {

    private static CategoryDAO instance;

    private static AtomicInteger idCounter = new AtomicInteger();
    private static Map<Integer, Category> data = new HashMap<>();

    static {
        data.put(idCounter.getAndIncrement(), new Category("cat1"));
        data.put(idCounter.getAndIncrement(), new Category("cat2"));
    }

    public static CategoryDAO getInstance() {
        if (instance == null)
            instance = new CategoryDAO();
        return instance;
    }

    private CategoryDAO() {
    }

    @Override
    public Map<Integer, Category> all() {
        return data;
    }

    @Override
    public Optional<Category> get(int id) {
        Category category = data.get(id);
        return Optional.ofNullable(category);
    }

    @Override
    public int save(Category category) {
        int newId = idCounter.getAndIncrement();
        data.put(newId, category);
        return newId;
    }

    @Override
    public boolean update(int id, Category newCategory) {
        Category oldCategory = data.put(id, newCategory);
        if (oldCategory != null) {
            return !oldCategory.equals(newCategory);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return data.remove(id) != null;
    }
}
