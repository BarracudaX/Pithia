package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.DhlwshMathimatos;
import com.omada.pithia.model.mathimata.Mathima;
import com.omada.pithia.ui.controller.DhlwshMathimatwnController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class DhlwshMathimatwnView extends JPanel {

    private final DhlwshMathimatwnController controller;

    private final JButton backButton = new JButton("Πισω");
    private final JButton ypovolhButton = new JButton("Υποβολη Δηλωσης");
    private final JPanel dhlwshsJpanel = new JPanel(new GridBagLayout());
    private final List<Dhlwsh> dhlwshs = new ArrayList<>();
    private final JScrollPane dhlwshScrollPane;

    public DhlwshMathimatwnView(DhlwshMathimatwnController controller) {
        this.controller = controller;
        this.dhlwshScrollPane = new JScrollPane(dhlwshsJpanel);
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setFont(backButton, ypovolhButton)
                .setBackgroundAsDark(this,dhlwshsJpanel).setBackgroundAsRed(backButton)
                .setBackgroundAsBlue(ypovolhButton).setCursorAsHand(backButton, ypovolhButton)
                .setForegroundAsWhite(backButton, ypovolhButton);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();

        builder.setRow(0).setColumn(0).setRowWeight(1).setColumnWeight(1).setAnchor(Utils.Anchor.CENTER)
                .setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5));
        add(backButton, builder.build());

        builder.reset().setRow(1).setColumn(0).setColumnWeight(1).setRowWeight(30)
                .setInsets(new Insets(5, 5, 5, 5)).setFill(Utils.Fill.BOTH).setAnchor(Utils.Anchor.CENTER);
        add(dhlwshScrollPane, builder.build());

        builder.setRow(2).setColumn(0).setRowWeight(1).setColumnWeight(1).setAnchor(Utils.Anchor.CENTER)
                .setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5));
        add(ypovolhButton, builder.build());

        List<Mathima> mathimata = controller.getMathimata();

        int row = 0;

        for (Mathima mathima : mathimata) {
            Dhlwsh dhlwsh = new Dhlwsh(mathima);
            dhlwshs.add(dhlwsh);
            builder.reset().setRow(row++).setColumn(0).setColumnWeight(1).setRowWeight(1)
                    .setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                    .setAnchor(Utils.Anchor.CENTER);
            dhlwshsJpanel.add(dhlwsh, builder.build());
        }

        dhlwshScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        dhlwshScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        backButton.addActionListener(this::backButtonClick);
        ypovolhButton.addActionListener(this::ypovolhButtonClick);
    }

    private void ypovolhButtonClick(ActionEvent actionEvent) {
        List<DhlwshMathimatos> dhlwmenaMathimata = new ArrayList<>();

        for (Dhlwsh dhlwsh : dhlwshs) {
            if (dhlwsh.einaiDhlwmeno()) {
                dhlwmenaMathimata.add(dhlwsh.getDhlwsh());
            }
        }
        controller.requestForDhlwshMathimatwn(dhlwmenaMathimata);
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }

}
