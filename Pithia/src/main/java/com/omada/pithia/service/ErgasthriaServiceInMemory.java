package com.omada.pithia.service;

import com.omada.pithia.model.mathimata.Ergasthrio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ErgasthriaServiceInMemory implements ErgasthriaService {

    private final Map<String, Ergasthrio> ergasthria = new ConcurrentHashMap<>();

    public ErgasthriaServiceInMemory(){

    }

    @Override
    public Ergasthrio find(String onomaErgasthriou) {
        return ergasthria.get(onomaErgasthriou);
    }

    @Override
    public List<Ergasthrio> getAll() {
        return new ArrayList<>(ergasthria.values());
    }

    @Override
    public void add(Ergasthrio ergasthrio) {
        ergasthria.putIfAbsent(ergasthrio.getOnomaErgasthriou(), ergasthrio);
    }

    @Override
    public void update(Ergasthrio ergasthrio) {
        ergasthria.replace(ergasthrio.getOnomaErgasthriou(), ergasthrio);
    }

    @Override
    public void remove(Ergasthrio ergasthrio) {
        ergasthria.remove(ergasthrio.getOnomaErgasthriou());
    }
}
