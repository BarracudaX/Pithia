package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.xrhstes.Foititis;

import java.util.Map;
import java.util.Set;

public class EisagwghVathmologiasErgasthriouController {

    private final ViewController viewController;

    private final Ergasthrio ergasthrio;

    public EisagwghVathmologiasErgasthriouController(ViewController viewController, Ergasthrio ergasthrio) {
        this.viewController = viewController;
        this.ergasthrio = ergasthrio;
    }

    public Set<Foititis> getFoitites() {
        return ergasthrio.getFoitites();
    }

    public double getCurrentVathmoErgasthriou(Foititis foititis) {
        return ergasthrio.getVathmoErgasthriou(foititis).get();
    }

    public void requestForBackPage() {
        viewController.requestForErgasthrioView(ergasthrio);
    }

    public void requestForApothikeushVathmwn(Map<Foititis, Double> vathmoi) {
        for (Map.Entry<Foititis, Double> vathmos : vathmoi.entrySet()) {
            ergasthrio.addVathmoErgasthriou(vathmos.getKey(), vathmos.getValue());
        }
        viewController.requestForShowMessage("Οι βαθμοι αποθηκευτηκαν με επιτυχια!");
        viewController.requestForErgasthrioView(ergasthrio);
    }
}
