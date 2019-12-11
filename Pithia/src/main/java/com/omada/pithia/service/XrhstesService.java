package com.omada.pithia.service;

import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.model.xrhstes.Kathigitis;
import com.omada.pithia.model.xrhstes.Xrhsths;

import java.util.List;

public interface XrhstesService extends Service<Xrhsths,String> {

    boolean canLogin(String onomaXrhsth, String password);

    List<Foititis> getFoitites();

    List<Kathigitis> getKathigites();

    void login(String onomaXrhsth, String password);

    Xrhsths getLoginXrhsth();
}
