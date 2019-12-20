package com.omada.pithia.model.mathimata;

import com.omada.pithia.model.xrhstes.Foititis;

import java.util.Objects;

final class VathmosThewrias {

	private final Thewria thewria;

	private final double vathmos;

	private final Foititis foititis;

	public VathmosThewrias(Thewria thewria, Foititis foititis, double vathmos) {
		this.thewria = thewria;
		this.foititis = foititis;
		this.vathmos = vathmos;
	}

	public Thewria getThewria() {
		return thewria;
	}

	public double getVathmos() {
		return vathmos;
	}

	public Foititis getFoititis() {
		return foititis;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		VathmosThewrias that = (VathmosThewrias) o;
		return Objects.equals(getThewria(), that.getThewria()) &&
				Objects.equals(getFoititis(), that.getFoititis());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getThewria(), getFoititis());
	}

}
