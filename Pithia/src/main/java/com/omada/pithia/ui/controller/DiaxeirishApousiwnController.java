package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Apousia;
import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.xrhstes.Foititis;

import java.util.Set;

public class DiaxeirishApousiwnController {

    private final ViewController viewController;
    private final Ergasthrio ergasthrio;

    public DiaxeirishApousiwnController(ViewController viewController, Ergasthrio ergasthrio) {
        this.viewController = viewController;
        this.ergasthrio = ergasthrio;
    }

    public Set<Foititis> getFoitites() {
        return ergasthrio.getFoitites();
    }

    public Apousia getArithmoApousiwn(Foititis foititis) {
        return ergasthrio.getApousiesFoititi(foititis).get();
    }

    public void requestForBackPage() {
        viewController.requestForErgasthrioView(ergasthrio);
    }
}
