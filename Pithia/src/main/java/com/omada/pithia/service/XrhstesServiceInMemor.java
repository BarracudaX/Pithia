package com.omada.pithia.service;

import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.model.xrhstes.Kathigitis;
import com.omada.pithia.model.xrhstes.Rolos;
import com.omada.pithia.model.xrhstes.Xrhsths;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XrhstesServiceInMemor implements XrhstesService {

    private final Map<String,Xrhsths> xrhstes = new ConcurrentHashMap<>();

    public XrhstesServiceInMemor() {

    }

    @Override
    public Xrhsths find(String onomaXrhsth) {
        return xrhstes.get(onomaXrhsth);
    }

    @Override
    public List<Xrhsths> getAll() {
        return new ArrayList<>(xrhstes.values());
    }

    @Override
    public void add(Xrhsths xrhsths) {
        xrhstes.putIfAbsent(xrhsths.getOnomaXrhsth(), xrhsths);
    }

    @Override
    public void update(Xrhsths xrhsths) {
        xrhstes.replace(xrhsths.getOnomaXrhsth(), xrhsths);
    }

    @Override
    public void remove(Xrhsths xrhsths) {
        xrhstes.remove(xrhsths.getOnomaXrhsth());
    }

    @Override
    public boolean canLogin(String onomaXrhsth, String password) {
        Xrhsths xrhsths = xrhstes.get(onomaXrhsth);

        return xrhsths != null && xrhsths.getKwdikos().equals(password);
    }

    @Override
    public List<Foititis> getFoitites() {
        List<Foititis> foitites = new ArrayList<>();

        for (Xrhsths xrhsths : xrhstes.values()) {
            if (xrhsths.hasRole(Rolos.FOITITIS)) {
                foitites.add((Foititis)xrhsths);
            }
        }

        return foitites;
    }

    @Override
    public List<Kathigitis> getKathigites() {
        List<Kathigitis> kathigitis = new ArrayList<>();

        for (Xrhsths xrhsths : xrhstes.values()) {
            if (xrhsths.hasRole(Rolos.KATHIGITIS)) {
                kathigitis.add((Kathigitis) xrhsths);
            }
        }

        return kathigitis;
    }


}
