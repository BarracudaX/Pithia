package com.omada.pithia.ui.view;

import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.ui.controller.DiaxeirishApousiwnController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DiaxeirishApousiwnPageUI extends JPanel {

    private final DiaxeirishApousiwnController controller;

    private final JButton backButton = new JButton("Πισω");
    private final JPanel inputs = new JPanel(new GridBagLayout());

    public DiaxeirishApousiwnPageUI(DiaxeirishApousiwnController controller) {
        this.controller = controller;
        prepareView();
    }

    private void prepareView() {
        setBackground(GeneralStyle.DARK_COLOR);
        setLayout(new GridBagLayout());

        JScrollPane scrollPane = new JScrollPane(inputs, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setFont(backButton, inputs)
                .setBackgroundAsRed(backButton).setCursorAsHand(backButton)
                .setForegroundAsWhite(backButton)
                .setBackgroundAsGrey(inputs,scrollPane);


        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        builder.setRow(0).setColumn(0).setRowWeight(1).setColumnWeight(1).setFill(Utils.Fill.BOTH).setAnchor(Utils.Anchor.CENTER)
                .setInsets(new Insets(5, 5, 20, 5));
        add(backButton, builder.build());

        int row = 0;

        for (Foititis foititis : controller.getFoitites()) {
            builder.reset().setRow(row++).setColumn(0).setRowWeight(1).setColumnWeight(1).setColumn(1).setFill(Utils.Fill.HORIZONTAL)
                    .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(10, 10, 10, 10));
            inputs.add(new InputApousia(foititis, controller.getArithmoApousiwn(foititis)),builder.build());
        }

        builder.reset().setRow(1).setColumn(0).setRowWeight(20).setColumnWeight(1).setFill(Utils.Fill.BOTH).setAnchor(Utils.Anchor.CENTER)
                .setInsets(new Insets(5, 5, 5, 5));
        add(scrollPane, builder.build());

        backButton.addActionListener(this::backButtonClick);
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }

}
