package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Thewria;

public class DhlwshAlgorithmouController {
    private final ViewController viewController;
    private final Thewria thewria;

    public DhlwshAlgorithmouController(ViewController viewController, Thewria thewria) {
        this.viewController = viewController;
        this.thewria = thewria;
    }
    public void saveAlgorythmo(double x,double y){
        if (x + y <= 1.0) {
            thewria.saveAlgorythmo(x, y);
            viewController.requestForShowMessage(" Το ποσοστο της θεωριας ειναι " + x + " Το ποσοστο του εργαστηριου ειναι " + y);
        }
        else{
            viewController.requestForShowErrorMessage("Το συνολο των ποσοστων ειναι μεγαλυτερο του 1.0");
        }

    }
    
    public void requestForBackPage(){
        viewController.requestForHomeView();

    }
}
