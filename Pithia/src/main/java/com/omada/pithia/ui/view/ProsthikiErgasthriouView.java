package com.omada.pithia.ui.view;

import com.omada.pithia.ui.controller.ProsthikiErgasthriouController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ProsthikiErgasthriouView extends JPanel {

    private String pickedOnomaThewrias ;
    private String pickedOnomaKathigiti ;

    private final ProsthikiErgasthriouController controller;

    private final JComboBox<String> thewries ;
    private final JComboBox<String> kathigites ;
    private final JTextField onomaErgasthriou = new JTextField();

    private final JLabel thewriesLabel ;
    private final JLabel onomaErgasthriouLabel;
    private final JLabel kathigitesLabel;

    private final JButton prosthikiButton ;
    private final JButton backButton ;

    public ProsthikiErgasthriouView(ProsthikiErgasthriouController controller) {
        this.controller = controller;
        this.thewries = new JComboBox<>(controller.getThewries());
        this.kathigites = new JComboBox<>(controller.getKathigites());

        this.thewriesLabel = new JLabel(
                controller.getMessage("ProsthikiErgasthriou.View.Thewries.Label", new Object[]{})
        );
        this.onomaErgasthriouLabel = new JLabel(
                controller.getMessage("ProsthikiErgasthriou.View.OnomaErgasthriou.Label", new Object[]{})
        );
        this.kathigitesLabel = new JLabel(
                controller.getMessage("ProsthikiErgasthriou.View.Kathigitis.Label", new Object[]{})
        );
        this.prosthikiButton = new JButton(
                controller.getMessage("ProsthikiErgasthriou.View.Prosthiki.Button", new Object[]{})
        );
        this.backButton = new JButton(
                controller.getMessage("ProsthikiErgasthriou.View.Back.Button", new Object[]{})
        );
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder
                .setBackgroundAsDark(this)
                .setFont(
                        thewries, kathigites, onomaErgasthriou, prosthikiButton,
                        thewriesLabel, kathigitesLabel, onomaErgasthriouLabel, backButton
                )
                .setForegroundAsWhite(
                        thewries, kathigites, onomaErgasthriou, prosthikiButton,
                        thewriesLabel, kathigitesLabel, onomaErgasthriouLabel, backButton
                )
                .setBackgroundAsGrey(thewries, kathigites, onomaErgasthriou)
                .setBackgroundAsBlue(prosthikiButton)
                .setCursorAsHand(prosthikiButton, backButton)
                .setHorizontalAlignmentToRight(thewriesLabel, onomaErgasthriouLabel, kathigitesLabel)
                .setBackgroundAsRed(backButton);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();

        builder.setRow(0).setColumn(0).setColumnWidth(2).setColumnWeight(1).setFill(Utils.Fill.BOTH)
                .setInsets(new Insets(5, 5, 20, 5)).setRowWeight(15).setAnchor(Utils.Anchor.CENTER);
        add(backButton, builder.build());

        builder.reset().setRow(1).setColumn(0).setColumnWeight(1).setRowWeight(5).setFill(Utils.Fill.BOTH)
                .setInsets(new Insets(5, 5, 5, 15)).setAnchor(Utils.Anchor.CENTER);
        add(thewriesLabel, builder.build());

        builder.reset().setRow(1).setColumn(1).setColumnWeight(15).setRowWeight(5).setFill(Utils.Fill.BOTH)
                .setInsets(new Insets(5, 5, 5, 5)).setAnchor(Utils.Anchor.CENTER);
        add(thewries, builder.build());

        builder.reset().setRow(2).setColumn(0).setColumnWeight(1).setRowWeight(5).setFill(Utils.Fill.BOTH)
                .setInsets(new Insets(5, 5, 5, 15)).setAnchor(Utils.Anchor.CENTER);
        add(kathigitesLabel, builder.build());

        builder.reset().setRow(2).setColumn(1).setColumnWeight(15).setRowWeight(5).setFill(Utils.Fill.BOTH)
                .setInsets(new Insets(5, 5, 5, 5)).setAnchor(Utils.Anchor.CENTER);
        add(kathigites, builder.build());

        builder.reset().setRow(3).setColumn(0).setColumnWeight(1).setRowWeight(5).setFill(Utils.Fill.BOTH)
                .setInsets(new Insets(5, 5, 5, 15)).setAnchor(Utils.Anchor.CENTER);
        add(onomaErgasthriouLabel, builder.build());

        builder.reset().setRow(3).setColumn(1).setColumnWeight(15).setRowWeight(5).setFill(Utils.Fill.BOTH)
                .setInsets(new Insets(5, 5, 5, 5)).setAnchor(Utils.Anchor.CENTER);
        add(onomaErgasthriou, builder.build());

        builder.reset().setRow(4).setColumn(0).setColumnWeight(1).setRowWeight(35).setFill(Utils.Fill.BOTH)
                .setInsets(new Insets(5, 5, 5, 5)).setColumnWidth(2).setAnchor(Utils.Anchor.CENTER);
        add(prosthikiButton, builder.build());

        thewries.addActionListener(this::thewriesPick);
        kathigites.addActionListener(this::kathigitesPick);
        backButton.addActionListener(this::backButtonClick);
        prosthikiButton.addActionListener(this::prosthikiButtonClick);

        thewries.setSelectedIndex(0);
        kathigites.setSelectedIndex(0);
    }

    private void kathigitesPick(ActionEvent actionEvent) {
        this.pickedOnomaKathigiti  = kathigites.getItemAt(kathigites.getSelectedIndex());
    }

    private void thewriesPick(ActionEvent actionEvent) {
        this.pickedOnomaThewrias = thewries.getItemAt(thewries.getSelectedIndex());
    }

    private void prosthikiButtonClick(ActionEvent actionEvent) {
        controller.requestForProsthiki(pickedOnomaThewrias, pickedOnomaKathigiti, onomaErgasthriou.getText().trim());
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }


}
