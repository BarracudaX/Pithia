package com.omada.pithia.domain.xrhstes;

import com.omada.pithia.domain.mathimata.Ergasthrio;
import com.omada.pithia.domain.mathimata.Thewria;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "FOITITES")
@PrimaryKeyJoinColumn(name = "onoma_xrhsth_foititi",foreignKey = @ForeignKey(name = "FK_FOITITES_ONOMA_XRHSTH_FOITITI"))
public class Foititis extends Xrhsths {

	@ManyToMany(mappedBy = "foitites")
	private Set<Thewria> thewries = new HashSet<>();

	protected Foititis(){
		super();
	}

	public Foititis(String onoma, String epwnhmo, LocalDate hmeromhniaGennhshs, String onomaXrhsth, String kwdikos, String email){
		super(onoma, epwnhmo, hmeromhniaGennhshs, onomaXrhsth, kwdikos, email);
		addRolo(Rolos.FOITITIS);
	}

	public Set<Thewria> getThewries() {
		return Collections.unmodifiableSet(thewries);
	}

	public final void addThewria(Thewria thewria) {
		thewries.add(thewria);
	}

	public final Map<String,Double> getVathmous(){
		Map<String, Double> vathmoi = new HashMap<>();

		for (Thewria thewria : thewries) {
			vathmoi.put(thewria.getOnomaMathimatos(), thewria.getVathmoThewrias(this).orElse(0.0));

			Optional<Ergasthrio> ergasthrio = thewria.getErgasthrioFoititi(this);

			ergasthrio.ifPresent(value -> vathmoi.put(thewria.getOnomaMathimatos() + " : " + value.getOnomaErgasthriou(),
					value.getVathmoErgasthriou(this).get()));
		}

		return vathmoi;
	}

}
