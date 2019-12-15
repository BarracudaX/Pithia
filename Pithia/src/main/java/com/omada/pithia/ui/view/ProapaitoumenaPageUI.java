package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.service.ThewriesService;
import com.omada.pithia.ui.controller.ProapaitoumenaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ProapaitoumenaPageUI extends AbstractDoubleListView {

    private final ProapaitoumenaController controller;

    private final Map<String, Thewria> proapaitoumenaMap = new HashMap<>();

    public ProapaitoumenaPageUI(ProapaitoumenaController controller) {
        this.controller = controller;
        prepareView();
    }

    public void finishButtonClick(ActionEvent actionEvent) {
        List<Thewria> telikaProapaitoumena = new ArrayList<>();

        List<String> epiloges = new ArrayList<>();

        while (!getSecondListModel().isEmpty()) {
            epiloges.add(getSecondListModel().firstElement());
            getSecondListModel().removeElementAt(0);
        }

        for (String epilogh : epiloges) {
            telikaProapaitoumena.add(proapaitoumenaMap.get(epilogh));
        }

        controller.requestForProsthikiProapaitoumenwn(telikaProapaitoumena);
    }

    public void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }

    @Override
    public String getFirstLabelName() {
        return "Πιθανα Προαπαιτουμενα";
    }

    @Override
    public String getSecondLabelName() {
        return "Επιλογες σας";
    }

    @Override
    public List<String> getFirstListItems() {
        List<String> items = new ArrayList<>();
        for (Thewria thewria : controller.getProapaitoumena()) {
            items.add(thewria.getOnomaMathimatos());
            proapaitoumenaMap.put(thewria.getOnomaMathimatos(), thewria);
        }

        return items;
    }


}
