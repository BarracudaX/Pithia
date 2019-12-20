package com.omada.pithia.ui.controller;

public class ProsthikiMathimatosController {

    private final ViewController viewController;

    public ProsthikiMathimatosController(ViewController viewController) {
        this.viewController = viewController;
    }

    public void requestForProsthikiErgasthriou() {
        viewController.requestForProsthikiErgasthriouView();
    }

    public void requestForProsthikiThewrias() {
        viewController.requestForProsthikiThewriasView();
    }

    public void requestForBackPage(){
        viewController.requestForHomeView();
    }
}
