package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Eksamhno;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Kathigitis;
import com.omada.pithia.service.ThewriesService;

import java.util.List;

public class ProsthikiThewriasController {

    private final ViewController viewController;

    private final GeneralServiceController serviceController;

    public ProsthikiThewriasController(ViewController viewController, GeneralServiceController serviceController) {
        this.viewController = viewController;
        this.serviceController = serviceController;
    }

    public String[] getKathigites() {
        return serviceController.getKathigites();
    }

    public String[] getEksamhna() {
        return serviceController.getEksamhna();
    }

    public void requestForBackPage() {
        viewController.requestForProsthikiMathimatos();
    }

    public List<Thewria> getProapaitoumena(Eksamhno eksamhno) {
        return serviceController.getPithanaProapaitoumena(eksamhno);
    }

    public void requestForProsthikiThewrias(String kathigitis, Eksamhno eksamhno, String onomaThewrias, List<String> proapaitoumena) {
        if (serviceController.getThewria(onomaThewrias) != null) {
            viewController.requestForShowErrorMessage("Θεωρια με ονομα "+onomaThewrias+" υπαρχει ηδη." +
                    "Διαλεξτε αλλο ονομα θεωριας.");
            return;
        }


        Kathigitis kathigitisThewrias = serviceController.getKathigiti(serviceController.removeDecorations(kathigitis));

        Thewria thewria = new Thewria(onomaThewrias, kathigitisThewrias, eksamhno);

        for (String proapaitoumeno : proapaitoumena) {
            thewria.addProapaitoumeno(serviceController.getThewria(proapaitoumeno));
        }

        serviceController.addThewria(thewria);

        viewController.requestForShowMessage("Το μαθημα θεωριας προστεθηκε επιτυχως!");

        viewController.requestForProsthikiMathimatos();
    }
}
