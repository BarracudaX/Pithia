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
    private final JLabel ergasthriaLabel = new JLabel("Αριθμος Εργαστηριων:");
    private final JLabel proapaitoumenaLabel = new JLabel("Προαπαιτουμενα:");

    private final JButton eisagwghVathmwnButton = new JButton("Εισαγωγη Βαθμολογιας");
    private final JButton dhlwshAlgorithmouButton = new JButton("Δηλωση Αλγοριθμου Τελικου Βαθμου");
    private final JButton prosthikiProapaitoumenouButton = new JButton("Προστθηκη Προαπαιτουμενου");
    private final JButton backButton = new JButton("Πισω");

    public ThewriaPageUI(ThewriaController controller, Thewria thewria) {
        this.controller = controller;
        prepareView(thewria);
    }

    private void prepareView(Thewria thewria) {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.GENERAL_BACKGROUND_COLOR);

        onomaThewrias.setFont(GeneralStyle.GENERAL_FONT);
        onomaKathigiti.setFont(GeneralStyle.GENERAL_FONT);
        eksamhno.setFont(GeneralStyle.GENERAL_FONT);
        sunoloFoititwn.setFont(GeneralStyle.GENERAL_FONT);

        ergasthria.setFont(GeneralStyle.GENERAL_FONT);
        proapaitoumena.setFont(GeneralStyle.GENERAL_FONT);

        ergasthria.setBackground(GeneralStyle.TEXT_AREA_BACKGROUND_COLOR);
        proapaitoumena.setBackground(GeneralStyle.TEXT_AREA_BACKGROUND_COLOR);

        onomaThewriasLabel.setFont(GeneralStyle.GENERAL_FONT);
        onomaKathigitiLabel.setFont(GeneralStyle.GENERAL_FONT);
        eksamhnoLabel.setFont(GeneralStyle.GENERAL_FONT);
        sunoloFoititwnLabel.setFont(GeneralStyle.GENERAL_FONT);
        ergasthriaLabel.setFont(GeneralStyle.GENERAL_FONT);
        proapaitoumenaLabel.setFont(GeneralStyle.GENERAL_FONT);

        eisagwghVathmwnButton.setFont(GeneralStyle.GENERAL_FONT);
        dhlwshAlgorithmouButton.setFont(GeneralStyle.GENERAL_FONT);
        prosthikiProapaitoumenouButton.setFont(GeneralStyle.GENERAL_FONT);
        backButton.setFont(GeneralStyle.GENERAL_FONT);

        onomaThewrias.setEditable(false);
        onomaKathigiti.setEditable(false);
        eksamhno.setEditable(false);
        sunoloFoititwn.setEditable(false);

        onomaThewriasLabel.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        onomaKathigitiLabel.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        eksamhnoLabel.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        sunoloFoititwnLabel.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        ergasthriaLabel.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        proapaitoumenaLabel.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        eisagwghVathmwnButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        dhlwshAlgorithmouButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        prosthikiProapaitoumenouButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        backButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);

        eisagwghVathmwnButton.setBackground(GeneralStyle.BUTTON_BACKGROUND_COLOR);
        dhlwshAlgorithmouButton.setBackground(GeneralStyle.BUTTON_BACKGROUND_COLOR);
        prosthikiProapaitoumenouButton.setBackground(GeneralStyle.BUTTON_BACKGROUND_COLOR);
        backButton.setBackground(GeneralStyle.LOGOUT_BACKGROUND_COLOR);

        eisagwghVathmwnButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dhlwshAlgorithmouButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        prosthikiProapaitoumenouButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        onomaThewriasLabel.setHorizontalAlignment(JLabel.RIGHT);
        onomaKathigitiLabel.setHorizontalAlignment(JLabel.RIGHT);
        eksamhnoLabel.setHorizontalAlignment(JLabel.RIGHT);
        sunoloFoititwnLabel.setHorizontalAlignment(JLabel.RIGHT);
        ergasthriaLabel.setHorizontalAlignment(JLabel.RIGHT);
        proapaitoumenaLabel.setHorizontalAlignment(JLabel.RIGHT);

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
        onomaKathigiti.setText(thewria.getKathigiti().getOnoma() + " " + thewria.getKathigiti().getEpwnhmo());
        eksamhno.setText(thewria.getEksamhno().toString());
        onomaThewrias.setText(thewria.getOnomaMathimatos());
        sunoloFoititwn.setText(thewria.getFoitites().size() + " φοιτιτες/τριες");

        GridBagConstraints backButtonConstraints = new GridBagConstraints();
        backButtonConstraints.gridx = 0;
        backButtonConstraints.gridy = 0;
        backButtonConstraints.gridwidth = 2;
        backButtonConstraints.fill = GridBagConstraints.BOTH;
        backButtonConstraints.anchor = GridBagConstraints.CENTER;
        backButtonConstraints.insets = new Insets(5, 10, 5, 5);
        backButtonConstraints.weightx = 1;
        backButtonConstraints.weighty = 1;

        add(backButton, backButtonConstraints);

        //IMPORTANT TO KEEP THE ORDER OF LABEL AND FIELD PAIR THE SAME
        JLabel[] labels = {onomaThewriasLabel,onomaKathigitiLabel,eksamhnoLabel,sunoloFoititwnLabel,proapaitoumenaLabel, ergasthriaLabel};
        Component[] fields = {onomaThewrias,onomaKathigiti,eksamhno,sunoloFoititwn,proapaitoumena,ergasthria};
        JButton[] buttons = {dhlwshAlgorithmouButton,eisagwghVathmwnButton,prosthikiProapaitoumenouButton};

        for (int row = 1; row < labels.length + 1; row++) {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = row;
            constraints.fill = GridBagConstraints.BOTH;
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.insets = new Insets(5, 10, 5, 5);
            constraints.weightx = 1;
            constraints.weighty = 1;
            add(labels[row - 1], constraints);

            constraints = new GridBagConstraints();
            constraints.gridx = 1;
            constraints.gridy = row;
            constraints.fill = GridBagConstraints.BOTH;
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.insets = new Insets(5, 5, 5, 5);
            constraints.weightx = 10;
            if (fields[row - 1] instanceof JList) {
                constraints.weighty = 10;
            } else {
                constraints.weighty = 1;
            }
            add(fields[row - 1], constraints);
        }

        for (int row = labels.length + 2; row < labels.length + 1 + buttons.length; row++) {
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = row;
            constraints.fill = GridBagConstraints.BOTH;
            constraints.anchor = GridBagConstraints.CENTER;
            constraints.insets = new Insets(5, 5, 5, 5);
            constraints.weightx = 1;
            constraints.weighty = 1;
            constraints.gridwidth = 2;
            add(buttons[row - (labels.length + 1) ], constraints);
        }

        backButton.addActionListener(this::backButtonClick);

    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }


}
