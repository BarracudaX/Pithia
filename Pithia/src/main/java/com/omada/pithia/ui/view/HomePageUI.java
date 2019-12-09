package com.omada.pithia.ui.view;

import com.omada.pithia.ui.controller.ViewSwitchController;

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


    private final ViewSwitchController controller;


    public HomePageUI(ViewSwitchController controller) {
        this.controller = controller;

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
        setBackground(GENERAL_BACKGROUND_COLOR);

        homeButton.setBackground(BUTTON_BACKGROUND_COLOR);
        mathimataMouButton.setBackground(BUTTON_BACKGROUND_COLOR);
        prosthikiMathimatosButton.setBackground(BUTTON_BACKGROUND_COLOR);
        katastashButton.setBackground(BUTTON_BACKGROUND_COLOR);
        dhlwshMathimatwnButton.setBackground(BUTTON_BACKGROUND_COLOR);
        foititesButton.setBackground(BUTTON_BACKGROUND_COLOR);
        logariasmosButton.setBackground(BUTTON_BACKGROUND_COLOR);
        logoutButton.setBackground(LOGOUT_BACKGROUND_COLOR);

        homeButton.setForeground(BUTTON_FOREGROUND_COLOR);
        mathimataMouButton.setForeground(BUTTON_FOREGROUND_COLOR);
        prosthikiMathimatosButton.setForeground(BUTTON_FOREGROUND_COLOR);
        katastashButton.setForeground(BUTTON_FOREGROUND_COLOR);
        dhlwshMathimatwnButton.setForeground(BUTTON_FOREGROUND_COLOR);
        foititesButton.setForeground(BUTTON_FOREGROUND_COLOR);
        logariasmosButton.setForeground(BUTTON_FOREGROUND_COLOR);
        logoutButton.setForeground(BUTTON_FOREGROUND_COLOR);

        homeButton.setFont(GENERAL_FONT);
        mathimataMouButton.setFont(GENERAL_FONT);
        prosthikiMathimatosButton.setFont(GENERAL_FONT);
        katastashButton.setFont(GENERAL_FONT);
        dhlwshMathimatwnButton.setFont(GENERAL_FONT);
        foititesButton.setFont(GENERAL_FONT);
        logariasmosButton.setFont(GENERAL_FONT);
        logoutButton.setFont(GENERAL_FONT);

        homeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mathimataMouButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        prosthikiMathimatosButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        katastashButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dhlwshMathimatwnButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        foititesButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logariasmosButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        homeButton.addActionListener(this::homeButtonClick);
        mathimataMouButton.addActionListener(this::mathimataMouClick);
        prosthikiMathimatosButton.addActionListener(this::prosthikiMathimatosClick);
        katastashButton.addActionListener(this::katastashClick);
        dhlwshMathimatwnButton.addActionListener(this::dhlwshMathimatwnClick);
        foititesButton.addActionListener(this::foititesClick);
        logariasmosButton.addActionListener(this::logariasmosMouClick);
        logoutButton.addActionListener(this::logoutClick);

        JButton[][] buttons = {
                {homeButton, mathimataMouButton, dhlwshMathimatwnButton, prosthikiMathimatosButton},
                {katastashButton, foititesButton, logariasmosButton, logoutButton}
        };

        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 4; column++) {
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = row;
                constraints.gridy = column;
                constraints.fill = GridBagConstraints.BOTH;
                constraints.insets = new Insets(3,3,3,3);
                constraints.anchor = GridBagConstraints.CENTER;
                constraints.weightx = 1;
                constraints.weighty = 1;
                add(buttons[row][column],constraints);
            }
        }
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
