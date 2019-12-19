package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Eksamhno;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.ui.controller.ProapaitoumenaController;
import com.omada.pithia.ui.controller.ProsthikiThewriasController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ProsthikiThewriasPageUI extends JPanel {

    private final ProsthikiThewriasController controller;

    private final JComboBox<String> kathigites ;
    private final JComboBox<String> eksamhhna;
    private final JTextField onomaThewrias = new JTextField();

    private final JLabel kathigitesLabel = new JLabel("Καθηγητες:");
    private final JLabel eksamhnoLabel = new JLabel("Εξαμηνο:");
    private final JLabel onomaThewriasLabel = new JLabel("Ονομα Θεωριας:");
    private final JLabel proapaitoumenaLabel = new JLabel("Πιθανα Προαπαιτουμενα");
    private final JLabel epilogesLabel = new JLabel("Οι Επιλογες Σας");

    private final JButton backButton = new JButton("Πισω");
    private final JButton prosthikiButton = new JButton("Προσθηκη Θεωριας");
    private final JButton addButton = new JButton("Προσθηκη Προαπαιτουμενου");
    private final JButton removeButton = new JButton("Αφαιρεση Προαπαιτουμενου");


    private final DefaultListModel<String> pithanaProapaitoumenaModel = new DefaultListModel<>();
    private final DefaultListModel<String> epilogesModel = new DefaultListModel<>();
    private final JList<String> pithanaProapaitoumena ;
    private final JList<String> epiloges ;
    private final JScrollPane proapaitoumenaScrollPane ;
    private final JScrollPane epilogesScrollPane ;

    public ProsthikiThewriasPageUI(ProsthikiThewriasController controller) {
        this.controller = controller;
        this.kathigites = new JComboBox<>(controller.getKathigites());
        this.eksamhhna = new JComboBox<>(controller.getEksamhna());
        this.pithanaProapaitoumena = new JList<>(pithanaProapaitoumenaModel);
        this.epiloges = new JList<>(epilogesModel);

        this.proapaitoumenaScrollPane = new JScrollPane(pithanaProapaitoumena);
        this.epilogesScrollPane = new JScrollPane(epiloges);

        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder
                .setFont(
                        kathigites,kathigitesLabel,eksamhhna,eksamhnoLabel,addButton,removeButton
                        ,onomaThewrias,onomaThewriasLabel,backButton,prosthikiButton,
                        proapaitoumenaLabel,epilogesLabel
                )
                .setForegroundAsWhite(
                        kathigites,kathigitesLabel,eksamhhna,addButton,removeButton,
                        eksamhnoLabel,onomaThewrias,onomaThewriasLabel,backButton,prosthikiButton,
                        proapaitoumenaLabel,epilogesLabel,pithanaProapaitoumena,epiloges
                )
                .setBackgroundAsGrey(kathigites,eksamhhna,onomaThewrias)
                .setTextFieldSize(onomaThewrias)
                .setCursorAsHand(backButton,prosthikiButton,addButton,removeButton)
                .setHorizontalAlignmentToRight(eksamhnoLabel,kathigitesLabel,onomaThewriasLabel)
                .setBackgroundAsDark(this)
                .setBackgroundAsGrey(pithanaProapaitoumena,epiloges)
                .setBackgroundAsBlue(prosthikiButton,addButton)
                .setBackgroundAsRed(backButton,removeButton)
                .setHorizontalAlignmentToCenter(proapaitoumenaLabel,epilogesLabel);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();


        builder.setColumn(0).setRow(0).setColumnWeight(1).setColumnWidth(3)
                .setRowWeight(1).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 10, 5));
        add(backButton, builder.build());

        builder.reset().setColumn(0).setRow(1).setColumnWeight(1).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 10));
        add(kathigitesLabel, builder.build());

        builder.reset().setColumn(1).setRow(1).setColumnWeight(10).setColumnWidth(2).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(kathigites, builder.build());

        builder.reset().setColumn(0).setRow(2).setColumnWeight(1).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 10));
        add(eksamhnoLabel, builder.build());

        builder.reset().setColumn(1).setRow(2).setColumnWeight(10).setColumnWidth(2).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(eksamhhna, builder.build());

        builder.reset().setColumn(0).setRow(3).setColumnWeight(1).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 10));
        add(onomaThewriasLabel, builder.build());

        builder.reset().setColumn(1).setRow(3).setColumnWeight(10).setColumnWidth(2).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(onomaThewrias, builder.build());

        builder.reset().setColumn(0).setRow(4).setColumnWeight(1).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(proapaitoumenaLabel, builder.build());

        builder.reset().setColumn(2).setRow(4).setColumnWeight(1).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(epilogesLabel, builder.build());

        builder.reset().setColumn(0).setRow(5).setColumnWeight(10).setFill(Utils.Fill.BOTH)
                .setRowWeight(15).setRowWidth(2)
                .setAnchor(Utils.Anchor.CENTER)
                .setInsets(new Insets(5, 5, 5, 5));
        add(proapaitoumenaScrollPane, builder.build());

        builder.reset().setColumn(1).setRowWeight(5).setRow(5).setColumnWeight(1).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(addButton, builder.build());

        builder.reset().setColumn(1).setRowWeight(5).setRow(6).setColumnWeight(1).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(removeButton, builder.build());

        builder.reset().setColumn(2).setRow(5).setColumnWeight(10).setFill(Utils.Fill.BOTH)
                .setRowWeight(15).setRowWidth(2)
                .setAnchor(Utils.Anchor.CENTER)
                .setInsets(new Insets(5, 5, 5, 5));
        add(epilogesScrollPane, builder.build());


        builder.reset().setColumn(0).setRowWeight(1).setColumnWidth(3).setRow(7)
                .setColumnWeight(1).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(prosthikiButton, builder.build());

        backButton.addActionListener(this::backButtonClick);
        addButton.addActionListener(this::addButtonClick);
        removeButton.addActionListener(this::removeButtonClick);
        eksamhhna.addActionListener(this::switchEksamhno);
        prosthikiButton.addActionListener(this::prosthikiButtonClick);

        eksamhhna.setSelectedIndex(0);
        kathigites.setSelectedIndex(0);
    }

    private void prosthikiButtonClick(ActionEvent actionEvent) {
        String kathigitis = kathigites.getItemAt(kathigites.getSelectedIndex());
        Eksamhno eksamhno = Eksamhno.valueOf(eksamhhna.getItemAt(eksamhhna.getSelectedIndex()));
        String onomaThewrias = this.onomaThewrias.getText();
        List<String> proapaitoumena = getProapaitoumena();

        controller.requestForProsthikiThewrias(kathigitis, eksamhno, onomaThewrias, proapaitoumena);
    }

    private List<String> getProapaitoumena() {
        List<String> proapaitoumena = new ArrayList<>();

        while (!epilogesModel.isEmpty()) {
            proapaitoumena.add(epilogesModel.getElementAt(0));
            epilogesModel.removeElementAt(0);
        }

        return proapaitoumena;
    }

    private void switchEksamhno(ActionEvent actionEvent) {
        Eksamhno eksamhno = Eksamhno.valueOf(eksamhhna.getItemAt(eksamhhna.getSelectedIndex()));
        updateProapaitoumena(controller.getProapaitoumena(eksamhno));
    }

    private void updateProapaitoumena(List<Thewria> proapaitoumena) {
        pithanaProapaitoumenaModel.removeAllElements();
        epilogesModel.removeAllElements();
        for (Thewria proapaitoumeno : proapaitoumena) {
            pithanaProapaitoumenaModel.addElement(proapaitoumeno.getOnomaMathimatos());
        }
    }

    private void removeButtonClick(ActionEvent actionEvent) {
        int selectedIndex = epiloges.getSelectedIndex();
        if (selectedIndex > -1) {
            String item = epilogesModel.get(selectedIndex);
            epilogesModel.removeElementAt(selectedIndex);
            pithanaProapaitoumenaModel.addElement(item);
        }
    }

    private void addButtonClick(ActionEvent actionEvent) {
        int selectedIndex = pithanaProapaitoumena.getSelectedIndex();
        if (selectedIndex > -1) {
            String item = pithanaProapaitoumenaModel.get(selectedIndex);
            pithanaProapaitoumenaModel.removeElementAt(selectedIndex);
            epilogesModel.addElement(item);
        }
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }



}
