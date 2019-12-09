package com.omada.pithia.ui.view;

import com.omada.pithia.service.MyAction;
import com.omada.pithia.ui.controller.MathimataMouController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Function;

public class MathimataMouPageUI extends JPanel {

    private final MathimataMouController controller;

    private final MyAction backAction;

    private final JButton backButton;
    private final JButton thewriesButton;
    private final JButton ergasthriaButton;

    public MathimataMouPageUI(MathimataMouController controller,MyAction backAction) {
        this.controller = controller;
        this.backAction = backAction;

        backButton = new JButton("Πισω");
        thewriesButton = new JButton("Θεωριες");
        ergasthriaButton = new JButton("Εργαστηρια");

        prepareView();
    }

    private void prepareView() {
        this.setLayout(new GridBagLayout());
        this.setBackground(GeneralStyle.GENERAL_BACKGROUND_COLOR);

        backButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        thewriesButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        ergasthriaButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);

        backButton.setBackground(GeneralStyle.LOGOUT_BACKGROUND_COLOR);
        thewriesButton.setBackground(GeneralStyle.BUTTON_BACKGROUND_COLOR);
        ergasthriaButton.setBackground(GeneralStyle.BUTTON_BACKGROUND_COLOR);

        backButton.setFont(GeneralStyle.GENERAL_FONT);
        thewriesButton.setFont(GeneralStyle.GENERAL_FONT);
        ergasthriaButton.setFont(GeneralStyle.GENERAL_FONT);

        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        thewriesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ergasthriaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        backButton.addActionListener(this::backButtonClick);
        thewriesButton.addActionListener(this::thewriesClick);
        ergasthriaButton.addActionListener(this::ergasthriaClick);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.weighty = 1;
        constraints.weightx = 1;
        constraints.insets = new Insets(5, 5, 20, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        add(backButton, constraints);

        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weighty = 5;
        constraints.weightx = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        add(thewriesButton, constraints);


        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weighty = 5;
        constraints.weightx = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        add(ergasthriaButton, constraints);

    }

    private void ergasthriaClick(ActionEvent actionEvent) {
        controller.requestForErgasthria();
    }

    private void thewriesClick(ActionEvent actionEvent) {
        controller.requestForThewries();
    }

    private void backButtonClick(ActionEvent actionEvent) {
        backAction.action();
    }


}
