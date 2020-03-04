package com.omada.pithia.ui.view;

import com.omada.pithia.ui.controller.LanguageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

public class LanguageView extends JPanel {

    private final LanguageController controller;

    private final JButton enButton ;
    private final JButton grButton ;
    private final JLabel chooseLanguageLabel = new JLabel("Choose Your Language");


    public LanguageView(LanguageController controller) {
        this.controller = controller;

        enButton = new JButton("English");
        grButton = new JButton("Ελληνικά");
        initView();
    }

    private void initView() {
        setLayout(new GridBagLayout());

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setBackgroundAsDark(this)
                .setFont(enButton,grButton,chooseLanguageLabel)
                .setForegroundAsWhite(enButton,grButton,chooseLanguageLabel)
                .setCursorAsHand(enButton,grButton)
                .setBackgroundAsBlue(enButton,grButton);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();

        builder.setRow(0).setColumn(0).setInsets(new Insets(10,10,10,10))
                .setFill(Utils.Fill.HORIZONTAL).setAnchor(Utils.Anchor.CENTER);
        add(chooseLanguageLabel, builder.build());

        builder.reset().setRow(1).setColumn(0).setInsets(new Insets(10,10,10,10))
                .setFill(Utils.Fill.HORIZONTAL).setAnchor(Utils.Anchor.CENTER);
        add(enButton, builder.build());

        builder.reset().setRow(2).setColumn(0).setInsets(new Insets(10,10,10,10))
                .setFill(Utils.Fill.HORIZONTAL).setAnchor(Utils.Anchor.CENTER);
        add(grButton, builder.build());

        enButton.addActionListener(this::enButtonClick);
        grButton.addActionListener(this::grButtonClick);
    }

    private void grButtonClick(ActionEvent actionEvent) {
        controller.grChoose();
    }

    private void enButtonClick(ActionEvent actionEvent) {
        controller.enChoose();
    }


}
