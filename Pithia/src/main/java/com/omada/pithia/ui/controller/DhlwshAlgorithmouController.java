package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Thewria;

public class DhlwshAlgorithmouController {
    private final ViewController viewController;
    private final Thewria thewria;

    public DhlwshAlgorithmouController(ViewController viewController, Thewria thewria) {
        this.viewController = viewController;
        this.thewria = thewria;
    }
    public void changeAlgo(Thewria){thewria.saveAlgorythmo(double x,double y);}
}
