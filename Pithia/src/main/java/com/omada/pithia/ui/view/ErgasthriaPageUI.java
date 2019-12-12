package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.xrhstes.Kathigitis;
import com.omada.pithia.service.XrhstesService;
import com.omada.pithia.ui.controller.ErgasthriaController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ErgasthriaPageUI extends JPanel {

    private final ErgasthriaController controller;

    private final JButton backButton = new JButton("Πισω");
    private final JButton showButton = new JButton("Λεπτρομεριες");
    private final JList<String> ergasthria;
    private final JScrollPane listScrollPane;
    private volatile String teleutaioErgasthrio = null;

    public ErgasthriaPageUI(ErgasthriaController controller) {
        this.controller = controller;
        this.ergasthria = new JList<>();
        this.listScrollPane = new JScrollPane(ergasthria);
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();

        ergasthria.setVisibleRowCount(-1);
        ergasthria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ergasthria.setLayoutOrientation(JList.VERTICAL);


        List<Ergasthrio> ergasthriaKathigiti = controller.getErgasthria();

        DefaultListModel<String> ergasthriaModel = new DefaultListModel<>();

        for (Ergasthrio ergasthrio : ergasthriaKathigiti) {
            ergasthriaModel.addElement(ergasthrio.getOnomaErgasthriou());
        }

        this.ergasthria.setModel(ergasthriaModel);

        styleBuilder.setBackgroundAsGrey(this.ergasthria).setBackgroundAsBlue(showButton).setBackgroundAsRed(backButton)
            .setForegroundAsWhite(this.ergasthria,showButton,backButton).setFont(this.ergasthria,backButton,showButton)
            .setCursorAsHand(backButton,showButton);

        backButton.addActionListener(this::backButtonClick);
        showButton.addActionListener(this::showButtonClick);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        builder.setColumn(0).setRow(0).setInsets(new Insets(5, 5, 20, 5)).setAnchor(Utils.Anchor.CENTER)
                .setColumnWeight(1).setRowWeight(1).setFill(Utils.Fill.BOTH);

        add(backButton, builder.build());

        builder.reset().setColumn(0).setRow(1).setInsets(new Insets(5, 5, 20, 5)).setAnchor(Utils.Anchor.CENTER)
                .setColumnWeight(1).setRowWeight(1).setFill(Utils.Fill.BOTH);
        add(showButton, builder.build());

        builder.reset().setColumn(0).setRow(2).setInsets(new Insets(5, 5, 5, 5)).setAnchor(Utils.Anchor.CENTER)
                .setColumnWeight(1).setRowWeight(15).setFill(Utils.Fill.BOTH);
        add(listScrollPane, builder.build());

        this.ergasthria.addListSelectionListener(this::epiloghErgasthriou);
    }

    private void epiloghErgasthriou(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting()) {
            if (ergasthria.getSelectedIndex() > -1) {
                teleutaioErgasthrio = ergasthria.getSelectedValue();
            }
        }
    }

    private void showButtonClick(ActionEvent actionEvent) {
        if (teleutaioErgasthrio != null) {
            controller.requestForErgasthrio(teleutaioErgasthrio);
            teleutaioErgasthrio = null;
        }
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBack();
    }

}
