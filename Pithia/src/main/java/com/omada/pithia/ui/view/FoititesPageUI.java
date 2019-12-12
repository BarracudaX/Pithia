package com.omada.pithia.ui.view;

import com.omada.pithia.service.MyAction;
import com.omada.pithia.ui.controller.FoititesController;

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
        setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();

        styleBuilder.setFont(arithmos_foititwn_label,arithmos_foititwn,outputArea,paragwghButton,backButton)
                .setForegroundAsWhite(backButton,paragwghButton,arithmos_foititwn_label,outputArea,arithmos_foititwn)
                .setBackgroundAsRed(backButton).setBackgroundAsBlue(paragwghButton).setBackgroundAsGrey(outputArea,arithmos_foititwn)
                .setCursorAsHand(backButton,paragwghButton);

        outputArea.setEditable(false);

        outputAreaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outputAreaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        backButton.addActionListener(this::backButtonClick);
        paragwghButton.addActionListener(this::paragwghButtonClick);

        Utils.GridBagConstraintBuilder gridBagConstraintBuilder = new Utils.GridBagConstraintBuilder().setRow(0).setColumn(0).setColumnWidth(2)
                .setInsets(new Insets(5, 5, 20, 5)).setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH)
                .setRowWeight(1).setColumnWeight(1);

        add(backButton, gridBagConstraintBuilder.build());

        gridBagConstraintBuilder.setRow(1);
        add(arithmos_foititwn_label, gridBagConstraintBuilder.build());


        gridBagConstraintBuilder.setColumn(1).setColumnWeight(5).setRowWeight(1).setInsets(new Insets(5,5,5,5));
        add(arithmos_foititwn, gridBagConstraintBuilder.build());

        gridBagConstraintBuilder.setColumn(0).setRow(2).setColumnWidth(2).setRowWeight(1).setColumnWeight(1);
        add(paragwghButton, gridBagConstraintBuilder.build());

        gridBagConstraintBuilder.setRowWeight(10).setRow(3);
        add(outputAreaScrollPane, gridBagConstraintBuilder.build());

    }

    private void paragwghButtonClick(ActionEvent actionEvent) {
        controller.requestForParagwgh();
    }

    private void backButtonClick(ActionEvent actionEvent) {
        backAction.action();
    }


}
