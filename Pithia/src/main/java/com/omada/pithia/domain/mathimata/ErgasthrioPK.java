package com.omada.pithia.domain.mathimata;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
class ErgasthrioPK implements Serializable {

    @Column(name = "onoma_thewrias")
    private String onomaThewrias;

    @Column(name = "onoma_ergasthriou")
    private String onomaErgasthriou;


    protected ErgasthrioPK() {

    }

    public ErgasthrioPK(String onomaErgasthriou,String onomaThewrias) {
        this.onomaErgasthriou = onomaErgasthriou;
        this.onomaThewrias = onomaThewrias;
    }

    public String getOnomaThewrias() {
        return onomaThewrias;
    }

    public String getOnomaErgasthriou() {
        return onomaErgasthriou;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErgasthrioPK)) {
            return false;
        }

        ErgasthrioPK pk = (ErgasthrioPK) o;

        return getOnomaErgasthriou().equals(pk.getOnomaErgasthriou()) && getOnomaThewrias().equals(pk.getOnomaThewrias());
    }

    @Override
    public int hashCode() {
        int result = getOnomaThewrias().hashCode();
        result = 31 * result + getOnomaErgasthriou().hashCode();
        return result;
    }
}
