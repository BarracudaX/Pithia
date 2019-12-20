package com.omada.pithia.ui.controller;

public class MathimataKathigitiController {
    
    private final ViewController viewController;

    public MathimataKathigitiController(ViewController viewController) {
        this.viewController = viewController;
    }

    public void requestForThewries() {
        viewController.requestForThewriesView();
    }

    public void requestForErgasthria() {
        viewController.requestForErgasthriaView();
    }
}
