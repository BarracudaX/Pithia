package com.omada.pithia.ui.controller;

import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.model.xrhstes.Xrhsths;
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
            viewController.requestForShowMessage("O kwdikos allakse epituxws");
        } else {
            viewController.requestForShowErrorMessage("Oi kwdikoi den einai idioi");
        }
        viewController.requestForLogout();
    }

    public void requestForBackPage() {
        viewController.requestForHomePage();
    }

}
