package com.omada.pithia.ui.view;

import com.omada.pithia.ui.controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginPageUI extends JPanel {

    private final JButton loginButton = new JButton("Login");

    private final LoginController controller;

    public LoginPageUI(LoginController controller) {
        this.controller = controller;
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.GENERAL_BACKGROUND_COLOR);

        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setFont(GeneralStyle.GENERAL_FONT);
        loginButton.setForeground(GeneralStyle.BUTTON_FOREGROUND_COLOR);
        loginButton.setBackground(GeneralStyle.BUTTON_BACKGROUND_COLOR);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(5, 5, 5, 5);

        add(loginButton, constraints);

        loginButton.addActionListener(this::loginButtonClick);
    }

    private void loginButtonClick(ActionEvent actionEvent) {
        controller.requestForLogin();
    }


}
