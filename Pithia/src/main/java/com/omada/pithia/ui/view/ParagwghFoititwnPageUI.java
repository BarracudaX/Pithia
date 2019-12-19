package com.omada.pithia.ui.view;

import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.service.MyAction;
import com.omada.pithia.ui.controller.ParagwghFoititwnController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class ParagwghFoititwnPageUI extends JPanel {

    private final ParagwghFoititwnController controller;

    private final MyAction backAction;

    private final JLabel arithmos_foititwn_label = new JLabel("Αριθμος Φοιτιτων:");
    private JFormattedTextField arithmos_foititwn ;
    private final JButton paragwghButton = new JButton("Παραγωγη Λογαριασμων");
    private final JButton backButton = new JButton("Πισω");
    private final JTextArea outputArea = new JTextArea("Εδω θα βγει output...",GeneralStyle.DEFAULT_TEXT_AREA_ROWS,GeneralStyle.DEFAULT_TEXT_AREA_COLUMNS);
    private final JScrollPane outputAreaScrollPane;
    private final JButton stopButton = new JButton("Σταματημα Παραγωγης");

    public ParagwghFoititwnPageUI(ParagwghFoititwnController controller, MyAction backAction) {
        this.controller = controller;
        this.backAction = backAction;
        this.outputAreaScrollPane = new JScrollPane(outputArea);
        prepareView();
        this.controller.setView(this);
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        NumberFormat format = NumberFormat.getIntegerInstance();
        format.setMaximumIntegerDigits(3);
        format.setMinimumIntegerDigits(1);

        arithmos_foititwn = new JFormattedTextField(format);
        arithmos_foititwn.setValue(0);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();

        styleBuilder.setFont(arithmos_foititwn_label,stopButton,arithmos_foititwn,outputArea,paragwghButton,backButton)
                .setForegroundAsWhite(backButton,stopButton,paragwghButton,arithmos_foititwn_label,outputArea,arithmos_foititwn)
                .setBackgroundAsRed(backButton,stopButton).setBackgroundAsBlue(paragwghButton)
                .setBackgroundAsGrey(outputArea,arithmos_foititwn)
                .setCursorAsHand(backButton,paragwghButton,stopButton).setNotEditable(outputArea);

        outputAreaScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outputAreaScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Utils.GridBagConstraintBuilder gridBagConstraintBuilder = new Utils.GridBagConstraintBuilder();
        gridBagConstraintBuilder.setRow(0).setColumn(0).setColumnWidth(2).setInsets(new Insets(5, 5, 20, 5))
                .setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH).setColumnWeight(1);

        add(backButton, gridBagConstraintBuilder.build());

        gridBagConstraintBuilder.setRow(1).setColumn(0).setInsets(new Insets(5, 5, 20, 5))
                .setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH).setColumnWeight(1);
        add(arithmos_foititwn_label, gridBagConstraintBuilder.build());


        gridBagConstraintBuilder.setRow(1).setColumn(1).setInsets(new Insets(5, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH).setColumnWeight(15);
        add(arithmos_foititwn, gridBagConstraintBuilder.build());

        gridBagConstraintBuilder.setRow(2).setColumn(0).setInsets(new Insets(15, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH).setColumnWeight(1).setColumnWidth(2);
        add(paragwghButton, gridBagConstraintBuilder.build());

        gridBagConstraintBuilder.setRow(3).setColumn(0).setInsets(new Insets(15, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH).setColumnWeight(1).setColumnWidth(2);
        add(stopButton, gridBagConstraintBuilder.build());

        gridBagConstraintBuilder.setRow(4).setColumn(0).setInsets(new Insets(15, 5, 5, 5)).setRowWeight(20)
                .setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH).setColumnWeight(1).setColumnWidth(2);
        add(outputAreaScrollPane, gridBagConstraintBuilder.build());

        stopButton.setEnabled(false);

        backButton.addActionListener(this::backButtonClick);
        paragwghButton.addActionListener(this::paragwghButtonClick);
        stopButton.addActionListener(this::stopButtonRequest);
    }

    private void stopButtonRequest(ActionEvent actionEvent) {
        controller.requestForStop();
    }

    private void paragwghButtonClick(ActionEvent actionEvent) {
        paragwghButton.setEnabled(false);
        backButton.setEnabled(false);
        stopButton.setEnabled(true);
        int arithmosFoititwn = ((Number) arithmos_foititwn.getValue()).intValue();
        controller.requestForParagwgh(arithmosFoititwn);
    }

    private void backButtonClick(ActionEvent actionEvent) {
        backAction.action();
    }

    public void showMessage(String message) {
        outputArea.append("\n"+message+"\n");
    }

    public void doneCreation(){
        backButton.setEnabled(true);
        paragwghButton.setEnabled(true);
    }
}
