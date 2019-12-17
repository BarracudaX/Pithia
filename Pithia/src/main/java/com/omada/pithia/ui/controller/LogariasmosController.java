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
        public void requestForApothikeusiKwdikou(String text1,String text2) {
            String newPass=text1;
            if(text1==text2) {
                xrhsths.getLoginXrhsth().setKwdikos(newPass);
            }
            /*
             else show error message explaining
             */
        }
        public void requestForBackPage(){
            viewController.requestForHomePage();
        }

}
