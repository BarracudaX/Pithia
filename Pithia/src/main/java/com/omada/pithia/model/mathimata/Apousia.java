package com.omada.pithia.model.mathimata;

import com.omada.pithia.model.xrhstes.Foititis;
import java.util.Objects;

public final class Apousia {

	private final Foititis foititis;

	private volatile int arithmosApousiwn;

	private final Ergasthrio ergasthrio;

	public Apousia(Foititis foititis, Ergasthrio ergasthrio) {
		this.ergasthrio = ergasthrio;
		this.foititis = foititis;
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
		if (arithmosApousiwn > 0) {
			arithmosApousiwn--;
		}
	}

	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Apousia apousia = (Apousia) o;
		return Objects.equals(foititis, apousia.foititis) &&
				Objects.equals(getErgasthrio(), apousia.getErgasthrio());
	}

	public int hashCode() {
		return Objects.hash(foititis, getErgasthrio());
	}
}
