package com.omada.pithia.ui.controller;

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
