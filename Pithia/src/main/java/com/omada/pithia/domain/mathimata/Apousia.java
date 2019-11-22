package com.omada.pithia.domain.mathimata;

import com.omada.pithia.domain.xrhstes.Foititis;
import javax.persistence.*;
import java.util.Objects;

@Embeddable
public class Apousia {

	@ManyToOne
	@JoinColumn(
			name = "onoma_xrhsth_foititi",
			foreignKey = @ForeignKey(name = "FK_APOUSIES_ONOMA_XRHSTH_FOITITI")
	)
	private volatile Foititis foititis;

	@Column(name = "arithmos_apoysiwn",nullable = false)
	private volatile int arithmosApousiwn;

	@org.hibernate.annotations.Parent
	private volatile Ergasthrio ergasthrio;

	protected Apousia(){

	}

	public Apousia(Foititis foititis, Ergasthrio ergasthrio) {
		this.ergasthrio = ergasthrio;
		this.foititis = foititis;
	}

	public void setErgasthrio(Ergasthrio ergasthrio) {
		this.ergasthrio = ergasthrio;
	}

	public Ergasthrio getErgasthrio() {
		return ergasthrio;
	}

	public synchronized int getArithmosApousiwn() {
		return arithmosApousiwn;
	}

	public Foititis getFoititis() {
		return foititis;
	}

	public final void aukshshApousiwn() {
		arithmosApousiwn++;
	}

	public final void meiwshApousiwn(){
		arithmosApousiwn--;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Apousia apousia = (Apousia) o;
		return Objects.equals(foititis, apousia.foititis) &&
				Objects.equals(getErgasthrio(), apousia.getErgasthrio());
	}

	@Override
	public int hashCode() {
		return Objects.hash(foititis, getErgasthrio());
	}
}
