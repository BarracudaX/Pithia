package com.omada.pithia.model.mathimata;

import com.omada.pithia.model.xrhstes.Foititis;
import com.omada.pithia.model.xrhstes.Kathigitis;

import java.util.*;
import java.util.function.DoubleBinaryOperator;

public final class Thewria {
    
    private static final double MIN_VATHMOS = 0.0;
    private static final double MAX_VATHMOS = 10.0;

    private final String onomaMathimatos;

    private final Kathigitis kathigitisThewrias;

    private final Set<Foititis> foitites = new HashSet<>();

    private final Set<Ergasthrio> ergasthria = new HashSet<>();

    private final Set<Kathigitis> kathigitesErgasthriwn = new HashSet<>();

    private final Eksamhno eksamhno;

    private final Map<Foititis,VathmosThewrias> vathmoiThewrias = new HashMap<>();

    private DoubleBinaryOperator algorithmos;

    private final Set<Thewria> proapaitoumena = new HashSet<>();

    public Thewria(String onomaMathimatos, Kathigitis kathigitisThewrias, Eksamhno eksamhno) {
        this.onomaMathimatos = onomaMathimatos;
        this.kathigitisThewrias = kathigitisThewrias;
        this.eksamhno = eksamhno;
        this.kathigitisThewrias.addThewriaDidaskei(this);
    }

    public String getOnomaMathimatos() {
        return onomaMathimatos;
    }

    public Kathigitis getKathigiti() {
        return kathigitisThewrias;
    }

    public Set<Foititis> getFoitites() {
        return Collections.unmodifiableSet(foitites);
    }

    public Eksamhno getEksamhno() {
        return eksamhno;
    }

    public Set<Thewria> getProapaitoumena(){
        return Collections.unmodifiableSet(proapaitoumena);
    }

    public Set<Ergasthrio> getErgasthria(){
        return Collections.unmodifiableSet(ergasthria);
    }

    public Optional<Double> getVathmoThewrias(Foititis foititis) {
        VathmosThewrias vathmosThewrias = vathmoiThewrias.get(foititis);
        if (vathmosThewrias != null) {
            return Optional.of(vathmosThewrias.getVathmos());
        }

        return Optional.empty();
    }

    public final void addFoititi(Foititis foititis) {
        Objects.requireNonNull(foititis,"To antikeimeno foititis einai null.");

        IllegalArgumentException exceptions = new IllegalArgumentException();

        for (Thewria proapaitoumeno : proapaitoumena) {
            if (!proapaitoumeno.getVathmoThewrias(foititis).isPresent()
                    || proapaitoumeno.getVathmoThewrias(foititis).get() < 5.0) {
                exceptions.addSuppressed(new IllegalArgumentException(
                        "Ο/η φοιτητης/τρια με ονομα χρηστη " + foititis.getOnomaXrhsth()
                                + " δεν εχει περασει το προαπαιτουμενο μαθημα " +
                                proapaitoumeno.getOnomaMathimatos()));
            }
        }

        if (exceptions.getSuppressed().length != 0) {
            throw exceptions;
        }

        foitites.add(foititis);
        vathmoiThewrias.put(foititis,new VathmosThewrias(this, foititis,0));
        foititis.addThewria(this);
    }

    public final void addVathmoThewrias(double vathmosThewrias, Foititis foititis) {
        Objects.requireNonNull(foititis,"To antikeimeno foititis einai null.");
        
        if(Double.compare(MIN_VATHMOS, vathmosThewrias) > 0 || Double.compare(MAX_VATHMOS, vathmosThewrias) < 0) {
            throw new IllegalArgumentException(
                    "O vathmos "+vathmosThewrias+" einai lathos.Epitreptes times einai ["
                    +MIN_VATHMOS+","+MAX_VATHMOS+"]"
            );
        }

        if (vathmoiThewrias.replace(foititis,new VathmosThewrias(this,foititis,vathmosThewrias)) == null) {
            throw new IllegalArgumentException("Den mporw na dextw ton vathmo gia foititi/tria" + foititis
                    + " o/h opoios/oia den parakolouthei to mathima "+this+".");
        }
    }

    public Collection<? extends Ergasthrio> getErgasthriaKathigiti(Kathigitis kathigitis) {
        Set<Ergasthrio> ergasthria = new HashSet<>();

        for (Ergasthrio ergasthrio : this.ergasthria) {
            if (ergasthrio.getKathigiti().equals(kathigitis)) {
                ergasthria.add(ergasthrio);
            }
        }

        return ergasthria;
    }

    public final Collection<Foititis> getFoititesXwrisErgasthrio() {
        Collection<Foititis> oloiFoitites = new ArrayList<>(foitites);

        Collection<Foititis> foititesMeErgasthrio = new ArrayList<>();

        for (Ergasthrio ergasthrio : ergasthria) {
            foititesMeErgasthrio.addAll(ergasthrio.getFoitites());
        }

        oloiFoitites.removeAll(foititesMeErgasthrio);

        return oloiFoitites;
    }

    public final Optional<Ergasthrio> getErgasthrioFoititi(Foititis foititis) {
        Objects.requireNonNull(foititis, "To antikeimeno foitits einai null.");
        for (Ergasthrio ergasthrio : ergasthria) {
            if (ergasthrio.parakolouthei(foititis)) {
                return Optional.of(ergasthrio);
            }
        }

        return Optional.empty();
    }

    public final void addErgasthrio(Ergasthrio ergasthrio) {
        Objects.requireNonNull(ergasthrio,"To ergasthrio einai null.");
        ergasthria.add(ergasthrio);
        kathigitesErgasthriwn.add(ergasthrio.getKathigiti());
        ergasthrio.getKathigiti().addErgasthrioThewriasDidaskei(this);
    }

    public final void addFoititiStoErgasthrio(Foititis foititis, Ergasthrio ergasthrio) {
        Objects.requireNonNull(foititis, "To antikeimeno foititis einai null.");
        Objects.requireNonNull(ergasthrio, "To antikeimeno ergasthrio einai null.");

        if (!ergasthria.contains(ergasthrio)) {
            throw new IllegalArgumentException("Το εργαστηριο " + ergasthrio.getOnomaErgasthriou()
                    + "  δεν ανηκει στην θεωρια "+this.getOnomaMathimatos()+".");
        }

        if (!foitites.contains(foititis)) {
            throw new IllegalArgumentException("Ο/η φοιτητης/τρια με ονομα χρηστη " + foititis.getOnomaXrhsth()
                    + " δεν παρακολουθει την θεωρια "+this.getOnomaMathimatos()
                    +",οποτε δεν μπορει να δηλωσει κανενα εργαστηριο.");
        }

        ergasthrio.addFoititi(foititis);
    }

    public final void addProapaitoumeno(Thewria proapaitoumeno) {
        Objects.requireNonNull(proapaitoumeno, "To antikeimeno proapaitoumeno einai null.");

        if (equals(proapaitoumeno)) {
            throw new IllegalArgumentException("H thewria den mporei na einai proapaitoumeno ston eauto ths.");
        }

        if (!getEksamhno().einaiMegaluteroEksamhno(proapaitoumeno.getEksamhno())) {
            throw new IllegalArgumentException(
                    "To proapaitoumeno ths thewrias den mporei na einai megaluterou h idiou eksamhnou me thn thewria."+
                            "To eksamhno ths thewrias einai : "+getEksamhno()+",enw to eksamhno tou proapaitoumenou einai : "
                    +proapaitoumeno.getEksamhno()
            );
        }

        proapaitoumena.add(proapaitoumeno);
    }

    public final void removeProapaitoumeno(Thewria proapaitoumeno) {
        Objects.requireNonNull(proapaitoumeno, "To antikeimeno proapaitoumeno einai null.");

        proapaitoumena.remove(proapaitoumeno);
    }

    public final void saveAlgorythmo(double posostoThewrias, double posostoErgasthrio) {
        if (posostoErgasthrio + posostoThewrias > 1.0) {
            throw new IllegalArgumentException("Ta pososta einai lathos.Pososto thewrias = " + posostoThewrias
                    + ",pososto ergasthriou = " + posostoErgasthrio + ".Sto sunolo : " + (posostoErgasthrio + posostoThewrias) + " > 1.");
        }

        algorithmos = new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double vathmosThewrias, double vathmosErgasthrio) {
                return (posostoThewrias * vathmosThewrias) + (posostoErgasthrio * vathmosErgasthrio);
            }
        };
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Thewria)) {
            return false;
        }

        Thewria thewria = (Thewria) o;

        return getOnomaMathimatos().equals(thewria.getOnomaMathimatos())
                && getKathigiti().equals(thewria.getKathigiti());
    }

    public boolean parakolouthei(Foititis foititis) {
        return foitites.contains(foititis);
    }

    @Override
    public int hashCode() {
        int result = getOnomaMathimatos().hashCode();

        result = result * 31 + getKathigiti().hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "Thewria[" +
                "onomaMathimatos='" + getOnomaMathimatos() + '\'' +
                ", kathigitisThewrias=" + getKathigiti() +
                ", eksamhno=" + getEksamhno() +
                ", vathmoiThewrias=" + vathmoiThewrias +
                ", proapaitoumena=" + proapaitoumena +
                ",ergasthria="+ergasthria+
                ']';
    }

}
