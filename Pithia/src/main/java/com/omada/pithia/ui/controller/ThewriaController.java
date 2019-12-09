package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Thewria;

public class ThewriaController {

    private final ViewSwitchController viewSwitchController;

    public ThewriaController(ViewSwitchController viewSwitchController) {
        this.viewSwitchController = viewSwitchController;
    }


    public void requestForBackPage() {
        viewSwitchController.requestForThewries();
    }
}
