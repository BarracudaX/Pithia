package com.omada.pithia.model.mathimata;

import com.omada.pithia.model.xrhstes.Foititis;

import java.util.Objects;

class VathmosErgasthriou {

	private final Ergasthrio ergasthrio;

	private final double vathmos;

	private final Foititis foititis;

	public VathmosErgasthriou(Foititis foititis, Ergasthrio ergasthrio, double vathmos) {
		this.foititis = foititis;
		this.ergasthrio = ergasthrio;
		this.vathmos = vathmos;
	}

	public double getVathmos() {
		return vathmos;
	}

	public Foititis getFoititis() {
		return foititis;
	}

	public Ergasthrio getErgasthrio() {
		return ergasthrio;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VathmosErgasthriou that = (VathmosErgasthriou) o;
		return Objects.equals(getErgasthrio(), that.getErgasthrio()) &&
				Objects.equals(getFoititis(), that.getFoititis());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getErgasthrio(), getFoititis());
	}
}
