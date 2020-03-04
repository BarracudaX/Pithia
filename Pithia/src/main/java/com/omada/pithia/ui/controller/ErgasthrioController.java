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
        viewController.requestForErgasthriaView();
    }

    public void requestForEisagwghVathmologias() {
        viewController.requestForEisagwghVathmologiasErgasthriouView(ergasthrio);
    }

    public Ergasthrio getErgasthrio() {
        return ergasthrio;
    }

    public void requestForProsthikiFoititwn() {
        viewController.requestForProsthikiFoititwnStoErgasthrioView(ergasthrio, ergasthrio.getThewria());
    }

    public void requestForDiaxeirishApousiwn() {
        viewController.requestForDiaxeiristhApousiwnView(ergasthrio);
    }

    public String getMessage(String code, Object[] args) {
        return viewController.getMessage(code, args);
    }
}
