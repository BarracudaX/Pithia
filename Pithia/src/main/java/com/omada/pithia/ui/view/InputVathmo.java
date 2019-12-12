package com.omada.pithia.ui.view;

import com.omada.pithia.model.xrhstes.Foititis;

import javax.swing.*;
import java.awt.*;

class InputVathmo extends JPanel {

    private final Foititis foititis;

    private final JLabel onomaLabel ;

    private final JTextField vathmosInput = new JTextField();

    private volatile double vathmos;

    public InputVathmo(Foititis foititis, double vathmos) {
        this.foititis = foititis;
        this.onomaLabel = new JLabel(foititis.getOnomaXrhsth() + "(" + foititis.getEpwnhmo() + " " + foititis.getOnoma() + "):");
        this.vathmos = vathmos;
        this.vathmosInput.setText(String.valueOf(vathmos));
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setFont(onomaLabel, vathmosInput).setForegroundAsWhite(onomaLabel, vathmosInput)
                .setBackgroundAsGrey(vathmosInput).setHorizontalAlignmentToCenter(onomaLabel).setTextFieldSize(vathmosInput);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        builder.setColumn(0).setRow(0).setInsets(new Insets(5,5,5,20)).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setColumnWeight(1);
        onomaLabel.setPreferredSize(new Dimension(250,30));
        add(onomaLabel, builder.build());

        builder.setColumn(1).setRow(0).setInsets(new Insets(5,5,5,5)).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setColumnWeight(10);
        add(vathmosInput, builder.build());
    }

    public double getVathmo(){

        try {
            return Double.parseDouble(vathmosInput.getText());
        } catch (NumberFormatException e) {

        }

        return -1.0;
    }

}
