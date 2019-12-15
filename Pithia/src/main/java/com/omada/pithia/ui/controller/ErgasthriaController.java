package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.xrhstes.Kathigitis;
import com.omada.pithia.service.ErgasthrioService;
import com.omada.pithia.service.XrhstesService;

import java.util.ArrayList;
import java.util.List;

public class ErgasthriaController {

    private final ViewController viewController;

    private final ErgasthrioService ergasthrioService;
    private final XrhstesService xrhstesService;


    public ErgasthriaController(ViewController viewController, ErgasthrioService ergasthrioService, XrhstesService xrhstesService) {
        this.ergasthrioService = ergasthrioService;
        this.xrhstesService = xrhstesService;
        this.viewController = viewController;
    }

    public void requestForBack() {
        viewController.requestForMathimataMou();
    }

    public void requestForErgasthrio(String ergasthrio) {
        viewController.requestForErgasthrio(ergasthrioService.find(ergasthrio));
    }

    public List<Ergasthrio> getErgasthria() {
        return new ArrayList<>( ((Kathigitis) xrhstesService.getLoginXrhsth()).getErgasthria() );
    }

}
