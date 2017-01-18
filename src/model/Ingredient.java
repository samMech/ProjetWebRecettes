package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the INGREDIENTS database table.
 * 
 */
@Entity
@Table(name="INGREDIENTS")
@NamedQuery(name="Ingredient.findAll", query="SELECT i FROM Ingredient i")
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_INGREDIENT", unique=true, nullable=false, precision=6)
	private long idIngredient;

	@Column(name="NOM_INGREDIENT", nullable=false, length=30)
	private String nomIngredient;

	//bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CATEGORIE", nullable=false)
	private Category category;

	//bi-directional many-to-one association to Mesure
	@OneToMany(mappedBy="ingredient")
	private List<Mesure> mesures;

	public Ingredient() {
	}

	public long getIdIngredient() {
		return this.idIngredient;
	}

	public void setIdIngredient(long idIngredient) {
		this.idIngredient = idIngredient;
	}

	public String getNomIngredient() {
		return this.nomIngredient;
	}

	public void setNomIngredient(String nomIngredient) {
		this.nomIngredient = nomIngredient;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Mesure> getMesures() {
		return this.mesures;
	}

	public void setMesures(List<Mesure> mesures) {
		this.mesures = mesures;
	}

	public Mesure addMesure(Mesure mesure) {
		getMesures().add(mesure);
		mesure.setIngredient(this);

		return mesure;
	}

	public Mesure removeMesure(Mesure mesure) {
		getMesures().remove(mesure);
		mesure.setIngredient(null);

		return mesure;
	}

}