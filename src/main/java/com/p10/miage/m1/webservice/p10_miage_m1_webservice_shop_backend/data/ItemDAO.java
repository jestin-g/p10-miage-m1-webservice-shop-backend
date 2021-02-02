package com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.data;

import com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.models.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ItemDAO implements DAO<Item> {

    private static ItemDAO instance;

    private static AtomicInteger idCounter = new AtomicInteger();
    private static Map<Integer, Item> data = new HashMap<>();

    static {
        data.put(idCounter.getAndIncrement(), new Item("label1", "brand1", 100, "pic1"));
        data.put(idCounter.getAndIncrement(), new Item("label2", "brand2", 200, "pic2"));
    }

    private ItemDAO() {
    }

    public static ItemDAO getInstance() {
        if (instance == null)
            instance = new ItemDAO();
        return instance;
    }

    @Override
    public Map<Integer, Item> all() {
        return data;
    }

    @Override
    public Optional<Item> get(int id) {
        Item item = data.get(id);
        return Optional.ofNullable(item);
    }

    @Override
    public int save(Item item) {
        int newId = idCounter.getAndIncrement();
        data.put(newId, item);
        return newId;
    }

    @Override
    public boolean update(int id, Item newItem) {
        Item oldItem = data.put(id, newItem);
        if (oldItem != null) {
            return !oldItem.equals(newItem);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return data.remove(id) != null;
    }
}
