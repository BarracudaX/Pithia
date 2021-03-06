package com.omada.pithia.service;

import com.omada.pithia.model.mathimata.Eksamhno;
import com.omada.pithia.model.mathimata.Thewria;

import java.util.List;

public interface ThewriesService extends Service<Thewria,String> {
    List<Thewria> getPithanaProapaitoumena(Thewria thewria);

    List<Thewria> getPithanaProapaitoumena(Eksamhno eksamhno);
}
