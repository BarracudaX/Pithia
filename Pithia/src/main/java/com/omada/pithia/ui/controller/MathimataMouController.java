package com.omada.pithia.ui.controller;

public class MathimataMouController {
    private final ViewController viewController;

    public MathimataMouController(ViewController viewController) {
        this.viewController = viewController;
    }

    public void requestForThewries() {
        viewController.requestForThewries();
    }

    public void requestForErgasthria() {
        viewController.requestForErgasthria();
    }
}
