package com.omada.pithia.ui.view;

import com.omada.pithia.model.mathimata.Thewria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.javafx.fxml.expression.Expression.add;

public abstract class AbstractDoubleListView extends JPanel{

    private final JButton backButton = new JButton("Πισω");
    private final JButton addButton = new JButton("Μετακινηση Σστην Λιστα Επιλογων");
    private final JButton removeButton = new JButton("Αφαιρεση Απο Την Λιστα");
    private final JButton finishButton = new JButton("Τελικη Αποθηκευση");
    private final JList<String> firstList = new JList<>();
    private final JList<String> secondList = new JList<>();
    private final DefaultListModel<String> firstListModel = new DefaultListModel<>();
    private final DefaultListModel<String> secondListModel = new DefaultListModel<>();
    private final JLabel firstLabel = new JLabel("");
    private final JLabel secondLabel = new JLabel("");

    public AbstractDoubleListView() {

    }

    public final void prepareView() {
        setLayout(new GridBagLayout());
        setBackground(GeneralStyle.DARK_COLOR);

        firstLabel.setText(getFirstLabelName());
        secondLabel.setText(getSecondLabelName());

        firstList.setVisibleRowCount(10);
        secondList.setVisibleRowCount(10);

        firstList.setModel(firstListModel);

        for (String item : getFirstListItems()) {
            firstListModel.addElement(item);
        }

        secondList.setModel(secondListModel);

        JScrollPane firstScrollPane = new JScrollPane(firstList);
        JScrollPane secondScrollPane = new JScrollPane(secondList);

        firstScrollPane.setMinimumSize(new Dimension(200,100));
        secondScrollPane.setMinimumSize(new Dimension(200,100));

        GeneralStyle.GeneralStyleBuilder styleBuilder = new GeneralStyle.GeneralStyleBuilder();
        styleBuilder.setCursorAsHand(backButton, addButton, removeButton, finishButton)
                .setFont(backButton, addButton, removeButton, finishButton, firstList, secondList,firstLabel,secondLabel)
                .setBackgroundAsBlue(addButton, finishButton).setBackgroundAsRed(backButton, removeButton)
                .setHorizontalAlignmentToCenter(firstLabel, secondLabel)
                .setForegroundAsWhite(
                        backButton, addButton, removeButton, finishButton, firstList, secondList, firstLabel, secondLabel)
                .setBackgroundAsGrey(firstList, secondList);

        Utils.GridBagConstraintBuilder builder = new Utils.GridBagConstraintBuilder();
        builder.setColumn(0).setRow(0).setColumnWidth(3).setRowWeight(1).setColumnWeight(1)
                .setFill(Utils.Fill.BOTH).setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 20, 5));
        add(backButton, builder.build());

        builder.reset().setColumn(0).setRow(1).setColumnWeight(0).setRowWeight(0).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(firstLabel, builder.build());

        builder.reset().setColumn(2).setRow(1).setColumnWeight(0).setRowWeight(0).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(secondLabel, builder.build());

        builder.reset().setRowWidth(2).setColumn(0).setRow(2).setColumnWeight(10).setRowWeight(15).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(firstScrollPane, builder.build());

        builder.reset().setColumn(1).setRow(2).setColumnWeight(1).setRowWeight(5).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 10, 5, 10));
        add(addButton, builder.build());

        builder.reset().setColumn(1).setRow(3).setColumnWeight(1).setRowWeight(5).setFill(Utils.Fill.HORIZONTAL)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 10, 5, 10));
        add(removeButton, builder.build());

        builder.reset().setRowWidth(2).setColumn(2).setRow(2).setColumnWeight(10).setRowWeight(15).setFill(Utils.Fill.BOTH)
                .setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(5, 5, 5, 5));
        add(secondScrollPane, builder.build());

        builder.setColumn(0).setRow(4).setColumnWidth(3).setRowWeight(1).setColumnWeight(1)
                .setFill(Utils.Fill.BOTH).setAnchor(Utils.Anchor.CENTER).setInsets(new Insets(20, 5, 5, 5));
        add(finishButton, builder.build());

        backButton.addActionListener(this::backButtonClick);
        addButton.addActionListener(this::addButtonClick);
        removeButton.addActionListener(this::removeButtonClick);
        finishButton.addActionListener(this::finishButtonClick);
    }

    public abstract void finishButtonClick(ActionEvent actionEvent) ;

    public abstract void backButtonClick(ActionEvent actionEvent) ;

    public abstract String getFirstLabelName();

    public abstract String getSecondLabelName();

    public abstract List<String> getFirstListItems();

    private void removeButtonClick(ActionEvent actionEvent) {
        int selectedIndex = secondList.getSelectedIndex();
        if (selectedIndex > -1) {
            firstListModel.addElement(secondList.getSelectedValue());
            secondListModel.removeElementAt(selectedIndex);
        }
    }

    private void addButtonClick(ActionEvent actionEvent) {
        int selectedIndex = firstList.getSelectedIndex();
        if (selectedIndex > -1) {
            secondListModel.addElement(firstList.getSelectedValue());
            firstListModel.removeElementAt(selectedIndex);
        }
    }

    public final DefaultListModel<String> getSecondListModel(){
        return secondListModel;
    }

    public final DefaultListModel<String> getFirstListModel(){
        return firstListModel;
    }
}
