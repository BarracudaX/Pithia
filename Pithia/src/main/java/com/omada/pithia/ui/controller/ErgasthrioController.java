package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Ergasthrio;

public class ErgasthrioController {

    private final ViewController viewController;

    private final Ergasthrio ergasthrio;

    public ErgasthrioController(ViewController viewController,Ergasthrio ergasthrio) {
        this.viewController = viewController;
        this.ergasthrio = ergasthrio;
    }

    public void requestForBackPage() {
        viewController.requestForErgasthria();
    }

    public void requestForEisagwghVathmologias() {
        viewController.requestForEisagwghVathmologiasErgasthriou(ergasthrio);
    }

    public Ergasthrio getErgasthrio() {
        return ergasthrio;
    }

    public void requestForProsthikiFoititwn() {
        viewController.requestForProsthikiFoititwnStoErgasthrio(ergasthrio, ergasthrio.getThewria());
    }

    public void requestForDiaxeirishApousiwn() {
        viewController.requestForDiaxeiristhApousiwn(ergasthrio);
    }
}
