package com.omada.pithia.ui.view;

import com.omada.pithia.ui.controller.DhlwshAlgorithmouController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class DhlwsiAlgorithmouView extends JPanel {

        private final DhlwshAlgorithmouController controller;

        private final JLabel posostoThewriasLabel ;
        private final JLabel posostoErgastiriouLabel ;
        private final JTextField posostoThewrias = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
        private final JTextField posostoErgastiriou = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
        private final JButton apothikeushAlgorithmouButton;
        private final JButton backButton ;

        public DhlwsiAlgorithmouView(DhlwshAlgorithmouController controller) {
            this.controller = controller;
            this.posostoThewriasLabel = new JLabel(
                    controller.getMessage("DhlwshAlgorithmou.View.PosostoThewrias.Label", new Object[]{})
            );
            this.posostoErgastiriouLabel = new JLabel(
                    controller.getMessage("DhlwshAlgorithmou.View.PosostoErgasthriou.Label", new Object[]{})
            );
            this.apothikeushAlgorithmouButton = new JButton(
                    controller.getMessage("DhlwshAlgorithmou.View.ApothikeushAlgorithmou.Button",new Object[]{})
            );
            this.backButton = new JButton(
                    controller.getMessage("DhlwshAlgorithmou.View.Back.Button", new Object[]{})
            );
            prepareView();
        }

    private void prepareView() {
        setBackground(GeneralStyle.DARK_COLOR);
        setLayout(new GridBagLayout());

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setFont(posostoThewriasLabel, posostoErgastiriouLabel, apothikeushAlgorithmouButton,backButton)
                .setForegroundAsWhite(backButton,posostoThewriasLabel,posostoErgastiriouLabel, apothikeushAlgorithmouButton)
                .setBackgroundAsBlue(posostoThewriasLabel, posostoErgastiriouLabel, apothikeushAlgorithmouButton)
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
        add(apothikeushAlgorithmouButton,builder.build());

        apothikeushAlgorithmouButton.addActionListener(this::eisagwghVathmologiasClick);
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
