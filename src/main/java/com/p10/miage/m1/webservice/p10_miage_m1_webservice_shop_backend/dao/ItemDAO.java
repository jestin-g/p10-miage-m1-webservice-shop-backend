package com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.dao;

import com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.model.Item;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class ItemDAO implements DAO<Item> {

    private static AtomicInteger idCounter = new AtomicInteger();
    private static Map<Integer, Item> data = new HashMap<>();

    public ItemDAO() {
    }

    @Override
    public Map<Integer, Item> all() {
        return data;
    }

    @Override
    public Optional<Item> get(int id) {
        Item rtr = data.get(id);
        return Optional.ofNullable(rtr);
    }

    @Override
    public int save(Item obj) {
        int newId = idCounter.getAndIncrement();
        data.put(newId, obj);
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
