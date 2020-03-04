package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.ui.view.Pithia;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import java.util.Locale;

public class ViewController implements MessageSourceAware{

    private final Pithia pithia;

    private Locale locale = Locale.ENGLISH;

    private MessageSource messageSource;

    public ViewController(Pithia pithia) {
        this.pithia = pithia;
    }

    public void requestForHomeView() {
        pithia.switchToHomePageGUI();
    }

    public void requestForMathimataKathigitiView() {
        pithia.switchToMathimataKathigitiView();
    }

    public void requestForProsthikiMathimatosView() {
        pithia.switchToProsthikiMathimatosView();
    }

    public void requestForKatastashView() {
        pithia.switchToKatastashView();
    }

    public void requestForDhlwshMathimatwnView() {
        pithia.switchToDhlwshMathimatwnView();
    }

    public void requestForDhmiourgiaFoititwnView() {
        pithia.switchToDhmiourgiaFoititwnView();
    }

    public void requestForLogariasmoView() {
        pithia.switchToLogariasmosView();
    }

    public void requestForLogout() {
        pithia.logout();
    }

    public void requestForThewriesView() {
        pithia.switchToThewriesView();
    }

    public void requestForErgasthriaView() {
        pithia.switchToErgasthriaView();
    }

    public void requestForThewriaView(Thewria thewria) {
        pithia.switchToThewriaView(thewria);
    }

    public void requestForErgasthrioView(Ergasthrio ergasthrio) {
        pithia.switchToErgasthrioView(ergasthrio);
    }

    public void requestForShowErrorMessage(String error) {
        pithia.showError(error);
    }

    public void requestForShowMessage(String message) {
        pithia.showMessage(message);
    }

    public void requestForProsthikiProapaitoumenwnView(Thewria thewria) {
        pithia.switchToProsthikiProapaitoumenwnView(thewria);
    }

    public void requestForEisagwghVathmologiasThewriasView(Thewria thewria) {
        pithia.switchToEisagwghVathmologiasThewriasView(thewria);
    }

    public void requestForEisagwghVathmologiasErgasthriouView(Ergasthrio ergasthrio) {
        pithia.switchEisagwghVathmologiasErgasthriouView(ergasthrio);
    }

    public void requestForProsthikiFoititwnStoErgasthrioView(Ergasthrio ergasthrio, Thewria thewria) {
        pithia.switchToProsthikiFoititwnStoErgasthrioView(ergasthrio, thewria);
    }

    public void requestForDiaxeiristhApousiwnView(Ergasthrio ergasthrio) {
        pithia.switchToDiaxeirishApousiwnView(ergasthrio);
    }

    public void requestForProsthikiErgasthriouView() {
        pithia.switchToProsthikiErgasthriouView();
    }

    public void requestForProsthikiThewriasView() {
        pithia.switchToProsthikiThewriasView();
    }

    public void requestForDhlwshAlgorithmouView(Thewria thewria) { pithia.switchToDhlwshAlgorithmou(thewria);}
    
    public int requestForDialogBox(){
        int answer =pithia.requestForDialogBox();
        return answer;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, locale);
    }

    public void requestForLoginView() {
        pithia.switchToLoginView();
    }

    public void requestForLanguageView() {
        pithia.switchToLanguageView();
    }
}
