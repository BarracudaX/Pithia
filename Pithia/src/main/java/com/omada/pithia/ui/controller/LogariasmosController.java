package com.omada.pithia.ui.controller;

import com.omada.pithia.service.XrhstesService;

;

public class LogariasmosController {
    private final ViewController viewController;
    private final XrhstesService xrhsths;


    public LogariasmosController(ViewController viewController, XrhstesService xrhsths) {
        this.viewController = viewController;
        this.xrhsths = xrhsths;
    }

    public void requestForApothikeusiKwdikou(String text1, String text2) {
        String newPass = text1;
        if (text1.equals(text2)) {
            xrhsths.getLoginXrhsth().setKwdikos(newPass);
            viewController.requestForShowMessage("Ο κωδικος αλλαξε επιτυχως");
            viewController.requestForLogout();
        } else {
            viewController.requestForShowErrorMessage("Οι κωδικοι δεν ειναι ιδιοι παρακαλω εισαγεται τους ξανα");
        }

    }

    public void requestForBackPage() {
        viewController.requestForHomeView();
    }

    public String getMessage(String code, Object[] args) {
        return viewController.getMessage(code, args);
    }
}
