package com.omada.pithia.model.xrhstes;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "XRHSTES")
@Inheritance(strategy = InheritanceType.JOINED)
public class Xrhsths {

	@Id
	@Column(name = "onoma_xrhsth",updatable = false)
	private volatile String onomaXrhsth;

	private volatile String onoma;

	private volatile String epwnhmo;

	@Column(name = "hmeromhnia_gennhshs")
	private volatile LocalDate hmeromhniaGennhshs;

	private volatile String kwdikos;

	private volatile String email;

	@ElementCollection
	@CollectionTable(
			name = "ROLOI_XRISTWN",
			joinColumns = {@JoinColumn(name = "onoma_xrhsth")},
			foreignKey = @ForeignKey(name = "FK_ROLOI_XRISTWN_ONOMA_XRHSTH")
	)
	@Enumerated(EnumType.STRING)
	@Column(name = "rolos")
	private volatile Set<Rolos> roloi = new HashSet<>();

	protected Xrhsths(){

	}

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

	public void setOnoma(String onoma) {
		this.onoma = onoma;
	}

	public void setEpwnhmo(String epwnhmo) {
		this.epwnhmo = epwnhmo;
	}

	public void setHmeromhniaGennhshs(LocalDate hmeromhniaGennhshs) {
		this.hmeromhniaGennhshs = hmeromhniaGennhshs;
	}

	public void setEmail(String email) {
		this.email = email;
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
