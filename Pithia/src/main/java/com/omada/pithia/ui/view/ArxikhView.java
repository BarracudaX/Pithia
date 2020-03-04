package com.omada.pithia.ui.view;

import com.omada.pithia.model.xrhstes.Rolos;
import com.omada.pithia.service.XrhstesService;
import com.omada.pithia.ui.controller.ViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static com.omada.pithia.ui.view.GeneralStyle.*;

public class ArxikhView extends JPanel {

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


    public ArxikhView(ViewController controller, XrhstesService xrhstesService) {
        this.controller = controller;
        this.xrhstesService = xrhstesService;

        homeButton = new JButton(controller.getMessage("Home.View.Home.Button",new Object[]{}));
        mathimataMouButton = new JButton(controller.getMessage("Home.View.Courses.Button",new Object[]{}));
        dhlwshMathimatwnButton = new JButton(controller.getMessage("Home.View.SpecifyCourses.Button",new Object[]{}));
        prosthikiMathimatosButton = new JButton(controller.getMessage("Home.View.AddCourse.Button",new Object[]{}));
        katastashButton = new JButton(controller.getMessage("Home.View.Status.Button",new Object[]{}));
        foititesButton = new JButton(controller.getMessage("Home.View.StudentsManage.Button",new Object[]{}));
        logariasmosButton = new JButton(controller.getMessage("Home.View.Account.Button",new Object[]{}));
        logoutButton = new JButton(controller.getMessage("Home.View.Logout.Button",new Object[]{}));

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


        homeButton.addActionListener(this::homeButtonClick);
        mathimataMouButton.addActionListener(this::mathimataMouClick);
        prosthikiMathimatosButton.addActionListener(this::prosthikiMathimatosClick);
        katastashButton.addActionListener(this::katastashClick);
        dhlwshMathimatwnButton.addActionListener(this::dhlwshMathimatwnClick);
        foititesButton.addActionListener(this::foititesClick);
        logariasmosButton.addActionListener(this::logariasmosMouClick);
        logoutButton.addActionListener(this::logoutClick);
    }

    private void logoutClick(ActionEvent actionEvent) {
        controller.requestForLogout();
    }

    private void logariasmosMouClick(ActionEvent actionEvent) {
        controller.requestForLogariasmoView();
    }

    private void foititesClick(ActionEvent actionEvent) {
        controller.requestForDhmiourgiaFoititwnView();
    }

    private void dhlwshMathimatwnClick(ActionEvent actionEvent) {
        controller.requestForDhlwshMathimatwnView();
    }

    private void katastashClick(ActionEvent actionEvent) {
        controller.requestForKatastashView();
    }

    private void prosthikiMathimatosClick(ActionEvent actionEvent) {
        controller.requestForProsthikiMathimatosView();
    }

    private void mathimataMouClick(ActionEvent actionEvent) {
        controller.requestForMathimataKathigitiView();
    }

    private void homeButtonClick(ActionEvent actionEvent) {
        controller.requestForHomeView();
    }

}
