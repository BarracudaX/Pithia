package com.omada.pithia.model.xrhstes;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

public class Xrhsths {

	private static final Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$",Pattern.CASE_INSENSITIVE);

	private final String onomaXrhsth;

	private final String onoma;

	private final String epwnhmo;

	private final LocalDate hmeromhniaGennhshs;

	private final String email;

	private final Set<Rolos> roloi = new HashSet<>();

	private String kwdikos;

	public Xrhsths(String onoma, String epwnhmo, LocalDate hmeromhniaGennhshs, String onomaXrhsth, String kwdikos, String email) {
		Objects.requireNonNull(onoma,"Το ονομα ειναι null.");
		Objects.requireNonNull(epwnhmo,"Το επωνυμο ειναι null.");
		Objects.requireNonNull(hmeromhniaGennhshs,"Η ημερομηνια γεννησης ειναι null.");
		Objects.requireNonNull(onomaXrhsth,"Το ονομα χρηστη ειναι null.");
		Objects.requireNonNull(kwdikos,"Ο κωδικος ειναι null.");
		Objects.requireNonNull(email, "Το εμαιλ ειναι null.");

		if (onoma.trim().length() == 0) {
			throw new IllegalArgumentException("Το ονομα του χρηστη δεν μπορει να ειναι κενο!");
		}

		if (epwnhmo.trim().length() == 0) {
			throw new IllegalArgumentException("Το επωνυμο του χρηστη δεν μπορει να ειναι κενο!");
		}

		if (hmeromhniaGennhshs.compareTo(LocalDate.now().minusYears(18)) > 0) {
			throw new IllegalArgumentException("Ο χρηστης πρεπει να ειναι τουλαχιστον 18 χρονων.");
		}

		if (onomaXrhsth.trim().length() < 8) {
			throw new IllegalArgumentException("Το ονομα χρηστη πρεπει να αποτελειται τουλαχιστον απο 8 χαρακτηρες");
		}

		if (kwdikos.trim().length() < 8) {
			throw new IllegalArgumentException("Ο κωδικος πρεπει να αποτελειται τουλαχιστον απο 8 χαρακτηρες");
		}

		if (!emailPattern.matcher(email.trim()).matches()) {
			throw new IllegalArgumentException("Το εμαιλ δεν ειναι σωστο." +
					"Το εμαιλ πρεπει να ακολουθει το εξης pattern : ^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$");
		}

		this.onoma = onoma.trim();
		this.epwnhmo = epwnhmo.trim();
		this.hmeromhniaGennhshs = hmeromhniaGennhshs;
		this.onomaXrhsth = onomaXrhsth.trim();
		this.kwdikos = kwdikos.trim();
		this.email = email.trim();
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

	public void setKwdikos(String kwdikos) {
		this.kwdikos = kwdikos;
	}

	public void addRolo(Rolos role) {
		roloi.add(role);
	}

	public void removeRolo(Rolos role) {
		roloi.remove(role);
	}

	public boolean hasRole(Rolos role) {
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
