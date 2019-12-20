package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Foititis;

import java.util.Collection;
import java.util.List;

public class ProsthikiFoititwnStoErgasthrioController {

    private final ViewController viewController;

    private final Thewria thewria;

    private final Ergasthrio ergasthrio;

    public ProsthikiFoititwnStoErgasthrioController(ViewController viewController, Thewria thewria, Ergasthrio ergasthrio) {
        this.viewController = viewController;
        this.thewria = thewria;
        this.ergasthrio = ergasthrio;
    }


    public void requestForBackPage() {
        viewController.requestForErgasthrioView(ergasthrio);
    }

    public Collection<Foititis> getFoititesXwrisErgasthrio() {
        return thewria.getFoititesXwrisErgasthrio();
    }

    public void requestForProsthikiFoititwnStoErgasthrio(List<Foititis> foitites) {
        StringBuilder builder = new StringBuilder("Οι φοιτητες/τριες που προστεθηκαν στο εργαστηριο : \n");
        for (Foititis foititis : foitites) {
            thewria.addFoititiStoErgasthrio(foititis, ergasthrio);
            builder.append(foititis.getOnomaXrhsth()).append(" - ").append(foititis.getEpwnhmo()).append(" ")
                    .append(foititis.getOnoma()).append("\n");
        }
        viewController.requestForShowMessage(builder.toString());
        viewController.requestForErgasthrioView(ergasthrio);
    }
}
