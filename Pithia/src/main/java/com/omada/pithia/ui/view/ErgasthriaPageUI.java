package com.omada.pithia.ui.view;

import com.omada.pithia.ui.controller.ErgasthriaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ErgasthriaPageUI extends JPanel {

    private final ErgasthriaController controller;

    private final JButton backButton = new JButton("Πισω");
    private final JButton showButton = new JButton("Λεπτρομεριες");
    private final JList<String> ergasthria;
    private final JScrollPane listScrollPane;

    public ErgasthriaPageUI(ErgasthriaController controller) {
        this.controller = controller;
        this.ergasthria = new JList<>();
        this.listScrollPane = new JScrollPane(ergasthria);
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.GENERAL_BACKGROUND_COLOR);

        ergasthria.setVisibleRowCount(-1);
        ergasthria.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ergasthria.setLayoutOrientation(JList.VERTICAL);

        DefaultListModel<String> defaultListModel = new DefaultListModel<>();

        for (int i = 0; i < 100; i++) {
            defaultListModel.addElement("Ergasthrio" + i);
        }

        ergasthria.setModel(defaultListModel);

        ergasthria.setBackground(GeneralStyle.TEXT_AREA_BACKGROUND_COLOR);
        showButton.setBackground(GeneralStyle.BUTTON_BACKGROUND_COLOR);
        backButton.setBackground(GeneralStyle.LOGOUT_BACKGROUND_COLOR);

        ergasthria.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        backButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        showButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);

        ergasthria.setFont(GeneralStyle.GENERAL_FONT);
        backButton.setFont(GeneralStyle.GENERAL_FONT);
        showButton.setFont(GeneralStyle.GENERAL_FONT);

        backButton.addActionListener(this::backButtonClick);
        showButton.addActionListener(this::showButtonClick);

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

    private void showButtonClick(ActionEvent actionEvent) {
        controller.requestForErgasthrio();
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBack();
    }

}
