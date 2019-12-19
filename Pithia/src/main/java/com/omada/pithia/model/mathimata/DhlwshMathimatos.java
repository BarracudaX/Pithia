package com.omada.pithia.model.mathimata;

import java.util.Optional;

public class DhlwshMathimatos {

    private final Thewria thewria;

    private final Optional<Ergasthrio> ergasthrio;

    public DhlwshMathimatos(Thewria thewria, Optional<Ergasthrio> ergasthrio) {
        this.thewria = thewria;
        this.ergasthrio = ergasthrio;
    }

    public Thewria getThewria() {
        return thewria;
    }

    public Optional<Ergasthrio> getErgasthrio() {
        return ergasthrio;
    }
}
