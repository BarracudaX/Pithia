package com.omada.pithia.ui.controller;

import com.omada.pithia.model.mathimata.Eksamhno;
import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Thewria;
import com.omada.pithia.model.xrhstes.Kathigitis;
import com.omada.pithia.service.ErgasthrioService;
import com.omada.pithia.service.ThewriesService;
import com.omada.pithia.service.XrhstesService;

import java.util.List;

public class GeneralServiceController {


    private final ErgasthrioService ergasthrioService;

    private final ThewriesService thewriesService;

    private final XrhstesService xrhstesService;

    public GeneralServiceController(ErgasthrioService ergasthrioService, ThewriesService thewriesService, XrhstesService xrhstesService) {
        this.ergasthrioService = ergasthrioService;
        this.thewriesService = thewriesService;
        this.xrhstesService = xrhstesService;
    }


    String removeDecorations(String onomaKathigiti) {
        return onomaKathigiti.substring(0, onomaKathigiti.indexOf("("));
    }

    String[] getThewries() {
        List<Thewria> listThewries = thewriesService.getAll();

        String[] thewries = new String[listThewries.size()];

        for (int index = 0; index < thewries.length; index++) {
            thewries[index] = listThewries.get(index).getOnomaMathimatos();
        }

        return thewries;
    }

    String[] getKathigites() {
        List<Kathigitis> listKathigites = xrhstesService.getKathigites();

        String[] kathigites = new String[listKathigites.size()];

        for (int index = 0; index < kathigites.length; index++) {
            Kathigitis kathigitis = listKathigites.get(index);
            String kathigitisItem = kathigitis.getOnomaXrhsth() + "(" + kathigitis.getEpwnhmo() + " " + kathigitis.getOnoma()+")";
            kathigites[index] = kathigitisItem;
        }

        return kathigites;
    }

    boolean checkIfExistsErgasthrio(String onomaErgasthriou){
        return ergasthrioService.find(onomaErgasthriou) != null;
    }

    Kathigitis getKathigiti(String onomaKathigiti) {
        return (Kathigitis) xrhstesService.find(onomaKathigiti);
    }

    Thewria getThewria(String onomaThewrias) {
        return thewriesService.find(onomaThewrias);
    }

    void addErgasthrio(Ergasthrio ergasthrio) {
        ergasthrioService.add(ergasthrio);
    }

    public String[] getEksamhna() {
        Eksamhno[] values = Eksamhno.values();

        String[] eksamhna = new String[values.length];

        for (int index = 0; index < values.length; index++) {
            eksamhna[index] = values[index].name();
        }

        return eksamhna;
    }

    public List<Thewria> getPithanaProapaitoumena(Eksamhno eksamhno) {
        return thewriesService.getPithanaProapaitoumena(eksamhno);
    }

    public void addThewria(Thewria thewria) {
        thewriesService.add(thewria);
    }
}
