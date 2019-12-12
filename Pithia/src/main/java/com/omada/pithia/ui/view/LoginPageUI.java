package com.omada.pithia.ui.view;

import com.omada.pithia.ui.controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginPageUI extends JPanel {

    private final JButton loginButton = new JButton("Login");
    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JLabel usernameLabel = new JLabel("Ονομα Χρηστη:");
    private final JLabel passwordLabel = new JLabel("Κωδικος:");

    private final LoginController controller;

    public LoginPageUI(LoginController controller) {
        this.controller = controller;
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setCursorAsHand(loginButton).setFont(loginButton,passwordLabel,usernameLabel,passwordField,usernameField)
                .setForegroundAsWhite(loginButton,passwordLabel,passwordField,usernameField,usernameLabel)
                .setBackgroundAsBlue(loginButton).setBackgroundAsGrey(usernameField,passwordField)
                .setTextFieldSize(usernameField,passwordField);

        usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();

        builder.setRow(0).setColumn(0).setColumnWeight(1).setInsets(new Insets(5, 5, 5, 20))
                .setAnchor(Utils.Anchor.CENTER).setFill(Utils.Fill.HORIZONTAL);

        add(usernameLabel,builder.build());

        builder.reset().setRow(0).setColumn(1).setFill(Utils.Fill.HORIZONTAL).setAnchor(Utils.Anchor.CENTER)
                .setColumnWeight(10).setInsets(new Insets(5, 5, 5, 5));

        add(usernameField,builder.build());

        builder.reset().setFill(Utils.Fill.HORIZONTAL).setAnchor(Utils.Anchor.CENTER).setRow(1).setColumn(0)
                .setColumnWeight(1).setInsets(new Insets(5, 5, 5, 20));
        add(passwordLabel,builder.build());

        builder.reset().setFill(Utils.Fill.HORIZONTAL).setAnchor(Utils.Anchor.CENTER).setColumn(1).setRow(1)
                .setColumnWeight(10).setInsets(new Insets(5, 5, 5, 5));
        add(passwordField,builder.build());

        builder.reset().setFill(Utils.Fill.HORIZONTAL).setAnchor(Utils.Anchor.CENTER).setColumn(0).setRow(2)
                .setColumnWeight(1).setColumnWidth(2).setInsets(new Insets(5, 5, 5, 5));
        add(loginButton, builder.build());

        loginButton.addActionListener(this::loginButtonClick);
    }

    private void loginButtonClick(ActionEvent actionEvent) {
        controller.requestForLogin(usernameField.getText(),passwordField.getPassword());
    }


}
