package com.omada.pithia.ui.controller;

public class ErgasthriaController {

    private final ViewSwitchController viewSwitchController;

    public ErgasthriaController(ViewSwitchController viewSwitchController) {
        this.viewSwitchController = viewSwitchController;
    }


    public void requestForErgasthrio() {
        //TODO
    }

    public void requestForBack() {
        viewSwitchController.requestForMathimataMou();
    }
}
