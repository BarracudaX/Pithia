package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Foititis;

import java.util.Map;
import java.util.Set;

public class EisagwghVathmologiasThewriasController {

    private final ViewController viewController;

    private final Thewria thewria;

    public EisagwghVathmologiasThewriasController(ViewController viewController, Thewria thewria) {
        this.viewController = viewController;
        this.thewria = thewria;
    }

    public void requestForBackPage() {
        viewController.requestForThewriaView(thewria);
    }

    public Set<Foititis> getFoitites() {
        return thewria.getFoitites();
    }

    public double getCurrentVathmoThewrias(Foititis foititis) {
        return thewria.getVathmoThewrias(foititis).get();
    }

    public void requestForApothikeushVathmwn(Map<Foititis, Double> vathmoi) {
        for (Map.Entry<Foititis, Double> vathmos : vathmoi.entrySet()) {
            thewria.addVathmoThewrias(vathmos.getValue(), vathmos.getKey());
        }
        viewController.requestForShowMessage("Οι βαθμοι αποθηκευτηκαν με επιτυχια.");
        viewController.requestForThewriaView(thewria);
    }

    public String getMessage(String code, Object[] args) {
        return viewController.getMessage(code, args);
    }
}
