package modele;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UNITES database table.
 * 
 */
@Entity
@Table(name="UNITES")
@NamedQuery(name="Unite.findAll", query="SELECT u FROM Unite u")
public class Unite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_UNITE", unique=true, nullable=false, precision=3)
	private long idUnite;

	@Column(name="NOM_UNITE", nullable=false, length=10)
	private String nomUnite;

	@Column(name="TYPE_UNITE", nullable=false, length=1)
	private String typeUnite;

	public Unite() {
	}

	public long getIdUnite() {
		return this.idUnite;
	}

	public void setIdUnite(long idUnite) {
		this.idUnite = idUnite;
	}

	public String getNomUnite() {
		return this.nomUnite;
	}

	public void setNomUnite(String nomUnite) {
		this.nomUnite = nomUnite;
	}

	public String getTypeUnite() {
		return this.typeUnite;
	}

	public void setTypeUnite(String typeUnite) {
		this.typeUnite = typeUnite;
	}

}