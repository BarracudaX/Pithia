package com.omada.pithia.ui.view;

import com.omada.pithia.ui.controller.DhlwshAlgorithmouController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class DhlwsiAlgorithmouUI extends JPanel {

        private final DhlwshAlgorithmouController controller;

        private final JLabel posostoThewriasLabel = new JLabel("Ποσοστο Θεωριας");
        private final JLabel posostoErgastiriouLabel = new JLabel("Ποσοστό Εργαστηριου");
        private final JTextField posostoThewrias = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
        private final JTextField posostoErgastiriou = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
        private final JButton eisagwghVathmologias = new JButton("Εισαγωγη Βαθμολογιας");
        private final JButton backButton = new JButton("Επιστροφη στην αρχικη");

        public DhlwsiAlgorithmouUI(DhlwshAlgorithmouController controller) {
            this.controller = controller;
            prepareView();
        }

    private void prepareView() {
        setBackground(GeneralStyle.DARK_COLOR);
        setLayout(new GridBagLayout());

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setFont(posostoThewriasLabel, posostoErgastiriouLabel, eisagwghVathmologias,backButton)
                .setForegroundAsWhite(backButton,posostoThewriasLabel,posostoErgastiriouLabel, eisagwghVathmologias)
                .setBackgroundAsBlue(posostoThewriasLabel, posostoErgastiriouLabel,eisagwghVathmologias)
                .setHorizontalAlignmentToRight(posostoThewriasLabel, posostoErgastiriouLabel)
                .setTextFieldSize(posostoThewrias, posostoErgastiriou)
                .setBackgroundAsRed(backButton);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        
        builder.setRow(0).setColumn(0).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setColumnWidth(2);
        add(backButton,builder.build());

        builder.reset();

        builder.setRow(1).setColumn(0).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setColumnWidth(1).setColumnWeight(1);
        add(posostoThewriasLabel,builder.build());

        builder.reset();

        builder.setRow(1).setColumn(1).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setColumnWidth(1).setColumnWeight(2);
        add(posostoThewrias,builder.build());

        builder.reset();

        builder.setRow(2).setColumn(0).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setColumnWidth(1).setColumnWeight(1);
        add(posostoErgastiriouLabel,builder.build());

        builder.reset();

        builder.setRow(2).setColumn(1).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setColumnWidth(1).setColumnWeight(2);
        add(posostoErgastiriou,builder.build());

        builder.reset();

        builder.setRow(3).setColumn(0).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setColumnWidth(2);
        add(eisagwghVathmologias,builder.build());

        eisagwghVathmologias.addActionListener(this::eisagwghVathmologiasClick);
        backButton.addActionListener(this::backButtonClick);
    }
        private void eisagwghVathmologiasClick(ActionEvent actionEvent) {
            double x = Double.parseDouble(posostoThewrias.getText());
            double y = Double.parseDouble(posostoErgastiriou.getText());

                controller.saveAlgorythmo(x,y);
        }
        
        private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }

}
