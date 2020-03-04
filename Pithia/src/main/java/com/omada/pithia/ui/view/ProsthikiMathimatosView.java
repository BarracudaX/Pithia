package com.omada.pithia.ui.view;

import com.omada.pithia.ui.controller.ProsthikiMathimatosController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProsthikiMathimatosView extends JPanel {

    private final ProsthikiMathimatosController controller;

    private final JButton prosthikiErgasthriou ;

    private final JButton prosthikiThewrias ;

    private final JButton backButton ;

    public ProsthikiMathimatosView(ProsthikiMathimatosController controller) {
        this.controller = controller;
        this.prosthikiErgasthriou = new JButton(
                controller.getMessage("ProsthikiMathimatos.View.ProsthikiErgasthriou.Button", new Object[]{})
        );
        this.prosthikiThewrias = new JButton(
                controller.getMessage("ProsthikiMathimatos.View.ProsthikiThewrias.Button", new Object[]{})
        );
        this.backButton = new JButton(
                controller.getMessage("ProsthikiMathimatos.View.Back.Button", new Object[]{})
        );
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setBackgroundAsDark(this).setFont(prosthikiErgasthriou, prosthikiThewrias,backButton)
                .setBackgroundAsBlue(prosthikiThewrias, prosthikiErgasthriou)
                .setForegroundAsWhite(prosthikiErgasthriou, prosthikiThewrias,backButton)
                .setCursorAsHand(prosthikiErgasthriou, prosthikiThewrias,backButton)
                .setBackgroundAsRed(backButton);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();

        builder.setRow(0).setColumn(0).setColumnWeight(1).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(10, 10, 10, 10));
        add(backButton, builder.build());

        builder.reset().setRow(1).setColumn(0).setColumnWeight(1).setRowWeight(1).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(10, 10, 10, 10));
        add(prosthikiThewrias, builder.build());

        builder.reset().setRow(2).setColumn(0).setColumnWeight(1).setRowWeight(1).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(10, 10, 10, 10));
        add(prosthikiErgasthriou, builder.build());

        prosthikiErgasthriou.addActionListener(this::prosthikiErgasthrioClick);
        prosthikiThewrias.addActionListener(this::prosthikiThewriasClick);
        backButton.addActionListener(this::backButtonClick);
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }

    private void prosthikiThewriasClick(ActionEvent actionEvent) {
        controller.requestForProsthikiThewrias();
    }

    private void prosthikiErgasthrioClick(ActionEvent actionEvent) {
        controller.requestForProsthikiErgasthriou();
    }


}
