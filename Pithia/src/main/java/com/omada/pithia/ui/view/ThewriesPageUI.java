package com.omada.pithia.ui.view;

import com.omada.pithia.ui.controller.ThewriesController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ThewriesPageUI extends JPanel {

    private final ThewriesController controller;

    private final JButton backButton = new JButton("Πισω");
    private final JButton showButton = new JButton("Λεπτρομεριες");
    private final JList<String> thewries;
    private final JScrollPane listScrollPane;

    private volatile String lastThewria = null;

    public ThewriesPageUI(ThewriesController controller) {
        this.controller = controller;
        this.thewries = new JList<>();
        this.listScrollPane = new JScrollPane(thewries);
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.GENERAL_BACKGROUND_COLOR);

        thewries.setVisibleRowCount(-1);
        thewries.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        thewries.setLayoutOrientation(JList.VERTICAL);

        DefaultListModel<String> defaultListModel = new DefaultListModel<>();

        for (int i = 0; i < 100; i++) {
            defaultListModel.addElement("Thewria" + i);
        }

        thewries.setModel(defaultListModel);

        thewries.setBackground(GeneralStyle.TEXT_AREA_BACKGROUND_COLOR);
        showButton.setBackground(GeneralStyle.BUTTON_BACKGROUND_COLOR);
        backButton.setBackground(GeneralStyle.LOGOUT_BACKGROUND_COLOR);

        thewries.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        backButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        showButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);

        thewries.setFont(GeneralStyle.GENERAL_FONT);
        backButton.setFont(GeneralStyle.GENERAL_FONT);
        showButton.setFont(GeneralStyle.GENERAL_FONT);

        backButton.addActionListener(this::backButtonClick);
        showButton.addActionListener(this::showButtonClick);
        thewries.addListSelectionListener(this::thewriaPicked);

        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        showButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 20, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weighty = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.BOTH;
        add(backButton, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(5, 5, 20, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weighty = 1;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.BOTH;
        add(showButton, constraints);


        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weighty = 15;
        constraints.weightx = 1;
        constraints.fill = GridBagConstraints.BOTH;
        add(listScrollPane, constraints);

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
