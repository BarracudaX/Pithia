package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Apousia;
import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.ui.controller.DiaxeirishApousiwnController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class InputApousia extends JPanel {

    private final Foititis foititis;
    private final Apousia apousies;
    private final DiaxeirishApousiwnController controller;

    private final JTextField input = new JTextField();
    private final JLabel label ;
    private final JButton aukshsh ;
    private final JButton meiwsh ;

    public InputApousia(Foititis foititis, Apousia apousies, DiaxeirishApousiwnController controller) {
        this.foititis = foititis;
        this.apousies = apousies;
        this.controller = controller;
        label = new JLabel(foititis.getOnomaXrhsth() + "(" + foititis.getEpwnhmo() + " " + foititis.getOnoma() + ")");
        this.aukshsh = new JButton(
                controller.getMessage("InputApousia.View.Aukshsh.Button", new Object[]{})
        );
        this.meiwsh = new JButton(
                controller.getMessage("InputApousia.View.Meiwsh.Button", new Object[]{})
        );
        prepareView();
    }

    private void prepareView() {
        setBackground(GeneralStyle.DARK_COLOR);
        setLayout(new GridBagLayout());

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setTextFieldSize(input).setBackgroundAsGrey(input).setFont(input,label,aukshsh,meiwsh)
                .setBackgroundAsBlue(aukshsh,meiwsh).setForegroundAsWhite(input,label,aukshsh,meiwsh)
                .setHorizontalAlignmentToRight(label).setNotEditable(input).setCursorAsHand(aukshsh,meiwsh)
                .setCursorAsHand(aukshsh,meiwsh);

        label.setPreferredSize(new Dimension(200, 50));
        input.setText(String.valueOf(apousies.getArithmosApousiwn()));

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        builder.setRow(0).setColumn(0).setColumnWeight(1).setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH)
                .setInsets(new Insets(5, 5, 5, 10));
        add(label, builder.build());

        builder.reset().setRow(0).setColumn(1).setColumnWeight(5).setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH)
                .setInsets(new Insets(5, 5, 5, 10));
        add(input, builder.build());

        builder.reset().setRow(0).setColumn(2).setColumnWeight(3).setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH)
                .setInsets(new Insets(5, 5, 5, 10));
        add(aukshsh, builder.build());

        builder.reset().setRow(0).setColumn(3).setColumnWeight(3).setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH)
                .setInsets(new Insets(5, 5, 5, 5));
        add(meiwsh, builder.build());

        aukshsh.addActionListener(this::aukshshButtonClick);
        meiwsh.addActionListener(this::meiwshButtonClick);
    }

    private void meiwshButtonClick(ActionEvent actionEvent) {
        apousies.meiwshApousiwn();
        input.setText(String.valueOf(apousies.getArithmosApousiwn()));

    }

    private void aukshshButtonClick(ActionEvent actionEvent) {
        apousies.aukshshApousiwn();
        input.setText(String.valueOf(apousies.getArithmosApousiwn()));
    }

}
