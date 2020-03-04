package com.omada.pithia.ui.view;

        import com.omada.pithia.service.XrhstesService;
        import com.omada.pithia.ui.controller.LogariasmosController;
        import com.omada.pithia.ui.controller.ViewController;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;


public class LogariasmosView extends JPanel {

    private final LogariasmosController controller;

    private final JLabel neosKwdikosLabel ;
    private final JLabel epanalhpshKwdikouLabel ;

    private final JPasswordField neosKwdikos = new JPasswordField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JPasswordField epanalhpshKwdikou = new JPasswordField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JButton apothikeushKwdikou ;
    private final JButton backButton ;


    public LogariasmosView(LogariasmosController controller) {
        this.controller = controller;
        this.neosKwdikosLabel = new JLabel(
                controller.getMessage("Logariasmos.View.NeosKwdikos.Label", new Object[]{})
        );
        this.epanalhpshKwdikouLabel = new JLabel(
                controller.getMessage("Logariasmos.View.EpanalhpshKwdikou.Label", new Object[]{})
        );
        this.apothikeushKwdikou = new JButton(
                controller.getMessage("Logariasmos.View.ApothikeushKwdikou.Button", new Object[]{})
        );
        this.backButton = new JButton(
                controller.getMessage("Logariasmos.View.Back.Button", new Object[]{})
        );
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

