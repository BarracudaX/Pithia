package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.ui.controller.ProsthikiFoititwnStoErgasthrioController;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProsthikiFoititwnStoErgasthrioView extends AbstractDoubleListView {

    private final ProsthikiFoititwnStoErgasthrioController controller;

    private final Map<String, Foititis> foititesMap = new HashMap<>();

    public ProsthikiFoititwnStoErgasthrioView(ProsthikiFoititwnStoErgasthrioController controller) {
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
        return controller.getMessage("ProsthikiFoithtwnStoErgasthrio.View.NotBelonging.Label", new Object[]{});
    }

    @Override
    public String getSecondLabelName() {
        return controller.getMessage("ProsthikiFoithtwnStoErgasthrio.View.WillBelong.Label", new Object[]{});
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

    @Override
    protected String getBackButtonText() {
        return controller.getMessage("ProsthikiFoithtwnStoErgasthrio.View.Back.Button", new Object[]{});
    }

    @Override
    protected String getAddToTheListButtonText() {
        return controller.getMessage("ProsthikiFoithtwnStoErgasthrio.View.Add.Button", new Object[]{});
    }

    @Override
    protected String getRemoveFromTheListButtonText() {
        return controller.getMessage("ProsthikiFoithtwnStoErgasthrio.View.Remove.Button", new Object[]{});
    }

    @Override
    protected String getFinishButtonText() {
        return controller.getMessage("ProsthikiFoithtwnStoErgasthrio.View.Finish.Button", new Object[]{});
    }
}
