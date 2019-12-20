package com.omada.pithia.model.mathimata;

import java.util.Collections;
import java.util.List;

public final class Mathima {

    private final Thewria thewria;

    private final List<Ergasthrio> ergasthria;

    public Mathima(Thewria thewria, List<Ergasthrio> ergasthria) {
        if (ergasthria.size() > 0 && !thewria.getErgasthria().containsAll(ergasthria)) {
            throw new IllegalArgumentException("Orismena apo ta ergasthria den anhkoun sthn thewria.");
        }
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
