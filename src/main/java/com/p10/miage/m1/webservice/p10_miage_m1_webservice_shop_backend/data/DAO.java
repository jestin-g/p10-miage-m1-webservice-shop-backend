package com.p10.miage.m1.webservice.p10_miage_m1_webservice_shop_backend.data;

import java.util.Map;
import java.util.Optional;

public interface DAO<T> {
    Map<Integer, T> all();
    Optional<T> get(int id);
    int save(T obj);
    boolean update(int id, T newObj);
    boolean delete(int id);
}
