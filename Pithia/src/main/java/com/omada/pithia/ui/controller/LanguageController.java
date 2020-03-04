package com.omada.pithia.ui.controller;

import java.util.Locale;

public class LanguageController {

    private final Locale en = Locale.ENGLISH;
    private final Locale gr = new Locale("gr");

    private final ViewController viewController;

    public LanguageController(ViewController viewController) {
        this.viewController = viewController;
    }

    public void enChoose() {
        viewController.setLocale(en);
        viewController.requestForLoginView();
    }

    public void grChoose() {
        viewController.setLocale(gr);
        viewController.requestForLoginView();
    }

}
