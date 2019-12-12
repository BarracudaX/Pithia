package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Kathigitis;
import com.omada.pithia.service.ThewriesService;
import com.omada.pithia.service.XrhstesService;

import java.util.ArrayList;
import java.util.List;

public class ThewriesController {

    private final ViewController viewController;

    private final ThewriesService thewriesService;
    private final XrhstesService xrhstesService;

    public ThewriesController(ViewController viewController, ThewriesService thewriesService, XrhstesService xrhstesService) {
        this.viewController = viewController;
        this.thewriesService = thewriesService;
        this.xrhstesService = xrhstesService;
    }

    public void requestForBack() {
        viewController.requestForMathimataMou();
    }


    public void requestForThewria(String onomaThewrias) {
        viewController.requestForThewria(thewriesService.find(onomaThewrias));
    }

    public List<Thewria> getThewries() {
        return new ArrayList<>(((Kathigitis) xrhstesService.getLoginXrhsth()).getThewries());
    }
}
