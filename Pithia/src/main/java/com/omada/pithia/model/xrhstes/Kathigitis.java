package com.omada.pithia.model.xrhstes;

import com.omada.pithia.model.mathimata.Ergasthrio;
import com.omada.pithia.model.mathimata.Thewria;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "KATHIGITES")
@PrimaryKeyJoinColumn(name = "onoma_xrhsth_kathigiti",foreignKey = @ForeignKey(name = "FK_KATHIGITES_ONOMA_XRHSTH_KATHIGITI"))
public class Kathigitis extends Xrhsths {

	@OneToMany(mappedBy = "kathigitisThewrias")
	private Set<Thewria> thewries = new HashSet<>();

	@ManyToMany(mappedBy = "kathigitesErgasthriwn")
	private Set<Thewria> ergasthria_thewrias = new HashSet<>();

	protected Kathigitis(){
		super();
	}

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
