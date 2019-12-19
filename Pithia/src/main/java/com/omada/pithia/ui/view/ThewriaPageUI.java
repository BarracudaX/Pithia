package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.ui.controller.ThewriaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ThewriaPageUI extends JPanel {

    private final ThewriaController controller;

    private final JTextField onomaThewrias = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JTextField onomaKathigiti = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JTextField eksamhno = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JTextField sunoloFoititwn = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JList<String> ergasthria = new JList<>();
    private final JList<String> proapaitoumena = new JList<>();

    private final JLabel onomaThewriasLabel = new JLabel("Ονομα Μαθηματος:");
    private final JLabel onomaKathigitiLabel = new JLabel("Ονομα Καθηγητη Θεωριας:");
    private final JLabel eksamhnoLabel = new JLabel("Εξαμηνο:");
    private final JLabel sunoloFoititwnLabel = new JLabel("Αριθμος Φοιτητων:");
    private final JLabel ergasthriaLabel = new JLabel("Εργαστηρια:");
    private final JLabel proapaitoumenaLabel = new JLabel("Προαπαιτουμενα:");

    private final JButton eisagwghVathmwnButton = new JButton("Εισαγωγη Βαθμολογιας");
    private final JButton dhlwshAlgorithmouButton = new JButton("Δηλωση Αλγοριθμου Τελικου Βαθμου");
    private final JButton prosthikiProapaitoumenouButton = new JButton("Προσθηκη Προαπαιτουμενου");
    private final JButton backButton = new JButton("Πισω");

    public ThewriaPageUI(ThewriaController controller) {
        this.controller = controller;
        prepareView(controller.getThewria());
    }

    private void prepareView(Thewria thewria) {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder
                .setFont(onomaThewrias,onomaKathigiti,eksamhno,sunoloFoititwn,proapaitoumena,ergasthria,
                    onomaThewriasLabel, onomaKathigitiLabel,eksamhnoLabel,sunoloFoititwnLabel,proapaitoumenaLabel
                        ,ergasthriaLabel,eisagwghVathmwnButton,dhlwshAlgorithmouButton,prosthikiProapaitoumenouButton,
                        backButton)
                .setNotEditable(onomaThewrias,onomaKathigiti,eksamhno,sunoloFoititwn)
                .setBackgroundAsGrey(ergasthria,proapaitoumena)
                .setForegroundAsWhite(onomaThewriasLabel,onomaKathigitiLabel,eksamhnoLabel,sunoloFoititwnLabel,proapaitoumenaLabel,
                        ergasthriaLabel,eisagwghVathmwnButton,dhlwshAlgorithmouButton,prosthikiProapaitoumenouButton,backButton,ergasthria,proapaitoumena)
                .setBackgroundAsBlue(eisagwghVathmwnButton,dhlwshAlgorithmouButton,prosthikiProapaitoumenouButton)
                .setBackgroundAsRed(backButton)
                .setCursorAsHand(eisagwghVathmwnButton,dhlwshAlgorithmouButton,prosthikiProapaitoumenouButton,backButton)
                .setHorizontalAlignmentToRight(onomaThewriasLabel,onomaKathigitiLabel,eksamhnoLabel,
                        sunoloFoititwnLabel,ergasthriaLabel,proapaitoumenaLabel);

        DefaultListModel<String> proapaitoumenaList = new DefaultListModel<>();
        DefaultListModel<String> ergasthriaList = new DefaultListModel<>();

        for (Thewria proapaitoumeno : thewria.getProapaitoumena()) {
            proapaitoumenaList.addElement(proapaitoumeno.getOnomaMathimatos());
        }

        for (Ergasthrio ergasthrio : thewria.getErgasthria()) {
            ergasthriaList.addElement(ergasthrio.getOnomaErgasthriou());
        }

        proapaitoumena.setModel(proapaitoumenaList);
        ergasthria.setModel(ergasthriaList);
        onomaKathigiti.setText(thewria.getKathigiti().getEpwnhmo()+" "+ thewria.getKathigiti().getOnoma());
        eksamhno.setText(thewria.getEksamhno().toString());
        onomaThewrias.setText(thewria.getOnomaMathimatos());
        sunoloFoititwn.setText(thewria.getFoitites().size() + " φοιτητες/τριες");

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        builder.setColumn(0).setRow(0).setColumnWidth(2).setFill(Utils.Fill.BOTH).setAnchor(Utils.Anchor.CENTER)
                .setInsets(new Insets(5, 5, 10, 5)).setRowWeight(1).setColumnWeight(1);
        add(backButton, builder.build());

        //IMPORTANT TO KEEP THE ORDER OF LABEL AND FIELD PAIR THE SAME
        JLabel[] labels = {onomaThewriasLabel,onomaKathigitiLabel,eksamhnoLabel,sunoloFoititwnLabel,proapaitoumenaLabel, ergasthriaLabel};
        Component[] fields = {onomaThewrias,onomaKathigiti,eksamhno,sunoloFoititwn,proapaitoumena,ergasthria};
        JButton[] buttons = {dhlwshAlgorithmouButton,eisagwghVathmwnButton,prosthikiProapaitoumenouButton};

        for (int row = 1; row < labels.length + 1; row++) {
            builder.reset().setColumn(0).setRow(row).setFill(Utils.Fill.BOTH).setAnchor(Utils.Anchor.CENTER)
                    .setInsets(new Insets(5,10,5,5)).setColumnWeight(1).setRowWeight(1);
            add(labels[row - 1], builder.build());

            builder.reset().setRow(row).setColumn(1).setFill(Utils.Fill.BOTH).setAnchor(Utils.Anchor.CENTER)
                    .setInsets(new Insets(5, 5, 5, 5)).setColumnWeight(10);
            if (fields[row - 1] instanceof JList) {
                builder.setRowWeight(10);
            } else {
                builder.setRowWeight(1);
            }
            add(fields[row - 1], builder.build());
        }

        for (int row = labels.length + 1; row < labels.length + 1 + buttons.length; row++) {
            builder.reset().setColumn(0).setRow(row).setFill(Utils.Fill.BOTH).setAnchor(Utils.Anchor.CENTER)
                    .setInsets(new Insets(5, 5, 5, 5)).setColumnWeight(1).setRowWeight(1).setColumnWidth(2);
            add(buttons[row - (labels.length + 1)], builder.build());
        }

        backButton.addActionListener(this::backButtonClick);
        prosthikiProapaitoumenouButton.addActionListener(this::prosthikiProapaitoumenouClick);
        eisagwghVathmwnButton.addActionListener(this::eisagwghVathmologiasClick);
    }

    private void eisagwghVathmologiasClick(ActionEvent actionEvent) {
        controller.requestForEisagwghVathmologias();
    }

    private void prosthikiProapaitoumenouClick(ActionEvent actionEvent) {
        controller.requestForProsthikiProapaitoumenwn();
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }


}
