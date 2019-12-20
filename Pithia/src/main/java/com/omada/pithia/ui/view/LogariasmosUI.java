package com.omada.pithia.ui.view;

        import com.omada.pithia.service.XrhstesService;
        import com.omada.pithia.ui.controller.LogariasmosController;
        import com.omada.pithia.ui.controller.ViewController;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;


public class LogariasmosUI extends JPanel {

    private final LogariasmosController controller;

    private final JLabel neosKwdikosLabel = new JLabel("Νεος κωδικος");
    private final JLabel epanalhpshKwdikouLabel = new JLabel("Επαναληψη κωδικου");

    private final JPasswordField neosKwdikos = new JPasswordField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JPasswordField epanalhpshKwdikou = new JPasswordField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JButton apothikeushKwdikou = new JButton("Αποθηκευση κωδικου");
    private final JButton backButton = new JButton("Επιστροφη στην αρχικη");


    public LogariasmosUI(LogariasmosController controller) {
        this.controller = controller;
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setFont(neosKwdikosLabel,epanalhpshKwdikouLabel,neosKwdikos ,
                epanalhpshKwdikou,apothikeushKwdikou,backButton)
                .setForegroundAsWhite(neosKwdikosLabel
                        ,epanalhpshKwdikouLabel,
                        apothikeushKwdikou,backButton)
                .setBackgroundAsBlue(apothikeushKwdikou)
                .setBackgroundAsRed(backButton);



        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();


        builder.setRow(0).setColumn(0).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setColumnWidth(2).setColumnWeight(2);
        add(backButton,builder.build());

        builder.reset();

        builder.setRow(1).setColumn(0).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setColumnWidth(1).setColumnWeight(1);
        add(neosKwdikosLabel,builder.build());

        builder.reset();

        builder.setRow(1).setColumn(1).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setColumnWidth(1).setColumnWeight(2);
        add(neosKwdikos,builder.build());

        builder.reset();

        builder.setRow(2).setColumn(0).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setColumnWidth(1);
        add(epanalhpshKwdikouLabel,builder.build());

        builder.reset();

        builder.setRow(2).setColumn(1).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setColumnWidth(1);
        add(epanalhpshKwdikou,builder.build());

        builder.reset();

        builder.setRow(3).setColumn(0).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 5, 5))
                .setAnchor(Utils.Anchor.CENTER).setColumnWidth(2);

        add(apothikeushKwdikou,builder.build());

        apothikeushKwdikou.addActionListener(this::apothikeushKwdikouClick);
        backButton.addActionListener(this::backButtonClick);

    }

    private void apothikeushKwdikouClick(ActionEvent actionEvent) {
                controller.requestForApothikeusiKwdikou(neosKwdikos.getText(),epanalhpshKwdikou.getText());
        }
    private void backButtonClick(ActionEvent actionEvent) {
        controller.requestForBackPage();
    }
    }

