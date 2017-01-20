package modele;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CATEGORIES_INGREDIENT database table.
 * 
 */
@Entity
@Table(name="CATEGORIES_INGREDIENT")
@NamedQuery(name="CategoriesIngredient.findAll", query="SELECT c FROM CategoriesIngredient c")
public class CategoriesIngredient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATEGORIES_INGREDIENT_IDCATEGORIEING_GENERATOR", sequenceName="SEQ_CATEGORIES_INGREDIENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORIES_INGREDIENT_IDCATEGORIEING_GENERATOR")
	@Column(name="ID_CATEGORIE_ING", unique=true, nullable=false, precision=4)
	private long idCategorieIng;

	@Column(name="NOM_CATEGORIE_ING", nullable=false, length=20)
	private String nomCategorieIng;

	//bi-directional many-to-one association to Ingredient
	@OneToMany(mappedBy="categoriesIngredient")
	private List<Ingredient> ingredients;

	public CategoriesIngredient() {
	}

	public long getIdCategorieIng() {
		return this.idCategorieIng;
	}

	public void setIdCategorieIng(long idCategorieIng) {
		this.idCategorieIng = idCategorieIng;
	}

	public String getNomCategorieIng() {
		return this.nomCategorieIng;
	}

	public void setNomCategorieIng(String nomCategorieIng) {
		this.nomCategorieIng = nomCategorieIng;
	}

	public List<Ingredient> getIngredients() {
		return this.ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public Ingredient addIngredient(Ingredient ingredient) {
		getIngredients().add(ingredient);
		ingredient.setCategoriesIngredient(this);

		return ingredient;
	}

	public Ingredient removeIngredient(Ingredient ingredient) {
		getIngredients().remove(ingredient);
		ingredient.setCategoriesIngredient(null);

		return ingredient;
	}

}