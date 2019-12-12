package com.omada.pithia.ui.view;

import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.ui.controller.EisagwghVathmologiasErgasthrioController;
import com.omada.pithia.ui.controller.EisagwghVathmologiasThewriasController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Iterator;

public class EisagwghVathmologiasErgasthrioPageUI extends JPanel  {


    private final EisagwghVathmologiasErgasthrioController controller;

    private final JPanel inputs = new JPanel(new GridBagLayout());

    private final JScrollPane scrollPane ;

    private final JButton backButton = new JButton("Πισω");

    private final JButton apothikeush = new JButton("Αποθηκευση");


    public EisagwghVathmologiasErgasthrioPageUI(EisagwghVathmologiasErgasthrioController controller) {
        this.controller = controller;
        this.scrollPane = new JScrollPane(inputs);
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setFont(backButton, apothikeush).setForegroundAsWhite(backButton, apothikeush)
                .setBackgroundAsRed(backButton).setBackgroundAsBlue(apothikeush).setCursorAsHand(backButton, apothikeush)
                .setBackgroundAsGrey(inputs);

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        builder.setRow(0).setColumn(0).setFill(Utils.Fill.BOTH).setColumnWeight(1).setRowWeight(1)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 20, 5));
        add(backButton, builder.build());

        builder.setRow(1).setColumn(0).setFill(Utils.Fill.BOTH).setColumnWeight(1).setRowWeight(1)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 20, 5));
        add(apothikeush, builder.build());

        Iterator<Foititis> iterator = controller.getFoitites().iterator();

        for (int row = 2; row < controller.getFoitites().size()+ 2; row++) {
            builder.setRow(row).setColumn(0).setFill(Utils.Fill.BOTH).setColumnWeight(1).setRowWeight(1)
                    .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(10, 5, 10, 5));
            Foititis foititis = iterator.next();
            inputs.add(new InputVathmo(foititis,controller.getCurrentVathmoErgasthriou(foititis)),builder.build());
        }

        builder.reset().setRow(controller.getFoitites().size()+1).setColumn(0).setFill(Utils.Fill.BOTH).setColumnWeight(1).setRowWeight(15)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(scrollPane, builder.build());

        backButton.addActionListener(this::backButtonClick);
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }

}
