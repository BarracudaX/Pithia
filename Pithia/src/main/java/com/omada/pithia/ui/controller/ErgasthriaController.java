package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.xrhstes.Kathigitis;
import com.omada.pithia.service.ErgasthriaService;
import com.omada.pithia.service.XrhstesService;

import java.util.ArrayList;
import java.util.List;

public class ErgasthriaController {

    private final ViewController viewController;

    private final ErgasthriaService ergasthriaService;
    private final XrhstesService xrhstesService;


    public ErgasthriaController(ViewController viewController, ErgasthriaService ergasthriaService, XrhstesService xrhstesService) {
        this.ergasthriaService = ergasthriaService;
        this.xrhstesService = xrhstesService;
        this.viewController = viewController;
    }

    public void requestForBack() {
        viewController.requestForMathimataKathigitiView();
    }

    public void requestForErgasthrio(String ergasthrio) {
        viewController.requestForErgasthrioView(ergasthriaService.find(ergasthrio));
    }

    public List<Ergasthrio> getErgasthria() {
        return new ArrayList<>( ((Kathigitis) xrhstesService.getLoginXrhsth()).getErgasthria() );
    }

}
