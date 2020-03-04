package com.omada.pithia.ui.controller;

import com.omada.pithia.service.XrhstesService;

public class LoginController {

    private final ViewController controller;

    private final XrhstesService service;

    public LoginController(ViewController controller, XrhstesService service) {
        this.controller = controller;
        this.service = service;
    }

    public void requestForLogin(String onomaXrhsth, char[] kwdikos) {
        if (service.canLogin(onomaXrhsth, new String(kwdikos))) {
            service.login(onomaXrhsth,new String(kwdikos));
            controller.requestForHomeView();
        }else{
            controller.requestForShowErrorMessage(
                    "Το ονομα χρηστη "+onomaXrhsth
                    +" η/και ο κωδικος που δωσατε δεν αντιστοιχουν σε κανενα λογαριασμο.");
        }
    }

    public String getMessage(String code) {
        return controller.getMessage(code, new Object[]{});
    }

    public void requestForLanguageView() {
        controller.requestForLanguageView();
    }
}
