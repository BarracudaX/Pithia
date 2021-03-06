package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.service.ThewriesService;

import java.util.List;

public class ProsthikiProapaitoumenwnController {

    private final ViewController viewController;
    private final Thewria thewria;
    private final ThewriesService thewriesService;

    public ProsthikiProapaitoumenwnController(ViewController viewController, Thewria thewria, ThewriesService thewriesService) {
        this.viewController = viewController;
        this.thewria = thewria;
        this.thewriesService = thewriesService;
    }

    public void requestForBackPage() {
        viewController.requestForThewriaView(thewria);
    }

    public void requestForProsthikiProapaitoumenwn(List<Thewria> telikaProapaitoumena) {
        if (telikaProapaitoumena.size() == 0) {
            viewController.requestForShowMessage("Δεν διαλεξατε κανενα προαπαιτουμενο!");
            requestForBackPage();
            return;
        }

        StringBuilder message = new StringBuilder("Συνολικα Προαπαιτουμενα Που Προστεθηκαν:" + telikaProapaitoumena.size()
                +".\nΤα προαπαιτουμενα που προστεθηκαν ειναι : \n");

        for (Thewria proapaitoumeno : telikaProapaitoumena) {
            thewria.addProapaitoumeno(proapaitoumeno);
            message.append(proapaitoumeno.getOnomaMathimatos()).append("\n");
        }

        message.delete(message.length()-1, message.length());
        viewController.requestForShowMessage(message.toString());
        requestForBackPage();
    }

    public List<Thewria> getProapaitoumena() {
        return thewriesService.getPithanaProapaitoumena(thewria);
    }

    public String getMessage(String code, Object[] args) {
        return viewController.getMessage(code, args);
    }
}
