package com.omada.pithia.ui.controller;

import com.omada.pithia.service.ErgasthrioService;
import com.omada.pithia.service.ThewriesService;

public class ProsthikiMathimatosController {

    private final ViewController viewController;

    public ProsthikiMathimatosController(ViewController viewController) {
        this.viewController = viewController;
    }

    public void requestForProsthikiErgasthriou() {
        viewController.requestForProsthikiErgasthriou();
    }

    public void requestForProsthikiThewrias() {
        viewController.requestForProsthikiThewrias();
    }

    public void requestForBackPage(){
        viewController.requestForHomePage();
    }
}
