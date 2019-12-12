package com.omada.pithia.service;

import java.util.List;

public interface Service<T,K> {

    T find(K key);

    List<T> getAll();

    void add(T t);

    void update(T t);

    void remove(T t);
}
