package com.omada.pithia.ui.view;

import com.omada.pithia.model.xrhstes.Foititis;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.text.NumberFormat;

class InputVathmo extends JPanel {

    private final Foititis foititis;

    private final JLabel onomaLabel ;

    private volatile JFormattedTextField vathmosInput ;

    private volatile double vathmos;

    public InputVathmo(Foititis foititis, double vathmos) {
        this.foititis = foititis;
        this.onomaLabel = new JLabel(foititis.getOnomaXrhsth() + "(" + foititis.getEpwnhmo() + " " + foititis.getOnoma() + "):");
        this.vathmos = vathmos;
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMinimumIntegerDigits(1);
        format.setMaximumIntegerDigits(2);
        format.setMaximumFractionDigits(1);

        vathmosInput = new JFormattedTextField(format);
        this.vathmosInput.setValue(vathmos);

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
        vathmosInput.addPropertyChangeListener("value",this::vathmosChanged);
    }

    private void vathmosChanged(PropertyChangeEvent propertyChangeEvent) {
        Object source = propertyChangeEvent.getSource();
        if (source == vathmosInput) {
            double vathmos = ((Number) vathmosInput.getValue()).doubleValue();
            if (vathmos < 0 || vathmos > 10) {
                vathmosInput.setBackground(GeneralStyle.RED_LIGHT_COLOR);
            }else{
                vathmosInput.setBackground(GeneralStyle.GREY_COLOR);
                this.vathmos = vathmos;
            }
        }
    }

    public final double getVathmo(){
        return vathmos;
    }

    public final Foititis getFoititis(){
        return foititis;
    }
}
