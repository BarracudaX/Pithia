package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Foititis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EisagwghVathmologiasThewriasController {

    private final ViewController viewController;

    private final Thewria thewria;

    public EisagwghVathmologiasThewriasController(ViewController viewController, Thewria thewria) {
        this.viewController = viewController;
        this.thewria = thewria;
    }

    public void requestForBackPage() {
        viewController.requestForThewria(thewria);
    }

    public Set<Foititis> getFoitites() {
        return thewria.getFoitites();
    }

    public double getCurrentVathmoThewrias(Foititis foititis) {
        return thewria.getVathmoThewrias(foititis).get();
    }
}
