package modele;

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
	@SequenceGenerator(name="INGREDIENTS_IDINGREDIENT_GENERATOR", sequenceName="SEQ_INGREDIENTS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INGREDIENTS_IDINGREDIENT_GENERATOR")
	@Column(name="ID_INGREDIENT", unique=true, nullable=false, precision=6)
	private long idIngredient;

	@Column(name="NOM_INGREDIENT", nullable=false, length=30)
	private String nomIngredient;

	//bi-directional many-to-one association to CategoriesIngredient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CATEGORIE_ING", nullable=false)
	private CategoriesIngredient categoriesIngredient;

	//uni-directional many-to-many association to Recette
	@ManyToMany
	@JoinTable(
		name="MESURES"
		, joinColumns={
			@JoinColumn(name="ID_INGREDIENT", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="ID_RECETTE", nullable=false)
			}
		)
	private List<Recette> recettes;

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

	public CategoriesIngredient getCategoriesIngredient() {
		return this.categoriesIngredient;
	}

	public void setCategoriesIngredient(CategoriesIngredient categoriesIngredient) {
		this.categoriesIngredient = categoriesIngredient;
	}

	public List<Recette> getRecettes() {
		return this.recettes;
	}

	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}

}