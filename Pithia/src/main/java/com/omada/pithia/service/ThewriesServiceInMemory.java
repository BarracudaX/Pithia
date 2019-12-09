package com.omada.pithia.service;

import com.omada.pithia.model.mathimata.Thewria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThewriesServiceInMemory implements ThewriesService {

    private final Map<String, Thewria> thewries = new ConcurrentHashMap<>();

    public ThewriesServiceInMemory() {

    }

    @Override
    public Thewria find(String onomaThewrias) {
        return thewries.get(onomaThewrias);
    }

    @Override
    public List<Thewria> getAll() {
        return new ArrayList<>(thewries.values());
    }

    @Override
    public void add(Thewria thewria) {
        thewries.putIfAbsent(thewria.getOnomaMathimatos(), thewria);
    }

    @Override
    public void update(Thewria thewria) {
        thewries.replace(thewria.getOnomaMathimatos(), thewria);
    }

    @Override
    public void remove(Thewria thewria) {
        thewries.remove(thewria);
    }
}
