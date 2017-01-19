package modele;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MESURES database table.
 * 
 */
@Entity
@Table(name="MESURES")
@NamedQuery(name="Mesure.findAll", query="SELECT m FROM Mesure m")
public class Mesure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_MESURE", unique=true, nullable=false, precision=10)
	private long idMesure;

	@Column(nullable=false, precision=5, scale=2)
	private BigDecimal quantite;

	//bi-directional many-to-one association to Ingredient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_INGREDIENT", nullable=false)
	private Ingredient ingredient;

	//bi-directional many-to-one association to Recette
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_RECETTE", nullable=false)
	private Recette recette;

	public Mesure() {
	}

	public long getIdMesure() {
		return this.idMesure;
	}

	public void setIdMesure(long idMesure) {
		this.idMesure = idMesure;
	}

	public BigDecimal getQuantite() {
		return this.quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public Ingredient getIngredient() {
		return this.ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Recette getRecette() {
		return this.recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

}