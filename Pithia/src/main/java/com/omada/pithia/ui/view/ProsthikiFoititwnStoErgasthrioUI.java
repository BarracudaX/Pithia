package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.ui.controller.ProsthikiFoititwnStoErgasthrioController;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProsthikiFoititwnStoErgasthrioUI extends AbstractDoubleListView {

    private final ProsthikiFoititwnStoErgasthrioController controller;

    private final Map<String, Foititis> foititesMap = new HashMap<>();

    public ProsthikiFoititwnStoErgasthrioUI(ProsthikiFoititwnStoErgasthrioController controller) {
        this.controller = controller;
        prepareView();
    }


    @Override
    public void finishButtonClick(ActionEvent actionEvent) {
        List<Foititis> telikoiFoitites = new ArrayList<>();

        List<String> epiloges = new ArrayList<>();

        while (!getSecondListModel().isEmpty()) {
            epiloges.add(getSecondListModel().firstElement());
            getSecondListModel().removeElementAt(0);
        }

        for (String epilogh : epiloges) {
            telikoiFoitites.add(foititesMap.get(epilogh));
        }

        controller.requestForProsthikiFoititwnStoErgasthrio(telikoiFoitites);

    }

    @Override
    public void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }

    @Override
    public String getFirstLabelName() {
        return "Φοιτητες Που Δεν Ανηκουν Σε Κανενα Εργαστηριο";
    }

    @Override
    public String getSecondLabelName() {
        return "Φοιτητες Που Θα Προστεθουν";
    }

    @Override
    public List<String> getFirstListItems() {
        List<String> foitites = new ArrayList<>();

        for (Foititis foititis : controller.getFoititesXwrisErgasthrio()) {
            foitites.add(foititis.getOnomaXrhsth()+"("+foititis.getEpwnhmo()+" "+foititis.getOnoma()+")");
            foititesMap.put(foititis.getOnomaXrhsth() + "(" + foititis.getEpwnhmo() + " " + foititis.getOnoma() + ")", foititis);
        }

        return foitites;
    }
}
