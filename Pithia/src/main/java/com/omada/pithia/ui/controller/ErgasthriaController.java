package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.service.ErgasthrioService;

public class ErgasthriaController {

    private final ViewController viewController;

    private final ErgasthrioService service;

    public ErgasthriaController(ViewController viewController, ErgasthrioService service) {
        this.service = service;
        this.viewController = viewController;
    }

    public void requestForBack() {
        viewController.requestForMathimataMou();
    }

    public void requestForErgasthrio(String ergasthrio) {
        viewController.requestForergathrio(service.find(ergasthrio));
    }
}
