package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.ui.view.Pithia;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

public class ViewController {

    private final Pithia pithia;

    public ViewController(Pithia pithia) {
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

    public void requestForErgasthrio(Ergasthrio ergasthrio) {
        pithia.switchToErgasthrioGUI(ergasthrio);
    }

    public void requestForShowErrorMessage(String error) {
        pithia.showError(error);
    }

    public void requestForShowMessage(String message) {
        pithia.showMessage(message);
    }

    public void requestForProsthikiProapaitoumenwn(Thewria thewria) {
        pithia.switchToProsthikiProapaitoumenou(thewria);
    }

    public void requestForEisagwghVathmologiasThewrias(Thewria thewria) {
        pithia.switchToEisagwghVathmologias(thewria);
    }

    public void requestForEisagwghVathmologiasErgasthriou(Ergasthrio ergasthrio) {
        pithia.switchToEisagwghVathmologias(ergasthrio);
    }

    public void requestForProsthikiFoititwnStoErgasthrio(Ergasthrio ergasthrio, Thewria thewria) {
        pithia.switchToProsthikiFoititwnStoErgasthrio(ergasthrio, thewria);
    }

    public void requestForDiaxeiristhApousiwn(Ergasthrio ergasthrio) {
        pithia.switchToDiaxeirishApousiwn(ergasthrio);
    }

    public void requestForProsthikiErgasthriou() {
        pithia.switchToProsthikiErgasthriou();
    }

    public void requestForProsthikiThewrias() {
        pithia.switchToProsthikiThewrias();
    }
}
