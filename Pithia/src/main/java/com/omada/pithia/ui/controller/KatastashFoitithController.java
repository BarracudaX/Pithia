package com.omada.pithia.ui.controller;

import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.service.XrhstesService;

import java.util.Map;

public class KatastashFoitithController {

    private final ViewController viewController;

    private final XrhstesService xrhstesService;

    public KatastashFoitithController(ViewController viewController, XrhstesService xrhstesService) {
        this.viewController = viewController;
        this.xrhstesService = xrhstesService;
    }


    public Map<String, Double> getVathmous() {
        Foititis foititis = (Foititis) xrhstesService.getLoginXrhsth();

        return foititis.getVathmous();
    }

    public void requestForBackPage() {
        viewController.requestForHomeView();
    }
}
