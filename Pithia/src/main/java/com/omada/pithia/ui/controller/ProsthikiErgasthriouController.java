package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Kathigitis;

public class ProsthikiErgasthriouController {

    private final ViewController viewController;

    private final GeneralServiceController serviceController;


    public ProsthikiErgasthriouController(ViewController viewController, GeneralServiceController serviceController) {
        this.viewController = viewController;
        this.serviceController = serviceController;
    }


    public void requestForBackPage() {
        viewController.requestForProsthikiMathimatosView();
    }

    public void requestForProsthiki(String onomaThewrias, String onomaKathigiti, String onomaErgasthriou) {
        if (onomaErgasthriou.length() == 0) {
            viewController.requestForShowErrorMessage("Το ονομα εργαστηριου ειναι κενο!Συμπληρωστε το ονομα εργαστηριου!");
            return;
        }

        if (serviceController.checkIfExistsErgasthrio(onomaErgasthriou)) {
            viewController.requestForShowErrorMessage("Υπαρχει ηδη εργαστηριο με το ονομα" + onomaErgasthriou
                    +".Παρακαλω,διαλεξτε ενα αλλο ονομα εργαστηριου.");
            return;
        }

        Kathigitis kathigitis = serviceController.getKathigiti(serviceController.removeDecorations(onomaKathigiti));

        Thewria thewria = serviceController.getThewria(onomaThewrias);

        Ergasthrio ergasthrio = new Ergasthrio(onomaErgasthriou, kathigitis, thewria);

        thewria.addErgasthrio(ergasthrio);

        serviceController.addErgasthrio(ergasthrio);

        viewController.requestForShowMessage("Το εργαστηριο προστεθηκε επιτυχως.");

        viewController.requestForProsthikiMathimatosView();
    }


    public String[] getThewries() {
        return serviceController.getThewries();
    }

    public String[] getKathigites() {
        return serviceController.getKathigites();
    }
}
