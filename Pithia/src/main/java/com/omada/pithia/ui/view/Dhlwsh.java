package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.DhlwshMathimatos;
import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Mathima;
import com.omada.pithia.model.mathimata.Thewria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Dhlwsh extends JPanel {

    private final JComboBox<String> ergasthriaComboBox;
    private final JLabel onomaThewrias ;
    private final JCheckBox checkBox = new JCheckBox("Δηλωση");
    private final Mathima mathima;
    private final Map<String, Ergasthrio> ergasthria = new HashMap<>();

    public Dhlwsh(Mathima mathima) {
        this.mathima = mathima;

        String[] ergasthriaStrings = new String[mathima.getErgasthria().size()];

        for (int index = 0; index < ergasthriaStrings.length; index++) {
            Ergasthrio currentErgasthrio = mathima.getErgasthria().get(index);
            ergasthriaStrings[index] = currentErgasthrio.getOnomaErgasthriou();
            ergasthria.put(currentErgasthrio.getOnomaErgasthriou(), currentErgasthrio);
        }

        ergasthriaComboBox = new JComboBox<>(ergasthriaStrings);
        onomaThewrias = new JLabel(mathima.getThewria().getOnomaMathimatos());
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();

        styleBuilder.setFont(ergasthriaComboBox, onomaThewrias, checkBox)
                .setForegroundAsWhite(ergasthriaComboBox, onomaThewrias, checkBox)
                .setBackgroundAsDark(this).setHorizontalAlignmentToRight(onomaThewrias)
                .setBackgroundAsGrey(ergasthriaComboBox,checkBox);

        onomaThewrias.setPreferredSize(new Dimension(200, 20));
        ergasthriaComboBox.setPreferredSize(new Dimension(300, 20));
        checkBox.setPreferredSize(new Dimension(100, 20));

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        builder.setRow(0).setColumn(0).setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH)
                .setRowWeight(1).setColumnWeight(5).setInsets(new Insets(5, 5, 5, 5));
        add(onomaThewrias, builder.build());

        builder.reset().setRow(0).setColumn(1).setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH)
                .setRowWeight(1).setColumnWeight(5).setInsets(new Insets(5,5,5,5));
        add(ergasthriaComboBox, builder.build());

        builder.reset().setRow(0).setColumn(2).setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.BOTH)
                .setRowWeight(1).setColumnWeight(1).setInsets(new Insets(5, 5, 5, 5));
        add(checkBox, builder.build());

        if (ergasthria.size() > 0) {
            ergasthriaComboBox.setSelectedIndex(0);
        }
    }

    public boolean einaiDhlwmeno(){
        return checkBox.isSelected();
    }

    public DhlwshMathimatos getDhlwsh() {
        Optional<Ergasthrio> ergasthrio = Optional.empty();

        if (ergasthria.size() > 0) {
            ergasthrio = Optional.of(ergasthria.get(ergasthriaComboBox.getItemAt(ergasthriaComboBox.getSelectedIndex())));
        }

        return new DhlwshMathimatos(mathima.getThewria(), ergasthrio);
    }
}
