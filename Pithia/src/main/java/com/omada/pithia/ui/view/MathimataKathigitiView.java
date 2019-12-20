package com.omada.pithia.ui.view;

import com.omada.pithia.service.MyAction;
import com.omada.pithia.ui.controller.MathimataKathigitiController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MathimataKathigitiView extends JPanel {

    private final MathimataKathigitiController controller;

    private final MyAction backAction;

    private final JButton backButton;
    private final JButton thewriesButton;
    private final JButton ergasthriaButton;

    public MathimataKathigitiView(MathimataKathigitiController controller, MyAction backAction) {
        this.controller = controller;
        this.backAction = backAction;

        backButton = new JButton("Πισω");
        thewriesButton = new JButton("Θεωριες");
        ergasthriaButton = new JButton("Εργαστηρια");

        prepareView();
    }

    private void prepareView() {
        this.setLayout(new GridBagLayout());
        this.setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setForegroundAsWhite(backButton, thewriesButton, ergasthriaButton)
                .setBackgroundAsBlue(thewriesButton, ergasthriaButton).setBackgroundAsRed(backButton)
                .setFont(backButton, thewriesButton, ergasthriaButton)
                .setCursorAsHand(backButton, thewriesButton, ergasthriaButton);

        thewriesButton.setPreferredSize(new Dimension(200,100));
        ergasthriaButton.setPreferredSize(new Dimension(200,100));

        backButton.addActionListener(this::backButtonClick);
        thewriesButton.addActionListener(this::thewriesClick);
        ergasthriaButton.addActionListener(this::ergasthriaClick);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        builder.setFill(Utils.Fill.BOTH).setColumn(0).setRow(0).setColumnWidth(2).setRowWeight(1).setColumnWeight(1)
                .setInsets(new Insets(5,5,20,5)).setAnchor(Utils.Anchor.CENTER);
        add(backButton, builder.build());

        builder.reset().setFill(Utils.Fill.BOTH).setColumn(0).setRow(1).setRowWeight(5).setColumnWeight(1)
                .setInsets(new Insets(5,5,5,5)).setAnchor(Utils.Anchor.CENTER);
        add(thewriesButton, builder.build());


        builder.reset().setFill(Utils.Fill.BOTH).setColumn(1).setRow(1).setRowWeight(5).setColumnWeight(1)
                .setInsets(new Insets(5,5,5,5)).setAnchor(Utils.Anchor.CENTER);
        add(ergasthriaButton, builder.build());

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
