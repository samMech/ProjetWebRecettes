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
	@SequenceGenerator(name="UNITES_IDUNITE_GENERATOR", sequenceName="SEQ_UNITES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNITES_IDUNITE_GENERATOR")
	@Column(name="ID_UNITE", unique=true, nullable=false, precision=3)
	private long idUnite;

	@Column(name="NOM_UNITE", nullable=true, length=10)
	private String nomUnite;

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
}