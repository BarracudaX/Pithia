package com.omada.pithia.ui.view;

import com.omada.pithia.model.xrhstes.Rolos;
import com.omada.pithia.service.XrhstesService;
import com.omada.pithia.ui.controller.ViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static com.omada.pithia.ui.view.GeneralStyle.*;

public class HomePageUI extends JPanel {

    private final JButton homeButton;
    private final JButton mathimataMouButton ;
    private final JButton dhlwshMathimatwnButton;
    private final JButton prosthikiMathimatosButton;
    private final JButton katastashButton;
    private final JButton foititesButton;
    private final JButton logariasmosButton;
    private final JButton logoutButton;


    private final ViewController controller;

    private final XrhstesService xrhstesService;


    public HomePageUI(ViewController controller, XrhstesService xrhstesService) {
        this.controller = controller;
        this.xrhstesService = xrhstesService;

        homeButton = new JButton("Αρχικη");
        mathimataMouButton = new JButton("Μαθηματα μου");
        dhlwshMathimatwnButton = new JButton("Δηλωση Μαθηματων");
        prosthikiMathimatosButton = new JButton("Προσθηκη Μαθηματος");
        katastashButton = new JButton("Κατάσταση");
        foititesButton = new JButton("Διαχειριση Φοιτητων");
        logariasmosButton = new JButton("Ο Λογαριασμος μου");
        logoutButton = new JButton("Logout");

        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(DARK_COLOR);

        GeneralStyleBuilder styleBuilder = new GeneralStyleBuilder();
        styleBuilder.setBackgroundAsBlue(
                    homeButton,mathimataMouButton,prosthikiMathimatosButton,katastashButton,dhlwshMathimatwnButton,
                    foititesButton,logariasmosButton
                ).setBackgroundAsRed(logoutButton).setForegroundAsWhite(
                        homeButton,mathimataMouButton,prosthikiMathimatosButton,
                        katastashButton,dhlwshMathimatwnButton,foititesButton,logariasmosButton,logoutButton
                ).setFont(homeButton,mathimataMouButton,prosthikiMathimatosButton,katastashButton,dhlwshMathimatwnButton,foititesButton,
                        logariasmosButton,logoutButton
                ).setCursorAsHand(
                        homeButton,mathimataMouButton,prosthikiMathimatosButton,katastashButton,dhlwshMathimatwnButton,foititesButton,
                        logariasmosButton,logoutButton
                );

        homeButton.addActionListener(this::homeButtonClick);
        mathimataMouButton.addActionListener(this::mathimataMouClick);
        prosthikiMathimatosButton.addActionListener(this::prosthikiMathimatosClick);
        katastashButton.addActionListener(this::katastashClick);
        dhlwshMathimatwnButton.addActionListener(this::dhlwshMathimatwnClick);
        foititesButton.addActionListener(this::foititesClick);
        logariasmosButton.addActionListener(this::logariasmosMouClick);
        logoutButton.addActionListener(this::logoutClick);

        int row = 0;

        Utils.GridBagConstraintBuilder gridBagConstraintBuilder = new Utils.GridBagConstraintBuilder().setColumn(0).setRow(row++).setAnchor(Utils.Anchor.CENTER)
                .setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                .setColumnWeight(1).setRowWeight(1);

        GridBagConstraints constraints = gridBagConstraintBuilder.build();
        add(homeButton, constraints);

        gridBagConstraintBuilder.setRow(row++);
        constraints = gridBagConstraintBuilder.build();
        add(logariasmosButton, constraints);

        if (xrhstesService.getLoginXrhsth().hasRole(Rolos.FOITITIS)) {
            gridBagConstraintBuilder.setRow(row++);
            constraints = gridBagConstraintBuilder.build();
            add(katastashButton, constraints);

            gridBagConstraintBuilder.setRow(row++);
            constraints = gridBagConstraintBuilder.build();
            add(dhlwshMathimatwnButton, constraints);
        }

        if (xrhstesService.getLoginXrhsth().hasRole(Rolos.KATHIGITIS)) {
            gridBagConstraintBuilder.setRow(row++);
            constraints = gridBagConstraintBuilder.build();
            add(mathimataMouButton, constraints);
        }

        if (xrhstesService.getLoginXrhsth().hasRole(Rolos.DIAXEIRISTIS)) {
            gridBagConstraintBuilder.setRow(row++);
            constraints = gridBagConstraintBuilder.build();
            add(prosthikiMathimatosButton, constraints);

            gridBagConstraintBuilder.setRow(row++);
            constraints = gridBagConstraintBuilder.build();
            add(foititesButton, constraints);
        }
        gridBagConstraintBuilder.setRow(row++);
        constraints = gridBagConstraintBuilder.build();
        add(logoutButton, constraints);
    }

    private void logoutClick(ActionEvent actionEvent) {
        controller.requestForLogout();
    }

    private void logariasmosMouClick(ActionEvent actionEvent) {
        controller.requestForLogariasmosMou();
    }

    private void foititesClick(ActionEvent actionEvent) {
        controller.requestForFoitites();
    }

    private void dhlwshMathimatwnClick(ActionEvent actionEvent) {
        controller.requestForDhlwshMathimatwn();
    }

    private void katastashClick(ActionEvent actionEvent) {
        controller.requestForKatastash();
    }

    private void prosthikiMathimatosClick(ActionEvent actionEvent) {
        controller.requestForProsthikiMathimatos();
    }

    private void mathimataMouClick(ActionEvent actionEvent) {
        controller.requestForMathimataMou();
    }

    private void homeButtonClick(ActionEvent actionEvent) {
        controller.requestForHomePage();
    }

}
