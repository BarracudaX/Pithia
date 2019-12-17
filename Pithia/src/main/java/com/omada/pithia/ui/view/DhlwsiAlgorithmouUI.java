package com.omada.pithia.ui.view;

import com.omada.pithia.ui.controller.DhlwshAlgorithmouController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class DhlwsiAlgorithmouUI extends JPanel {
        private final DhlwshAlgorithmouController controller;

        private final JLabel posostoThewriasLabel = new JLabel("Ποσοστό Θεωρίας");
        private final JLabel posostoErgastiriouLabel = new JLabel("Ποσοστό Θεωρίας");
        private final JTextField posostoThewrias = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
        private final JTextField posostoErgastiriou = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
        private final JButton eisagwghVathmologias = new JButton("Εισαγωγη Βαθμολογιας");

        public DhlwsiAlgorithmouUI(DhlwshAlgorithmouController controller) {
            this.controller = controller;
            prepareView();
        }

    private void prepareView() {
        setBackground(GeneralStyle.DARK_COLOR);
        setLayout(new GridBagLayout());

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setFont(posostoThewriasLabel, posostoErgastiriouLabel, posostoThewrias, posostoErgastiriou, eisagwghVathmologias)
                .setForegroundAsWhite(posostoThewriasLabel, posostoErgastiriouLabel, posostoThewrias, posostoErgastiriou, eisagwghVathmologias)
                .setBackgroundAsBlue(posostoThewriasLabel, posostoErgastiriouLabel, posostoThewrias, posostoErgastiriou, eisagwghVathmologias)
                .setHorizontalAlignmentToRight(posostoThewriasLabel, posostoErgastiriouLabel)
                .setTextFieldSize(posostoThewrias, posostoErgastiriou);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();

        eisagwghVathmologias.addActionListener(this::eisagwghVathmologiasClick);
    }
        private void eisagwghVathmologiasClick(ActionEvent actionEvent) {
            double x = Double.parseDouble(posostoThewrias.getText());
            double y = Double.parseDouble(posostoErgastiriou.getText());

                controller.saveAlgorythmo(x,y);
        }

}
