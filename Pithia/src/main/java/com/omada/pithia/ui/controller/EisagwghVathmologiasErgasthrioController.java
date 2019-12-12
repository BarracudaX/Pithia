package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.xrhstes.Foititis;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class EisagwghVathmologiasErgasthrioController {

    private final ViewController viewController;

    private final Ergasthrio ergasthrio;

    public EisagwghVathmologiasErgasthrioController(ViewController viewController, Ergasthrio ergasthrio) {
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
        viewController.requestForergathrio(ergasthrio);
    }
}
