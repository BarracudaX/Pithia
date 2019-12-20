package com.omada.pithia.model.xrhstes;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Thewria;

import java.time.LocalDate;
import java.util.*;

public final class Foititis extends Xrhsths {

	private final Set<Thewria> thewries = new HashSet<>();

	public Foititis(String onoma, String epwnhmo, LocalDate hmeromhniaGennhshs, String onomaXrhsth, String kwdikos, String email){
		super(onoma, epwnhmo, hmeromhniaGennhshs, onomaXrhsth, kwdikos, email);
		addRolo(Rolos.FOITITIS);
	}

	public Set<Thewria> getThewries() {
		return Collections.unmodifiableSet(thewries);
	}

	public void addThewria(Thewria thewria) {
		thewries.add(thewria);
	}

	public Map<String,Double> getVathmous(){

		Map<String, Double> vathmoi = new HashMap<>();

		for (Thewria thewria : thewries) {
			vathmoi.put(thewria.getOnomaMathimatos(), thewria.getVathmoThewrias(this).orElse(0.0));

			Optional<Ergasthrio> ergasthrio = thewria.getErgasthrioFoititi(this);

			ergasthrio.ifPresent(value -> vathmoi.put(
						thewria.getOnomaMathimatos() + " : " + value.getOnomaErgasthriou(),
						value.getVathmoErgasthriou(this).get()
					)
			);
		}

		return vathmoi;
	}

}
