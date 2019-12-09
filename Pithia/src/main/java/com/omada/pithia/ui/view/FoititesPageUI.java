package com.omada.pithia.ui.view;

import com.omada.pithia.service.MyAction;
import com.omada.pithia.ui.controller.FoititesController;
import javafx.scene.control.ScrollPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FoititesPageUI extends JPanel {

    private final FoititesController controller;

    private final MyAction backAction;

    private final JLabel arithmos_foititwn_label = new JLabel("Αριθμος Φοιτιτων:");
    private final JTextField arithmos_foititwn = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JButton paragwghButton = new JButton("Παραγωγη Λογαριασμων");
    private final JButton backButton = new JButton("Πισω");
    private final JTextArea outputArea = new JTextArea("Εδω θα βγει output...",GeneralStyle.DEFAULT_TEXT_AREA_ROWS,GeneralStyle.DEFAULT_TEXT_AREA_COLUMNS);
    private final JScrollPane outputAreaScrollPane;

    public FoititesPageUI(FoititesController controller,MyAction backAction) {
        this.controller = controller;
        this.backAction = backAction;
        this.outputAreaScrollPane = new JScrollPane(outputArea);

        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.GENERAL_BACKGROUND_COLOR);

        arithmos_foititwn_label.setFont(GeneralStyle.GENERAL_FONT);
        arithmos_foititwn.setFont(GeneralStyle.GENERAL_FONT);
        outputArea.setFont(GeneralStyle.GENERAL_FONT);
        paragwghButton.setFont(GeneralStyle.GENERAL_FONT);
        backButton.setFont(GeneralStyle.GENERAL_FONT);

        backButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        paragwghButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        arithmos_foititwn_label.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        outputArea.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        arithmos_foititwn.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);

        backButton.setBackground(GeneralStyle.LOGOUT_BACKGROUND_COLOR);
        paragwghButton.setBackground(GeneralStyle.BUTTON_BACKGROUND_COLOR);
        outputArea.setBackground(GeneralStyle.TEXT_AREA_BACKGROUND_COLOR);
        arithmos_foititwn.setBackground(GeneralStyle.TEXT_AREA_BACKGROUND_COLOR);

        outputArea.setEditable(false);

        outputAreaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outputAreaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        backButton.addActionListener(this::backButtonClick);
        paragwghButton.addActionListener(this::paragwghButtonClick);

        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        paragwghButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0 ;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5, 5, 20, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        add(backButton, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0 ;
        constraints.gridy = 1;
        constraints.insets = new Insets(5, 5, 5, 20);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        add(arithmos_foititwn_label, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 5;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 2;
        add(arithmos_foititwn, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;
        add(paragwghButton, constraints);

        constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 1;
        constraints.weighty = 10;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.ipadx = 2;
        add(outputAreaScrollPane, constraints);

    }

    private void paragwghButtonClick(ActionEvent actionEvent) {
        controller.requestForParagwgh();
    }

    private void backButtonClick(ActionEvent actionEvent) {
        backAction.action();
    }


}
