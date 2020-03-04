package com.omada.pithia.ui.view;

import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.ui.controller.EisagwghVathmologiasThewriasController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

public class EisagwghVathmologiasThewriasView extends JPanel {

    private final EisagwghVathmologiasThewriasController controller;

    private final JPanel inputs = new JPanel(new GridBagLayout());

    private final JScrollPane scrollPane ;

    private final JButton backButton ;

    private final JButton apothikeush ;

    private final List<InputVathmo> inputVathmoi = new ArrayList<>();

    public EisagwghVathmologiasThewriasView(EisagwghVathmologiasThewriasController controller) {
        this.controller = controller;
        this.scrollPane = new JScrollPane(inputs);
        this.backButton = new JButton(controller.getMessage("EisagwghVathmologiasThewrias.View.Back.Button",
                new Object[]{}));
        this.apothikeush = new JButton(controller.getMessage("EisagwghVathmologiasThewrias.View.Apothikeush.Button",
                new Object[]{}));
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setFont(backButton, apothikeush)
                .setForegroundAsWhite(backButton, apothikeush)
                .setBackgroundAsRed(backButton).setBackgroundAsBlue(apothikeush)
                .setCursorAsHand(backButton, apothikeush)
                .setBackgroundAsGrey(inputs);

        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        builder.setRow(0).setColumn(0).setFill(Utils.Fill.BOTH).setColumnWeight(1).setRowWeight(1)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 20, 5));
        add(backButton, builder.build());

        builder.reset().setRow(1).setColumn(0).setFill(Utils.Fill.BOTH).setColumnWeight(1).setRowWeight(1)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 20, 5));
        add(apothikeush, builder.build());
        Iterator<Foititis> iterator = controller.getFoitites().iterator();

        for (int row = 0; row < controller.getFoitites().size(); row++) {
            builder.reset().setRow(row).setColumn(0).setFill(Utils.Fill.BOTH).setColumnWeight(1).setRowWeight(1)
                    .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(10, 5, 10, 5));
            Foititis foititis = iterator.next();
            InputVathmo inputVathmo = new InputVathmo(foititis, controller.getCurrentVathmoThewrias(foititis));
            inputVathmoi.add(inputVathmo);
            inputs.add(inputVathmo, builder.build());
        }

        builder.reset().setRow(2).setColumn(0).setFill(Utils.Fill.BOTH).setColumnWeight(1).setRowWeight(20)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(scrollPane, builder.build());

        backButton.addActionListener(this::backButtonClick);
        apothikeush.addActionListener(this::apothikeushButtonClick);
    }

    private void apothikeushButtonClick(ActionEvent actionEvent) {
        Map<Foititis, Double> vathmoi = new HashMap<>();
        for (InputVathmo inputVathmos : inputVathmoi) {
            vathmoi.put(inputVathmos.getFoititis(), inputVathmos.getVathmo());
        }
        controller.requestForApothikeushVathmwn(vathmoi);
    }

    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }


}
