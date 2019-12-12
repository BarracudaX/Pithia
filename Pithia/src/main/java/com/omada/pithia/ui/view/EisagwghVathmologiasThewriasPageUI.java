package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.ui.controller.EisagwghVathmologiasThewriasController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EisagwghVathmologiasThewriasPageUI extends JPanel {

    private final EisagwghVathmologiasThewriasController controller;

    private final JPanel inputs = new JPanel(new GridBagLayout());

    private final JScrollPane scrollPane ;

    private final JButton backButton = new JButton("Πισω");

    private final JButton apothikeush = new JButton("Αποθηκευση");

    private final JLabel anazhthshLabel = new JLabel("Ονομα Χρηστη: ");

    private final JButton anazhthsh = new JButton("Αναζητηση");

    private final JTextField anazhthshInput = new JTextField();

    public EisagwghVathmologiasThewriasPageUI(EisagwghVathmologiasThewriasController controller) {
        this.controller = controller;
        this.scrollPane = new JScrollPane(inputs);
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setFont(backButton, apothikeush, anazhthsh, anazhthshInput)
                .setForegroundAsWhite(backButton, apothikeush, anazhthsh, anazhthshLabel)
                .setBackgroundAsRed(backButton).setBackgroundAsBlue(apothikeush, anazhthsh)
                .setCursorAsHand(backButton, apothikeush, anazhthsh)
                .setBackgroundAsGrey(inputs, anazhthshInput)
                .setHorizontalAlignmentToRight(anazhthshLabel)
                .setTextFieldSize(anazhthshInput);

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        builder.setRow(0).setColumn(0).setColumnWidth(3).setFill(Utils.Fill.BOTH).setColumnWeight(1).setRowWeight(1)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 20, 5));
        add(backButton, builder.build());

        builder.reset().setRow(1).setColumn(0).setColumnWidth(3).setFill(Utils.Fill.BOTH).setColumnWeight(1).setRowWeight(1)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 20, 5));
        add(apothikeush, builder.build());

        builder.reset().setRow(2).setColumn(0).setColumnWeight(1).setFill(Utils.Fill.BOTH).setRowWeight(1).setAnchor(Utils.Anchor.CENTER)
                .setInsets(new Insets(5, 5, 5, 10));
        add(anazhthshLabel, builder.build());

        builder.reset().setRow(2).setColumn(1).setColumnWeight(20).setFill(Utils.Fill.BOTH).setRowWeight(1).setAnchor(Utils.Anchor.CENTER)
                .setInsets(new Insets(5, 5, 5, 5));
        add(anazhthshInput, builder.build());

        builder.reset().setRow(2).setColumn(2).setColumnWeight(5).setFill(Utils.Fill.BOTH).setRowWeight(1).setAnchor(Utils.Anchor.CENTER)
                .setInsets(new Insets(5, 5, 5, 5));
        add(anazhthsh, builder.build());

        Iterator<Foititis> iterator = controller.getFoitites().iterator();

        for (int row = 0; row < controller.getFoitites().size(); row++) {
            builder.reset().setRow(row).setColumn(0).setFill(Utils.Fill.BOTH).setColumnWeight(1).setRowWeight(1)
                    .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(10, 5, 10, 5));
            Foititis foititis = iterator.next();
            inputs.add(new InputVathmo(foititis,controller.getCurrentVathmoThewrias(foititis)),builder.build());
        }

        builder.reset().setRow(3).setColumn(0).setColumnWidth(3).setFill(Utils.Fill.BOTH).setColumnWeight(1).setRowWeight(20)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(scrollPane, builder.build());

        backButton.addActionListener(this::backButtonClick);
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }

}
