package com.omada.pithia.domain.mathimata;

import com.omada.pithia.domain.xrhstes.Foititis;
import com.omada.pithia.domain.xrhstes.Kathigitis;

import javax.persistence.*;
import java.util.*;
import java.util.function.DoubleBinaryOperator;

@Entity
@Table(name = "THEWRIES")
public class Thewria {

	@Id
	@Column(name = "onoma_mathimatos",updatable = false)
	private String onomaMathimatos;

	@ManyToOne(optional = false)
	@JoinColumn(
			nullable = false,
			name = "onoma_xrhsth_kathigiti",
			foreignKey = @ForeignKey(name = "FK_THEWRIAS_ONOMA_XRHSTH_KATHIGITI")
	)
	private Kathigitis kathigitisThewrias;

	@ManyToMany
	@JoinTable(
			name = "THEWRIA_PARAKOLOUTHOUN",
			joinColumns = @JoinColumn(
					name = "onoma_thewrias",
					foreignKey = @ForeignKey(name = "FK_THEWRIA_PARAKOLOUTHOUN_ONOMA_THEWRIAS")
			),
			inverseJoinColumns = @JoinColumn(
					name = "onoma_xrhsth_foititi",
					foreignKey = @ForeignKey(name = "FK_THEWRIA_PARAKOLOUTHOUN_ONOMA_XRHSTH_FOITITI")
			)
	)
	private Set<Foititis> foitites = new HashSet<>();

	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinTable(
			name = "ERGASTHRIA_THEWRIAS",
			joinColumns = @JoinColumn(
					name = "onoma_thewrias",
					foreignKey = @ForeignKey(name = "FK_ERGASTHRIA_THEWRIAS_ONOMA_THEWRIAS")
			),
			inverseJoinColumns = @JoinColumn(
					name = "onoma_ergasthriou",
					foreignKey = @ForeignKey(name = "FK_ERGASTHRIA_THEWRIAS_ONOMA_ERGASTHRIOU")
			)
	)
	private Set<Ergasthrio> ergasthria = new HashSet<>();

	@ManyToMany
	@JoinTable(
			name = "KATHIGITES_ERGASTHRIWN",
			joinColumns = @JoinColumn(
					name = "onoma_thewrias",
					foreignKey = @ForeignKey(name = "FK_KATHIGITES_ERGASTHRIWN_ONOMA_THEWRIAS")
			),
			inverseJoinColumns = @JoinColumn(
					name = "onoma_xrhsth_kathigiti",
					foreignKey = @ForeignKey(name = "FK_KATHIGITES_ERGASTHRIWN_ONOMA_XRHSTH_KATHIGITI")
			)
	)
	private Set<Kathigitis> kathigitesErgasthriwn = new HashSet<>();

	@Enumerated(EnumType.STRING)
	private Eksamhno eksamhno;

	@ElementCollection
	@CollectionTable(
			name = "VATHMOI_THEWRIAS",
			joinColumns = @JoinColumn(
					name = "onoma_thewrias",
					foreignKey = @ForeignKey(name = "VATHMOI_THEWRIAS_ONOMA_THEWRIAS")
			)
	)
	private Set<VathmosThewrias> vathmoiThewrias = new HashSet<>();

	@Transient
	private DoubleBinaryOperator algorithmos;

	protected Thewria(){
		super();
	}

	public Thewria(String onomaMathimatos, Kathigitis kathigitisThewrias,Eksamhno eksamhno) {
		this.onomaMathimatos = onomaMathimatos;
		this.kathigitisThewrias = kathigitisThewrias;
		this.eksamhno = eksamhno;
	}

	public String getOnomaMathimatos() {
		return onomaMathimatos;
	}

	public Kathigitis getKathigiti() {
		return kathigitisThewrias;
	}

	public Set<Foititis> getFoitites() {
		return Collections.unmodifiableSet(foitites);
	}

	public Eksamhno getEksamhno() {
		return eksamhno;
	}

	public Set<Ergasthrio> getErgasthria(){
		return Collections.unmodifiableSet(ergasthria);
	}

	public Optional<Double> getVathmoThewrias(Foititis foititis) {
		for (VathmosThewrias vathmoiThewria : vathmoiThewrias) {
			if (vathmoiThewria.getFoititis().equals(foititis)) {
				return Optional.of(vathmoiThewria.getVathmos());
			}
		}
		return Optional.empty();
	}

	public final void addFoititi(Foititis foititis) {
		foitites.add(foititis);
		vathmoiThewrias.add(new VathmosThewrias(this, foititis));
		foititis.addThewria(this);
	}

	public final void addVathmoThewrias(double vathmosThewrias, Foititis foititis) {

		for (Iterator<VathmosThewrias> it_vathmoi = vathmoiThewrias.iterator(); it_vathmoi.hasNext(); ) {
			VathmosThewrias vathmos = it_vathmoi.next();
			if (vathmos.getFoititis().equals(foititis)) {
				vathmos.setVathmos(vathmosThewrias);
				return;
			}
		}

		throw new IllegalArgumentException("Den mporw na dextw ton vathmo gia foititi/tria" + foititis
				+ " o/h opoios/oia den parakolouthei to mathima");

	}

	public Collection<? extends Ergasthrio> getErgasthriaKathigiti(Kathigitis kathigitis) {
		Set<Ergasthrio> ergasthria = new HashSet<>();

		for (Ergasthrio ergasthrio : this.ergasthria) {
			if (ergasthrio.getKathigiti().equals(kathigitis)) {
				ergasthria.add(ergasthrio);
			}
		}

		return ergasthria;
	}

	public final Collection<Foititis> getFoititesXwrisErgasthrio(){
		Collection<Foititis> oloiFoitites = new ArrayList<>(foitites);

		Collection<Foititis> foititesMeErgasthrio = new ArrayList<>();

		for (Ergasthrio ergasthrio : ergasthria) {
			foititesMeErgasthrio.addAll(ergasthrio.getFoitites());
		}

		oloiFoitites.removeAll(foititesMeErgasthrio);

		return oloiFoitites;
	}

	public Optional<Ergasthrio> getErgasthrioFoititi(Foititis foititis) {
		for (Ergasthrio ergasthrio : ergasthria) {
			if (ergasthrio.parakolouthei(foititis)) {
				return Optional.of(ergasthrio);
			}
		}

		return Optional.empty();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof Thewria)) {
			return false;
		}

		Thewria thewria = (Thewria) o;

		return getOnomaMathimatos().equals(thewria.getOnomaMathimatos()) &&
				getKathigiti().equals(thewria.getKathigiti());
	}

	@Override
	public int hashCode() {
		int result = getOnomaMathimatos().hashCode();

		result = result*31 + getKathigiti().hashCode();

		return result;
	}


}
