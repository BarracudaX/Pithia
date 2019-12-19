package com.omada.pithia.model.mathimata;

import java.util.Collections;
import java.util.List;

public class Mathima {

    private final Thewria thewria;

    private final List<Ergasthrio> ergasthria;

    public Mathima(Thewria thewria, List<Ergasthrio> ergasthria) {
        this.thewria = thewria;
        this.ergasthria = ergasthria;
    }


    public Thewria getThewria() {
        return thewria;
    }

    public List<Ergasthrio> getErgasthria() {
        return Collections.unmodifiableList(ergasthria);
    }
}
