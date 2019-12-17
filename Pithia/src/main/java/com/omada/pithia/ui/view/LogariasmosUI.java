package com.omada.pithia.ui.view;

        import com.omada.pithia.service.XrhstesService;
        import com.omada.pithia.ui.controller.LogariasmosController;
        import com.omada.pithia.ui.controller.ViewController;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;


public class LogariasmosUI extends JPanel {

    private final LogariasmosController controller;

    private final JLabel infoLabel = new JLabel("Genikes plirofories");
    private final JLabel formaAllagisLabel = new JLabel("Forma allagis kwdikou");
    private final JLabel neosKwdikosLabel = new JLabel("Neos Kwdikos");
    private final JLabel epanalhpshKwdikouLabel = new JLabel("Epanalhpsh Kwdikou");
    private final JTextField neosKwdikos = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JTextField epanalhpshKwdikou = new JTextField(GeneralStyle.DEFAULT_TEXT_FIELD_SIZE);
    private final JButton apothikeushKwdikou = new JButton("Apothikeush Kwdikou");


    public LogariasmosUI(LogariasmosController controller) {
        this.controller = controller;
        prepareView();
    }

    private void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setFont(infoLabel,formaAllagisLabel,neosKwdikosLabel,epanalhpshKwdikouLabel,neosKwdikos ,
                epanalhpshKwdikou,apothikeushKwdikou)
                .setForegroundAsWhite(infoLabel,formaAllagisLabel,neosKwdikosLabel
                ,epanalhpshKwdikouLabel,
                neosKwdikos , epanalhpshKwdikou,apothikeushKwdikou)
                .setBackgroundAsGrey(infoLabel,formaAllagisLabel,neosKwdikosLabel,epanalhpshKwdikouLabel,neosKwdikos ,
                epanalhpshKwdikou,apothikeushKwdikou);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();

        builder.setRow(0).setColumn(0).setColumnWidth(2).setFill(Utils.Fill.BOTH).setInsets(
                new Insets(5, 5, 20, 5)).setAnchor(Utils.Anchor.CENTER).setRowWeight(1);
        add(infoLabel,builder.build());

        builder.reset();

        builder.setRow(1).setColumn(0).setColumnWidth(2).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 20, 5))
                .setAnchor(Utils.Anchor.CENTER).setRowWeight(1);
        add(formaAllagisLabel,builder.build());

        builder.reset();

        builder.setRow(2).setColumn(0).setColumnWidth(1).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 20, 5))
                .setAnchor(Utils.Anchor.CENTER).setRowWeight(1);
        add(neosKwdikosLabel,builder.build());

        builder.reset();
        builder.setRow(2).setColumn(1).setColumnWidth(1).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 20, 5))
                .setAnchor(Utils.Anchor.CENTER).setRowWeight(1);
        add(neosKwdikos,builder.build());

        builder.reset();
        builder.setRow(3).setColumn(0).setColumnWidth(1).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 20, 5))
                .setAnchor(Utils.Anchor.CENTER).setRowWeight(1);
        add(epanalhpshKwdikouLabel,builder.build());

        builder.reset();
        builder.setRow(3).setColumn(1).setColumnWidth(1).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 20, 5))
                .setAnchor(Utils.Anchor.CENTER).setRowWeight(1);
        add(epanalhpshKwdikou,builder.build());

        builder.reset();
        builder.setRow(3).setColumn(1).setColumnWidth(1).setFill(Utils.Fill.BOTH).setInsets(new Insets(5, 5, 20, 5))
                .setAnchor(Utils.Anchor.CENTER).setRowWeight(1);
        add(apothikeushKwdikou,builder.build());


        apothikeushKwdikou.addActionListener(this::apothikeushKwdikouClick);

    }

    private void apothikeushKwdikouClick(ActionEvent actionEvent) {

    }
}
