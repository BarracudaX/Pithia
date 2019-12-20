package com.omada.pithia.model.mathimata;

import java.util.Optional;

public final class DhlwshMathimatos {

    private final Thewria thewria;

    private final Optional<Ergasthrio> ergasthrio;

    public DhlwshMathimatos(Thewria thewria, Optional<Ergasthrio> ergasthrio) {
        if (ergasthrio.isPresent() && !thewria.getErgasthria().contains(ergasthrio)) {
            throw new IllegalArgumentException("To ergasthrio den anhkei sthn thewria.");
        }
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
