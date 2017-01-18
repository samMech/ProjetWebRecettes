package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CATEGORIES database table.
 * 
 */
@Entity
@Table(name="CATEGORIES")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_CATEGORIE", unique=true, nullable=false, precision=4)
	private long idCategorie;

	@Column(name="NOM_CATEGORIE", nullable=false, length=20)
	private String nomCategorie;

	//bi-directional many-to-one association to Ingredient
	@OneToMany(mappedBy="category")
	private List<Ingredient> ingredients;

	public Category() {
	}

	public long getIdCategorie() {
		return this.idCategorie;
	}

	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return this.nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Ingredient addIngredient(Ingredient ingredient) {
		getIngredients().add(ingredient);
		ingredient.setCategory(this);

		return ingredient;
	}

	public Ingredient removeIngredient(Ingredient ingredient) {
		getIngredients().remove(ingredient);
		ingredient.setCategory(null);

		return ingredient;
	}

}