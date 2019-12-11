package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Eksamhno;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Kathigitis;
import com.omada.pithia.service.ThewriesService;

import java.time.LocalDate;

public class ThewriesController {

    private final ViewController viewController;

    private final ThewriesService service;

    public ThewriesController(ViewController viewController, ThewriesService service) {
        this.viewController = viewController;
        this.service = service;
    }

    public void requestForBack() {
        viewController.requestForMathimataMou();
    }


    public void requestForThewria(String onomaThewrias) {
        viewController.requestForThewria(service.find(onomaThewrias));
    }

}
