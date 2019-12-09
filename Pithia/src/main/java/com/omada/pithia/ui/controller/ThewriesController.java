package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Eksamhno;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Kathigitis;

import java.time.LocalDate;

public class ThewriesController {

    private final ViewSwitchController viewSwitchController;

    public ThewriesController(ViewSwitchController viewSwitchController) {
        this.viewSwitchController = viewSwitchController;
    }

    public void requestForBack() {
        viewSwitchController.requestForMathimataMou();
    }


    public void requestForThewria(String onomaThewrias) {
        Kathigitis kathigitis = new Kathigitis("Kathigitis1", "Epwnumo1", LocalDate.now().minusYears(20),
                "Kathigitis123", "Kwdikos123", "dimitrijchannel@gmail.com");
        Thewria thewria = new Thewria(onomaThewrias, kathigitis, Eksamhno.E);
        viewSwitchController.requestForThewria(thewria);
    }

}
