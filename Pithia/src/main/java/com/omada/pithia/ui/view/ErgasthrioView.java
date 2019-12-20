package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.ui.controller.ErgasthrioController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ErgasthrioView extends JPanel {

    private final ErgasthrioController controller;

    private final JLabel onomaMathimatosLabel = new JLabel("Ονομα Μαθηματος:");
    private final JLabel onomaMathimatosThewriasLabel = new JLabel("Ονομα Μαθηματος Θεωριας:");
    private final JLabel onomaKathigitiLabel = new JLabel("Ονομα Καθηγητη:");
    private final JLabel eksamhnoLabel = new JLabel("Εξαμηνο:");
    private final JLabel arithmosFoititwnLabel = new JLabel("Αριθμος Φοιτητων:");
    private final JButton eisagwghVathmologias = new JButton("Εισαγωγη Βαθμολογιας");
    private final JButton prosthikiFoititi = new JButton("Προσθηκη Φοιτητων Στο Εργαστηριο");
    private final JButton apousies = new JButton("Διαχειριση Απουσιων");
    private final JButton backButton = new JButton("Πισω");
    private final JTextField onomaMathimatos = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JTextField onomaMathimatosThewrias = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JTextField onomaKathigiti = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JTextField eksamhno = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JTextField arithmosFoititwn = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);


    public ErgasthrioView(ErgasthrioController controller) {
        this.controller = controller;
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setFont(
                onomaMathimatosLabel, onomaMathimatosThewriasLabel, onomaKathigitiLabel, eksamhnoLabel, arithmosFoititwnLabel,
                onomaMathimatos, onomaMathimatosThewrias, onomaKathigiti, eksamhno, arithmosFoititwn,
                eisagwghVathmologias, apousies, prosthikiFoititi, backButton)
                .setForegroundAsWhite(
                        onomaMathimatosLabel, onomaMathimatosThewriasLabel, onomaKathigitiLabel, eksamhnoLabel, arithmosFoititwnLabel,
                        onomaMathimatos, onomaMathimatosThewrias, onomaKathigiti, eksamhno, arithmosFoititwn,
                        eisagwghVathmologias, apousies, prosthikiFoititi, backButton)
                .setBackgroundAsGrey(onomaMathimatos, onomaMathimatosThewrias, onomaKathigiti, eksamhno, arithmosFoititwn)
                .setBackgroundAsBlue(apousies, prosthikiFoititi, eisagwghVathmologias).setBackgroundAsRed(backButton)
                .setHorizontalAlignmentToRight(
                        onomaMathimatosLabel, onomaMathimatosThewriasLabel, onomaKathigitiLabel, eksamhnoLabel, arithmosFoititwnLabel)
                .setTextFieldSize(onomaMathimatos, onomaMathimatosThewrias, onomaKathigiti, eksamhno, arithmosFoititwn)
                .setNotEditable(onomaMathimatos, onomaMathimatosThewrias, onomaKathigiti, eksamhno, arithmosFoititwn)
                .setCursorAsHand(eisagwghVathmologias,apousies,prosthikiFoititi,backButton);

        JComponent[] labels = {onomaMathimatosLabel, onomaMathimatosThewriasLabel, onomaKathigitiLabel, eksamhnoLabel, arithmosFoititwnLabel};
        JComponent[] fields = {onomaMathimatos, onomaMathimatosThewrias, onomaKathigiti, eksamhno, arithmosFoititwn};

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        builder.setRow(0).setColumn(0).setColumnWidth(2).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 20, 5))
                .setAnchor(Utils.Anchor.CENTER).setRowWeight(1);
        add(backButton, builder.build());

        builder.reset();
        for (int row = 1; row < labels.length+1; row++) {
            builder.setColumn(0).setRow(row).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 20))
                    .setAnchor(Utils.Anchor.CENTER).setColumnWeight(1).setRowWeight(1);
            add(labels[row-1], builder.build());

            builder.reset().setColumn(1).setRow(row).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                    .setAnchor(Utils.Anchor.CENTER).setColumnWeight(10).setRowWeight(1);

            add(fields[row-1], builder.build());
        }

        builder.reset().setRow(labels.length+1).setColumn(0).setColumnWidth(2).setFill(Utils.Fill.BOTH).setRowWeight(1)
                .setInsets(new Insets(20, 5, 5, 5)).setAnchor(Utils.Anchor.CENTER);
        add(prosthikiFoititi, builder.build());

        builder.reset().setRow(labels.length+2).setColumn(0).setColumnWidth(2).setFill(Utils.Fill.BOTH).setRowWeight(1)
                .setInsets(new Insets(20, 5, 5, 5)).setAnchor(Utils.Anchor.CENTER);
        add(eisagwghVathmologias, builder.build());

        builder.reset().setRow(labels.length+3).setColumn(0).setColumnWidth(2).setFill(Utils.Fill.BOTH).setRowWeight(1)
                .setInsets(new Insets(20, 5, 5, 5)).setAnchor(Utils.Anchor.CENTER);
        add(apousies, builder.build());

        Ergasthrio ergasthrio = controller.getErgasthrio();

        onomaMathimatos.setText(ergasthrio.getOnomaErgasthriou());
        onomaMathimatosThewrias.setText(ergasthrio.getThewria().getOnomaMathimatos());
        arithmosFoititwn.setText(ergasthrio.getFoitites().size() + " φοιτητες/τριες");
        onomaKathigiti.setText(ergasthrio.getKathigiti().getEpwnhmo() + " " + ergasthrio.getKathigiti().getOnoma());
        eksamhno.setText(ergasthrio.getThewria().getEksamhno().toString() + " Εξαμνο");

        backButton.addActionListener(this::backButtonClick);
        eisagwghVathmologias.addActionListener(this::eisagwghVathmologiasClick);
        prosthikiFoititi.addActionListener(this::prosthikiFoititwnClick);
        apousies.addActionListener(this::apousiesButtonClick);
    }

    private void apousiesButtonClick(ActionEvent actionEvent) {
        controller.requestForDiaxeirishApousiwn();
    }

    private void prosthikiFoititwnClick(ActionEvent actionEvent) {
        controller.requestForProsthikiFoititwn();
    }

    private void eisagwghVathmologiasClick(ActionEvent actionEvent) {
        controller.requestForEisagwghVathmologias();
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }

}
