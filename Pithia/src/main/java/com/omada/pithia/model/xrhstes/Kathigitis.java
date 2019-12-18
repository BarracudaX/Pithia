package com.omada.pithia.model.xrhstes;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Thewria;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Kathigitis extends Xrhsths {

	private final Set<Thewria> thewries = new HashSet<>();

	private final Set<Thewria> ergasthria_thewrias = new HashSet<>();

	public Kathigitis(String onoma, String epwnhmo, LocalDate hmeromhniaGennhshs, String onomaXrhsth, String kwdikos,String email) {
		super(onoma, epwnhmo, hmeromhniaGennhshs, onomaXrhsth, kwdikos, email);
		addRolo(Rolos.KATHIGITIS);
	}

	public Set<Thewria> getThewries(){
		return Collections.unmodifiableSet(thewries);
	}

	public Set<Ergasthrio> getErgasthria(){
		Set<Ergasthrio> ergasthria = new HashSet<>();

		for (Thewria thewria : ergasthria_thewrias) {
			ergasthria.addAll(thewria.getErgasthriaKathigiti(this));
		}

		return ergasthria;
	}

	public void addThewriaDidaskei(Thewria thewria) {
		thewries.add(thewria);
	}

	public void addErgasthrioThewriasDidaskei(Thewria thewria) {
		ergasthria_thewrias.add(thewria);
	}

}
