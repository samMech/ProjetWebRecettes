package modele;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the USAGERS database table.
 * 
 */
@Entity
@Table(name="USAGERS")
@NamedQuery(name="Usager.findAll", query="SELECT u FROM Usager u")
public class Usager implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USAGERS_IDUSAGER_GENERATOR", sequenceName="SEQ_USAGERS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USAGERS_IDUSAGER_GENERATOR")
	@Column(name="ID_USAGER", unique=true, nullable=false, precision=6)
	private long idUsager;

	@Column(nullable=false, length=50)
	private String email;

	@Column(name="NOM_USAGER", nullable=false, length=30)
	private String nomUsager;

	@Column(nullable=false, length=8)
	private String password;

	//bi-directional many-to-one association to Recette
	@OneToMany(mappedBy="usager")
	private List<Recette> recettes;

	public Usager() {
	}

	public Usager(String nomUsager, String email, String password){
		this.nomUsager = nomUsager;
		this.email = email;
		this.password = password;
	}
	
	public long getIdUsager() {
		return this.idUsager;
	}

	public void setIdUsager(long idUsager) {
		this.idUsager = idUsager;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomUsager() {
		return this.nomUsager;
	}

	public void setNomUsager(String nomUsager) {
		this.nomUsager = nomUsager;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Recette> getRecettes() {
		return this.recettes;
	}

	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}

	public Recette addRecette(Recette recette) {
		getRecettes().add(recette);
		recette.setUsager(this);

		return recette;
	}

	public Recette removeRecette(Recette recette) {
		getRecettes().remove(recette);
		recette.setUsager(null);

		return recette;
	}

}