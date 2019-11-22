package com.omada.pithia.domain.mathimata;

import com.omada.pithia.domain.xrhstes.Foititis;
import com.omada.pithia.domain.xrhstes.Kathigitis;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "ERGASTHRIA")
public class Ergasthrio {

	@Id
	@Column(name = "onoma_ergasthriou",updatable = false)
	private volatile String onomaErgasthriou;

	@ManyToOne
	@JoinColumn(
			name = "onoma_xrhsth_kathigiti",
			foreignKey = @ForeignKey(name = "FK_ERGASTHRIA_ONOMA_XRHSTH_KATHIGITI")
	)
	private volatile Kathigitis kathigitis;


	@ManyToMany
	@JoinTable(
			name = "ERGASTHRIA_PARAKOLOUTHOUN",
			joinColumns = @JoinColumn(
					name = "onoma_ergasthriou",
					foreignKey = @ForeignKey(name = "FK_ERGASTHRIA_PARAKOLOUTHOUN_ONOMA_ERGASTHRIOU")
			),
			inverseJoinColumns = @JoinColumn(
					name = "onoma_xrhsth_foititi",
					foreignKey = @ForeignKey(name = "FK_ERGASTHRIA_PARAKOLOUTHOUN_ONOMA_XRHSTH_FOITITI")
			)
	)
	private volatile Set<Foititis> foitites = new HashSet<>();

	@ElementCollection
	@CollectionTable(
			name = "APOUSIES",
			joinColumns = @JoinColumn(
					name = "onoma_ergasthriou",
					nullable = false,
					foreignKey = @ForeignKey(name = "FK_APOUSIES_ONOMA_ERGASTHRIOU")
			)
	)
	private volatile Set<Apousia> apousies = new HashSet<>();

	@ElementCollection
	@CollectionTable(
			name = "VATHMOI_ERGASTHRIOU",
			joinColumns = @JoinColumn(
					name = "onoma_ergasthriou",
					foreignKey = @ForeignKey(name = "FK_VATHMOI_ERGASTHRIOU_ONOMA_ERGASTHRIOU")
			)
	)
	private volatile Set<VathmosErgasthriou> vathmoiErgasthriou = new HashSet<>();

	protected Ergasthrio(){

	}

	public Ergasthrio(String onomaErgasthriou, Kathigitis kathigitis) {
		this.kathigitis = kathigitis;
		this.onomaErgasthriou = onomaErgasthriou;
	}

	public Set<Foititis> getFoitites() {
		return Collections.unmodifiableSet(foitites);
	}

	public Kathigitis getKathigiti() {
		return kathigitis;
	}

	public Map<Foititis,Integer> getApousies() {
		Map<Foititis, Integer> apousies = new HashMap<>();

		for (Apousia apousia : this.apousies) {
			apousies.put(apousia.getFoititis(), apousia.getArithmosApousiwn());
		}

		return apousies;
	}

	public Map<Foititis,Double> getVathmousErgasthriou(){
		Map<Foititis, Double> vathmoi = new HashMap<>();

		for (VathmosErgasthriou vathmos : vathmoiErgasthriou) {
			vathmoi.put(vathmos.getFoititis(), vathmos.getVathmos());
		}

		return vathmoi;
	}

	public String getOnomaErgasthriou() {
		return onomaErgasthriou;
	}

	public Optional<Double> getVathmo(Foititis foititis) {

		for (VathmosErgasthriou vathmosErgasthriou : vathmoiErgasthriou) {
			if (vathmosErgasthriou.getFoititis().equals(foititis)) {
				return Optional.of(vathmosErgasthriou.getVathmos());
			}
		}

		return Optional.empty();
	}

	public final void addFoititi(Foititis foititis) {
		foitites.add(foititis);
		apousies.add(new Apousia(foititis,this));
		vathmoiErgasthriou.add(new VathmosErgasthriou(foititis, this));
	}

	public final Optional<Apousia> getApousiesFoititi(Foititis foititis) {
		for (Apousia apousia : apousies) {
			if (apousia.getFoititis().equals(foititis)) {
				return Optional.of(apousia);
			}
		}
		return Optional.empty();
	}

	public final Optional<Double> getVathmoErgasthriou(Foititis foititis) {
		for (VathmosErgasthriou vathmosErgasthriou : vathmoiErgasthriou) {
			if (vathmosErgasthriou.getFoititis().equals(foititis)) {
				return Optional.of(vathmosErgasthriou.getVathmos());
			}
		}

		return Optional.empty();
	}

	public final void addVathmoErgasthriou(Foititis foititis, double vathmos) {

		for (VathmosErgasthriou vathmosErgasthriou : vathmoiErgasthriou) {
			if (vathmosErgasthriou.getFoititis().equals(foititis)) {
				vathmosErgasthriou.setVathmos(vathmos);
				return;
			}
		}

		throw new IllegalArgumentException("Den mporw na dextw ton vathmo gia foititi/tria" + foititis
				+ " o/h opoios/oia den parakolouthei to ergasthrio.");

	}

	public final boolean parakolouthei(Foititis foititis) {
		return foitites.contains(foititis);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof Ergasthrio)) return false;

		Ergasthrio that = (Ergasthrio) o;

		return getOnomaErgasthriou().equals(that.getOnomaErgasthriou()) &&
				getKathigiti().equals(that.getKathigiti());
	}

	@Override
	public int hashCode() {
		int result = getOnomaErgasthriou().hashCode();

		 result = result * 31 + getKathigiti().hashCode();

		return result;
	}

	@Override
	public String toString() {
		return "Ergasthrio{" +
				"onomaErgasthriou='" + getOnomaErgasthriou() + '\'' +
				", kathigitis=" + getKathigiti() ;
	}
}
