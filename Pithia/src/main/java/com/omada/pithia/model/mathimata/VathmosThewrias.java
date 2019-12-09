package com.omada.pithia.model.mathimata;

import com.omada.pithia.model.xrhstes.Foititis;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
class VathmosThewrias {

	@org.hibernate.annotations.Parent
	private Thewria thewria;

	@Column(name = "vathmos_thewrias")
	private double vathmos;

	@ManyToOne
	@JoinColumn(
			name = "onoma_xrhsth_foititi",
			nullable = false,
			foreignKey = @ForeignKey(name = "FK_VATHMOI_THEWRIAS_ONOMA_XRHSTH_FOITITI")
	)
	private Foititis foititis;

	protected VathmosThewrias(){

	}

	public VathmosThewrias(Thewria thewria, Foititis foititis) {
		this(thewria, foititis, 0);
	}

	public VathmosThewrias(Thewria thewria, Foititis foititis, double vathmos) {
		this.thewria = thewria;
		this.foititis = foititis;
		this.vathmos = vathmos;
	}

	public Thewria getThewria() {
		return thewria;
	}

	public void setThewria(Thewria thewria) {
		this.thewria = thewria;
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
