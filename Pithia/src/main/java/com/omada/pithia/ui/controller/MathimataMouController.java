package com.omada.pithia.ui.controller;

public class MathimataMouController {
    private final ViewSwitchController viewSwitchController;

    public MathimataMouController(ViewSwitchController viewSwitchController) {
        this.viewSwitchController = viewSwitchController;
    }

    public void requestForThewries() {
        viewSwitchController.requestForThewries();
    }

    public void requestForErgasthria() {
        viewSwitchController.requestForErgasthria();
    }
}
