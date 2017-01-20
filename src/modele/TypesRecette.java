package modele;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TYPES_RECETTE database table.
 * 
 */
@Entity
@Table(name="TYPES_RECETTE")
@NamedQuery(name="TypesRecette.findAll", query="SELECT t FROM TypesRecette t")
public class TypesRecette implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TYPES_RECETTE_IDTYPE_GENERATOR", sequenceName="SEQ_TYPES_RECETTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TYPES_RECETTE_IDTYPE_GENERATOR")
	@Column(name="ID_TYPE", unique=true, nullable=false, precision=4)
	private long idType;

	@Column(name="TYPE_RECETTE", nullable=false, length=20)
	private String typeRecette;

	//bi-directional many-to-one association to Recette
	@OneToMany(mappedBy="typesRecette")
	private List<Recette> recettes;

	public TypesRecette() {
	}

	public long getIdType() {
		return this.idType;
	}

	public void setIdType(long idType) {
		this.idType = idType;
	}

	public String getTypeRecette() {
		return this.typeRecette;
	}

	public void setTypeRecette(String typeRecette) {
		this.typeRecette = typeRecette;
	}

	public List<Recette> getRecettes() {
		return this.recettes;
	}

	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}

	public Recette addRecette(Recette recette) {
		getRecettes().add(recette);
		recette.setTypesRecette(this);

		return recette;
	}

	public Recette removeRecette(Recette recette) {
		getRecettes().remove(recette);
		recette.setTypesRecette(null);

		return recette;
	}

}