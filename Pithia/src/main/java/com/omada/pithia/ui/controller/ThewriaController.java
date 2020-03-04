package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Thewria;

public class ThewriaController {

    private final ViewController viewController;
    private final Thewria thewria;

    public ThewriaController(ViewController viewController, Thewria thewria) {
        this.viewController = viewController;
        this.thewria = thewria;
    }

    public void requestForBackPage() {
        viewController.requestForThewriesView();
    }

    public void requestForProsthikiProapaitoumenwn() {
        viewController.requestForProsthikiProapaitoumenwnView(thewria);
    }

    public void requestForEisagwghVathmologias() {
        viewController.requestForEisagwghVathmologiasThewriasView(thewria);
    }


    public Thewria getThewria() {
        return thewria;
    }

    public void requestDhlwshAlgorithmou() {viewController.requestForDhlwshAlgorithmouView(thewria);}

    public String getMessage(String code, Object[] args) {
        return viewController.getMessage(code, args);
    }
}
