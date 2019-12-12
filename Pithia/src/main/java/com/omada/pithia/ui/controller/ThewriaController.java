package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.service.ThewriesService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThewriaController {

    private final ViewController viewController;
    private final Thewria thewria;

    public ThewriaController(ViewController viewController, Thewria thewria) {
        this.viewController = viewController;
        this.thewria = thewria;
    }

    public void requestForBackPage() {
        viewController.requestForThewries();
    }

    public void requestForProsthikiProapaitoumenwn() {
        viewController.requestForProsthikiProapaitoumenwn(thewria);
    }

    public void requestForEisagwghVathmologias() {
        viewController.requestForEisagwghVathmologiasThewrias(thewria);
    }


    public Thewria getThewria() {
        return thewria;
    }

}
