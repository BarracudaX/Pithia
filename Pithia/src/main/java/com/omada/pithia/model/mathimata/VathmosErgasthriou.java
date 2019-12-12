package com.omada.pithia.model.mathimata;

import com.omada.pithia.model.xrhstes.Foititis;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
class VathmosErgasthriou {

	@org.hibernate.annotations.Parent
	private Ergasthrio ergasthrio;

	@Column(name = "vathmos_ergasthriou",nullable = true)
	private double vathmos;

	@ManyToOne
	@JoinColumn(
			name = "onoma_xrhsth_foititi",
			nullable = false,
			foreignKey = @ForeignKey(name = "FK_VATHMOI_ERGASTHRIOU_ONOMA_XRHSTH_FOITITI")
	)
	private Foititis foititis;

	protected VathmosErgasthriou(){

	}

	public VathmosErgasthriou(Foititis foititis, Ergasthrio ergasthrio) {
		this(foititis, ergasthrio, 0);
	}

	public VathmosErgasthriou(Foititis foititis, Ergasthrio ergasthrio, double vathmos) {
		this.foititis = foititis;
		this.ergasthrio = ergasthrio;
		this.vathmos = vathmos;
	}

	public double getVathmos() {
		return vathmos;
	}

	public void setVathmos(double vathmos) {
		this.vathmos = vathmos;
	}

	public Foititis getFoititis() {
		return foititis;
	}

	public Ergasthrio getErgasthrio() {
		return ergasthrio;
	}

	public void setErgasthrio(Ergasthrio ergasthrio) {
		this.ergasthrio = ergasthrio;
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
