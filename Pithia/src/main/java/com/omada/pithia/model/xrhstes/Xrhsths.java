package com.omada.pithia.model.xrhstes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Xrhsths {

	private final String onomaXrhsth;

	private final String onoma;

	private final String epwnhmo;

	private final LocalDate hmeromhniaGennhshs;

	private final String kwdikos;

	private final String email;

	private final Set<Rolos> roloi = new HashSet<>();

	public Xrhsths(String onoma, String epwnhmo, LocalDate hmeromhniaGennhshs, String onomaXrhsth, String kwdikos,String email) {
		this.onoma = onoma;
		this.epwnhmo = epwnhmo;
		this.hmeromhniaGennhshs = hmeromhniaGennhshs;
		this.onomaXrhsth = onomaXrhsth;
		this.kwdikos = kwdikos;
		this.email = email;
	}

	public String getOnoma() {
		return onoma;
	}

	public String getEpwnhmo() {
		return epwnhmo;
	}

	public LocalDate getHmeromhniaGennhshs() {
		return hmeromhniaGennhshs;
	}

	public String getOnomaXrhsth() {
		return onomaXrhsth;
	}

	public String getKwdikos() {
		return kwdikos;
	}

	public Set<Rolos> getRoloi() {
		return Collections.unmodifiableSet(roloi);
	}

	public String getEmail() {
		return email;
	}

	public final void addRolo(Rolos role) {
		roloi.add(role);
	}

	public final void removeRolo(Rolos role) {
		roloi.remove(role);
	}

	public final boolean hasRole(Rolos role) {
		return roloi.contains(role);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Xrhsths)) {
			return false;
		}

		Xrhsths xrhsths = (Xrhsths) o;

		return getOnomaXrhsth().equals(xrhsths.getOnomaXrhsth()) ;
	}

	@Override
	public int hashCode() {
		return getOnomaXrhsth().hashCode();
	}

	@Override
	public String toString() {
		return "Xrhsths{" +
				"onomaXrhsth='" + getOnomaXrhsth() + '\'' +
				", onoma='" + getOnoma() + '\'' +
				", epwnhmo='" + getEpwnhmo() + '\'' +
				", hmeromhniaGennhshs=" + getHmeromhniaGennhshs() +
				", kwdikos='" + getKwdikos() + '\'' +
				", email='" + getEmail() + '\'' +
				", roloi=" + getRoloi() +
				'}';
	}
}
