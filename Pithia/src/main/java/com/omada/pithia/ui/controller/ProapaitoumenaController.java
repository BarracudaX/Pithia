package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.service.ThewriesService;

import java.util.List;

public class ProapaitoumenaController {

    private final ViewController viewController;
    private final Thewria thewria;
    private final ThewriesService thewriesService;

    public ProapaitoumenaController(ViewController viewController, Thewria thewria, ThewriesService thewriesService) {
        this.viewController = viewController;
        this.thewria = thewria;
        this.thewriesService = thewriesService;
    }

    public void requestForBackPage() {
        viewController.requestForThewria(thewria);
    }

    public void requestForProsthikiProapaitoumenwn(List<Thewria> telikaProapaitoumena) {
        if (telikaProapaitoumena.size() == 0) {
            viewController.requestForShowMessage("Δεν διαλεξατε κανενα προαπαιτουμενο!");
            requestForBackPage();
            return;
        }

        StringBuilder message = new StringBuilder("Συνολικα Προαπαιτουμενα Που Προστεθηκαν:" + telikaProapaitoumena.size()
                +".Τα προαπαιτουμενα που προστεθηκαν ειναι : ");

        for (Thewria proapaitoumeno : telikaProapaitoumena) {
            thewria.addProapaitoumeno(proapaitoumeno);
            message.append(proapaitoumeno.getOnomaMathimatos()).append(",");
        }

        message.delete(message.length()-1, message.length());
        viewController.requestForShowMessage(message.toString());
        requestForBackPage();
    }

    public List<Thewria> getProapaitoumena() {
        return thewriesService.getPithataProapaitoumena(thewria);
    }
}
