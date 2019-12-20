package com.omada.pithia.model.mathimata;

import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.model.xrhstes.Kathigitis;

import java.util.*;

public final class Ergasthrio {
    
    private static final double MIN_VATHMOS = 0.0;
    
    private static final double MAX_VATHMOS = 10.0;

    private final String onomaErgasthriou;

    private final Thewria thewria;

    private final Kathigitis kathigitis;

    private final Set<Foititis> foitites = new HashSet<>();

    private final Set<Apousia> apousies = new HashSet<>();

    private final Map<Foititis,VathmosErgasthriou> vathmoiErgasthriou = new HashMap<>();

    public Ergasthrio(String onomaErgasthriou, Kathigitis kathigitis,Thewria thewria) {
        this.kathigitis = kathigitis;
        this.thewria = thewria;
        this.onomaErgasthriou = onomaErgasthriou;
    }

    public Set<Foititis> getFoitites() {
        return Collections.unmodifiableSet(foitites);
    }

    public Kathigitis getKathigiti() {
        return kathigitis;
    }

    public String getOnomaErgasthriou() {
        return onomaErgasthriou;
    }

    public Thewria getThewria() {
        return thewria;
    }

    final void addFoititi(Foititis foititis) {
        Objects.requireNonNull(foititis, "To antikeimeno foititis einai null.");
        foitites.add(foititis);
        apousies.add(new Apousia(foititis, this));
        vathmoiErgasthriou.put(foititis,new VathmosErgasthriou(foititis, this,0));
    }

    public Optional<Apousia> getApousiesFoititi(Foititis foititis) {
        for (Apousia apousia : apousies) {
            if (apousia.getFoititis().equals(foititis)) {
                return Optional.of(apousia);
            }
        }
        return Optional.empty();
    }

    public Optional<Double> getVathmoErgasthriou(Foititis foititis) {
        VathmosErgasthriou vathmosErgasthriou = vathmoiErgasthriou.get(foititis);

        if (vathmosErgasthriou != null) {
            return Optional.of(vathmosErgasthriou.getVathmos());
        }

        return Optional.empty();
    }

    public void addVathmoErgasthriou(Foititis foititis, double vathmosErgasthriou) {
        Objects.requireNonNull(foititis, "To antikeimeno foititis einai null.");

        if(Double.compare(MIN_VATHMOS, vathmosErgasthriou) > 0 || Double.compare(MAX_VATHMOS, vathmosErgasthriou) < 0) {
            throw new IllegalArgumentException(
                    "O vathmos "+vathmosErgasthriou+" einai lathos.Epitreptes times einai ["
                    +MIN_VATHMOS+","+MAX_VATHMOS+"]"
            );
        }

        if (vathmoiErgasthriou.replace(foititis, new VathmosErgasthriou(foititis, this, vathmosErgasthriou)) == null) {
            throw new IllegalArgumentException("Den mporw na dextw ton vathmo gia foititi/tria" + foititis
                    + " o/h opoios/oia den parakolouthei to ergasthrio.");
        }
    }

    public boolean parakolouthei(Foititis foititis) {
        return foitites.contains(foititis);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Ergasthrio)) {
            return false;
        }

        Ergasthrio that = (Ergasthrio) o;

        return getOnomaErgasthriou().equals(that.getOnomaErgasthriou())
                && getThewria().equals(that.getThewria());
    }

    @Override
    public int hashCode() {
        int result = getOnomaErgasthriou().hashCode();

        result = result * 31 + getThewria().hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "Ergasthrio{"
                + "onomaErgasthriou='" + getOnomaErgasthriou() + '\''
                + ", kathigitis=" + getKathigiti();
    }
}
