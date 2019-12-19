package com.omada.pithia.ui.view;

import com.omada.pithia.ui.controller.KatastashController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class KatastashPageUI extends JPanel {

    private final KatastashController controller;

    private final JPanel vathmoiInputs = new JPanel();

    private final JScrollPane vathmoiScroll;

    private final JButton backButton = new JButton("Πισω");

    public KatastashPageUI(KatastashController controller) {
        this.controller = controller;
        vathmoiScroll = new JScrollPane(vathmoiInputs);
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        vathmoiInputs.setLayout(new GridBagLayout());

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();

        styleBuilder.setBackgroundAsDark(this,vathmoiInputs)
                .setBackgroundAsGrey(vathmoiInputs).setForegroundAsWhite(vathmoiInputs, backButton)
                .setBackgroundAsRed(backButton).setFont(backButton, vathmoiInputs).setCursorAsHand(backButton);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();

        builder.setColumn(0).setRow(0).setColumnWeight(1).setRowWeight(1)
                .setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5)).setAnchor(Utils.Anchor.CENTER);

        add(backButton, builder.build());

        int row = 0;

        for (Map.Entry<String, Double> vathmos : controller.getVathmous().entrySet()) {
            JLabel onomaMathimatos = new JLabel(vathmos.getKey());

            JTextField vathmosMathimatos = new JTextField(String.valueOf(vathmos.getValue()));

            styleBuilder.setFont(onomaMathimatos, vathmosMathimatos).setBackgroundAsGrey(vathmosMathimatos)
                    .setNotEditable(vathmosMathimatos).setForegroundAsWhite(vathmosMathimatos, onomaMathimatos)
                    .setHorizontalAlignmentToCenter(onomaMathimatos);
            builder.reset().setRow(row).setColumn(0).setColumnWeight(1).setAnchor(Utils.Anchor.CENTER)
                    .setFill(Utils.Fill.HORIZONTAL).setInsets(new Insets(5,5,20,5));

            vathmoiInputs.add(onomaMathimatos, builder.build());

            builder.reset().setRow(row).setColumn(1).setColumnWeight(20).setAnchor(Utils.Anchor.CENTER)
                    .setFill(Utils.Fill.HORIZONTAL).setInsets(new Insets(5,5,20,5));
            vathmoiInputs.add(vathmosMathimatos, builder.build());

            row++;
        }

        builder.reset().setRow(1).setColumn(0).setColumnWeight(1).setRowWeight(30)
                .setInsets(new Insets(5,5,5,5)).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER);
        add(vathmoiScroll, builder.build());

        vathmoiScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        vathmoiScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        backButton.addActionListener(this::backButtonClick);
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }


}
