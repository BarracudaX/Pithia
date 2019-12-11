package com.omada.pithia.ui.controller;

public class ThewriaController {

    private final ViewController viewController;

    public ThewriaController(ViewController viewController) {
        this.viewController = viewController;
    }


    public void requestForBackPage() {
        viewController.requestForThewries();
    }
}
