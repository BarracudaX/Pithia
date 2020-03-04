package com.omada.pithia.ui.view;

import com.omada.pithia.ui.controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginView extends JPanel {

    private final JButton loginButton;
    private final JButton switchLanguageButton ;
    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();
    private final JLabel usernameLabel ;
    private final JLabel passwordLabel ;

    private final LoginController controller;

    public LoginView(LoginController controller) {
        this.controller = controller;
        loginButton = new JButton(controller.getMessage("Login.View.Login.Button"));
        usernameLabel = new JLabel(controller.getMessage("Login.View.Username.Label"));
        passwordLabel = new JLabel(controller.getMessage("Login.View.Password.Label"));
        switchLanguageButton = new JButton(controller.getMessage("Login.View.Language.Button"));
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setCursorAsHand(loginButton,switchLanguageButton)
                .setFont(loginButton,passwordLabel,usernameLabel,passwordField,usernameField,switchLanguageButton)
                .setForegroundAsWhite(loginButton,passwordLabel,passwordField,usernameField
                        ,usernameLabel,switchLanguageButton)
                .setBackgroundAsBlue(loginButton,switchLanguageButton)
                .setBackgroundAsGrey(usernameField,passwordField)
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

        builder.reset().setFill(Utils.Fill.HORIZONTAL).setAnchor(Utils.Anchor.CENTER).setColumn(0).setRow(3)
                .setColumnWeight(1).setColumnWidth(2).setInsets(new Insets(5, 5, 5, 5));
        add(switchLanguageButton, builder.build());

        loginButton.addActionListener(this::loginButtonClick);
        switchLanguageButton.addActionListener(this::switchLanguageClick);
    }

    private void switchLanguageClick(ActionEvent actionEvent) {
        controller.requestForLanguageView();
    }

    private void loginButtonClick(ActionEvent actionEvent) {
        controller.requestForLogin(usernameField.getText(),passwordField.getPassword());
    }


}
