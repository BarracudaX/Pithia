package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.service.ThewriesService;
import com.omada.pithia.ui.controller.ProapaitoumenaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProapaitoumenaPageUI extends JPanel {

    private final ProapaitoumenaController controller;

    private final Map<String, Thewria> proapaitoumenaMap = new HashMap<>();

    private final JButton backButton = new JButton("Πισω");
    private final JButton addButton = new JButton("Μετακινηση Σστην Λιστα Επιλογων");
    private final JButton removeButton = new JButton("Αφαιρεση Απο Την Λιστα");
    private final JButton finishButton = new JButton("Τελικη Αποθηκευση");
    private final JList<String> proapaitoumena = new JList<>();
    private final JList<String> epiloges = new JList<>();
    private final DefaultListModel<String> proapaitoumenaModel = new DefaultListModel<>();
    private final DefaultListModel<String> epilogesModel = new DefaultListModel<>();
    private final JLabel proapaitoumenaLabel = new JLabel("Πιθανα Προαπαιτουμενα.");
    private final JLabel epilogesLabel = new JLabel("Επιλογες Σας");

    public ProapaitoumenaPageUI(ProapaitoumenaController controller) {
        this.controller = controller;
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setCursorAsHand(backButton, addButton, removeButton, finishButton)
                .setFont(backButton, addButton, removeButton, finishButton, proapaitoumena, epiloges)
                .setBackgroundAsBlue(addButton, finishButton).setBackgroundAsRed(backButton, removeButton)
                .setHorizontalAlignmentToCenter(epilogesLabel, proapaitoumenaLabel)
                .setForegroundAsWhite(
                        backButton, addButton, removeButton, finishButton, proapaitoumena, epiloges, epilogesLabel, proapaitoumenaLabel)
                .setBackgroundAsGrey(epiloges, proapaitoumena);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        builder.setColumn(0).setRow(0).setColumnWidth(3).setRowWeight(1).setColumnWeight(1)
                .setFill(Utils.Fill.BOTH).setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 20, 5));
        add(backButton, builder.build());

        builder.reset().setColumn(0).setRow(1).setColumnWeight(0).setRowWeight(0).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(proapaitoumenaLabel, builder.build());

        builder.reset().setColumn(2).setRow(1).setColumnWeight(0).setRowWeight(0).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(epilogesLabel, builder.build());

        builder.reset().setRowWidth(2).setColumn(0).setRow(2).setColumnWeight(10).setRowWeight(15).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        proapaitoumena.setPreferredSize(new Dimension(200,300));
        add(proapaitoumena, builder.build());

        builder.reset().setColumn(1).setRow(2).setColumnWeight(1).setRowWeight(5).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 10, 5, 10));
        add(addButton, builder.build());

        builder.reset().setColumn(1).setRow(3).setColumnWeight(1).setRowWeight(5).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 10, 5, 10));
        add(removeButton, builder.build());

        builder.reset().setRowWidth(2).setColumn(2).setRow(2).setColumnWeight(10).setRowWeight(15).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        epiloges.setPreferredSize(new Dimension(200,300));
        add(epiloges, builder.build());

        builder.setColumn(0).setRow(4).setColumnWidth(3).setRowWeight(1).setColumnWeight(1)
                .setFill(Utils.Fill.BOTH).setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(20, 5, 5, 5));
        add(finishButton, builder.build());

        for (Thewria proapaitoumeno : controller.getProapaitoumena()) {
            proapaitoumenaMap.put(proapaitoumeno.getOnomaMathimatos(), proapaitoumeno);
            proapaitoumenaModel.addElement(proapaitoumeno.getOnomaMathimatos());
        }

        proapaitoumena.setModel(proapaitoumenaModel);

        epiloges.setModel(epilogesModel);

        backButton.addActionListener(this::backButtonClick);
        addButton.addActionListener(this::addButtonClick);
        removeButton.addActionListener(this::removeButtonClick);
        finishButton.addActionListener(this::finishButtonClick);
    }

    private void finishButtonClick(ActionEvent actionEvent) {
        List<Thewria> telikaProapaitoumena = new ArrayList<>();

        List<String> epiloges = new ArrayList<>();

        while (!epilogesModel.isEmpty()) {
            epiloges.add(epilogesModel.firstElement());
            epilogesModel.removeElementAt(0);
        }

        for (String epilogh : epiloges) {
            telikaProapaitoumena.add(proapaitoumenaMap.get(epilogh));
        }

        controller.requestForProsthikiProapaitoumenwn(telikaProapaitoumena);
    }

    private void removeButtonClick(ActionEvent actionEvent) {
        int selectedIndex = epiloges.getSelectedIndex();
        if (selectedIndex > -1) {
            proapaitoumenaModel.addElement(epiloges.getSelectedValue());
            epilogesModel.removeElementAt(selectedIndex);
        }
    }

    private void addButtonClick(ActionEvent actionEvent) {
        int selectedIndex = proapaitoumena.getSelectedIndex();
        if (selectedIndex > -1) {
            epilogesModel.addElement(proapaitoumena.getSelectedValue());
            proapaitoumenaModel.removeElementAt(selectedIndex);
        }
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }


}
