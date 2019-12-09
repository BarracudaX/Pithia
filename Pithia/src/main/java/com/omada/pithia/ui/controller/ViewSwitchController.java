package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.ui.view.Pithia;

import java.lang.reflect.InvocationTargetException;

public class ViewSwitchController {

    private final Pithia pithia;

    public ViewSwitchController(Pithia pithia) {
        this.pithia = pithia;
    }

    public void requestForHomePage() {
        pithia.switchToHomePageGUI();
    }


    public void requestForMathimataMou() {
        pithia.switchToMathimataMouGUI();
    }

    public void requestForProsthikiMathimatos() {
        pithia.switchToProsthikiMathimatosGUI();
    }

    public void requestForKatastash() {
        pithia.switchToKatastashGUI();
    }

    public void requestForDhlwshMathimatwn() {
        pithia.switchToDhlwshMathimatwnGUI();
    }

    public void requestForFoitites() {
        pithia.switchToFoititesGUI();
    }

    public void requestForLogariasmosMou() {
        pithia.switchToLogariasmosMouGUI();
    }

    public void requestForLogout() {
        pithia.logout();
    }

    public void requestForThewries() {
        pithia.switchToThewriesGUI();
    }

    public void requestForErgasthria() {
        pithia.switchToErgasthriaGUI();
    }

    public void requestForThewria(Thewria thewria) {
        pithia.switchToThewriaGUI(thewria);
    }
}
