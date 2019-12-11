package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.ui.controller.ErgasthrioController;

import javax.swing.*;

public class ErgasthrioPageUI extends JPanel {

    private final ErgasthrioController controller;

    private final Ergasthrio ergasthrio;

    private final JLabel onomaMathimatosLabel = new JLabel("Ονομα Μαθηματος:");
    private final JLabel onomaMathimatosThewriasLabel = new JLabel("Ονομα Μαθηματος Θεωριας:");
    private final JLabel onomaKathigitiLabel = new JLabel("Ονομα Καθηγητη:");
    private final JLabel eksamhnoLabel = new JLabel("Εξαμηνο:");
    private final JLabel arithmosFoititwnLabel = new JLabel("Αριθμος Φοιτητων:");
    private final JButton eisagwghVathmologias = new JButton("Εισαγωγη Βαθμολογιας");
    private final JButton prosthikiFoititi = new JButton("Προσθηκη Φοιτητων Στο Εργαστηριο");
    private final JButton apousies = new JButton("Διαχειριση Απουσιων");
    private final JTextField onomaMathimatos = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JTextField onomaMathimatosThewrias = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JTextField onomaKathigiti = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JTextField eksamhno = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JTextField arithmosFoititwn = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);


    public ErgasthrioPageUI(ErgasthrioController controller, Ergasthrio ergasthrio) {
        this.controller = controller;
        this.ergasthrio = ergasthrio;
        prepareView();
    }

    private void prepareView() {

    }

}
