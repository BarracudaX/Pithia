package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.DhlwshMathimatos;
import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Mathima;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.service.ThewriesService;
import com.omada.pithia.service.XrhstesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DhlwshMathimatwnController {

    private final ViewController viewController;
    private final XrhstesService xrhstesService;
    private final ThewriesService thewriesService;

    public DhlwshMathimatwnController(ViewController viewController, XrhstesService xrhstesService, ThewriesService thewriesService) {
        this.viewController = viewController;
        this.xrhstesService = xrhstesService;
        this.thewriesService = thewriesService;
    }

    public List<Mathima> getMathimata() {
        List<Mathima> mathimata = new ArrayList<>();

        List<Thewria> thewries = thewriesService.getAll();

        Foititis foitits = (Foititis) xrhstesService.getLoginXrhsth();

        for (Thewria thewria : thewries) {
            if (!thewria.parakolouthei(foitits)) {
                mathimata.add(new Mathima(thewria, new ArrayList<>(thewria.getErgasthria())));
            }
        }

        return mathimata;
    }

    public void requestForBackPage() {
        viewController.requestForHomeView();
    }

    public void requestForDhlwshMathimatwn(List<DhlwshMathimatos> dhlwmenaMathimata) {
        Foititis foititis = (Foititis) xrhstesService.getLoginXrhsth();

        StringBuilder output = new StringBuilder("Η Δηλωση Μαθηματων Ολοκληρωθηκε.Τα μαθηματα που δηλωσατε ειναι : \n");

        for (DhlwshMathimatos dhlwsh : dhlwmenaMathimata) {
            Thewria thewria = dhlwsh.getThewria();
            Optional<Ergasthrio> ergasthrio = dhlwsh.getErgasthrio();

            thewria.addFoititi(foititis);

            output.append(thewria.getOnomaMathimatos()).append("\n");

            if (ergasthrio.isPresent()) {
                thewria.addFoititiStoErgasthrio(foititis, ergasthrio.get());
                output.append(ergasthrio.get().getOnomaErgasthriou()).append("\n");
            }

        }

        viewController.requestForShowMessage(output.toString());

        viewController.requestForHomeView();

    }

    public String getMessage(String code, Object[] args) {
        return viewController.getMessage(code,args);
    }


}
