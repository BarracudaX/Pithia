package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Kathigitis;
import com.omada.pithia.service.XrhstesService;
import com.omada.pithia.ui.controller.ThewriesController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ThewriesView extends JPanel {

    private final ThewriesController controller;

    private final JButton backButton = new JButton("Πισω");
    private final JButton showButton = new JButton("Λεπτρομεριες");
    private final JList<String> thewries;
    private final JScrollPane listScrollPane;

    private volatile String lastThewria = null;

    public ThewriesView(ThewriesController controller) {
        this.controller = controller;
        this.thewries = new JList<>();
        this.listScrollPane = new JScrollPane(thewries);
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        thewries.setVisibleRowCount(-1);
        thewries.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        thewries.setLayoutOrientation(JList.VERTICAL);

        DefaultListModel<String> defaultListModel = getThewries();

        thewries.setModel(defaultListModel);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setBackgroundAsGrey(thewries).setBackgroundAsBlue(showButton).setBackgroundAsRed(backButton)
                .setForegroundAsWhite(thewries, backButton, showButton)
                .setFont(thewries, backButton, showButton)
                .setCursorAsHand(backButton, showButton);

        backButton.addActionListener(this::backButtonClick);
        showButton.addActionListener(this::showButtonClick);
        thewries.addListSelectionListener(this::thewriaPicked);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();

        builder.setColumn(0).setRow(0).setAnchor(Utils.Anchor.CENTER)
                .setFill(Utils.Fill.BOTH).setInsets(new Insets(5,5,20,5))
                .setColumnWeight(1).setRowWeight(1).build();
        add(backButton, builder.build());

        builder.reset().setColumn(0).setRow(1).setAnchor(Utils.Anchor.CENTER)
                .setFill(Utils.Fill.BOTH).setInsets(new Insets(5,5,20,5))
                .setColumnWeight(1).setRowWeight(1).build();
        add(showButton, builder.build());

        builder.setColumn(0).setRow(2).setAnchor(Utils.Anchor.CENTER)
                .setFill(Utils.Fill.BOTH).setInsets(new Insets(5,5,5,5))
                .setColumnWeight(1).setRowWeight(1).setRowWeight(15).build();
        add(listScrollPane, builder.build());

    }

    private DefaultListModel<String> getThewries() {
        DefaultListModel<String> thewries = new DefaultListModel<>();

        for (Thewria thewria : controller.getThewries()) {
            thewries.addElement(thewria.getOnomaMathimatos());
        }

        return thewries;
    }

    private void thewriaPicked(ListSelectionEvent listSelectionEvent) {
        if (!listSelectionEvent.getValueIsAdjusting()) {
            if (thewries.getSelectedIndex() > -1) {
                lastThewria = thewries.getSelectedValue();
            }
        }
    }

    private void showButtonClick(ActionEvent actionEvent) {
        if (lastThewria != null) {
            String selectedThewria = lastThewria;
            lastThewria = null;
            controller.requestForThewria(selectedThewria);
        }
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBack();
    }


}
