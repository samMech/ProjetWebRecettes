package modele;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INSTRUCTIONS database table.
 * 
 */
@Entity
@Table(name="INSTRUCTIONS")
@NamedQuery(name="Instruction.findAll", query="SELECT i FROM Instruction i")
public class Instruction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INSTRUCTIONS_IDINSTRUCTION_GENERATOR", sequenceName="SEQ_INSTRUCTIONS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INSTRUCTIONS_IDINSTRUCTION_GENERATOR")
	@Column(name="ID_INSTRUCTION", unique=true, nullable=false, precision=20)
	private long idInstruction;

	@Column(name="DESC_INSTRUCTION", nullable=false, length=2000)
	private String descInstruction;

	//bi-directional many-to-one association to Recette
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_RECETTE", nullable=false)
	private Recette recette;

	public Instruction() {
	}

	public long getIdInstruction() {
		return this.idInstruction;
	}

	public void setIdInstruction(long idInstruction) {
		this.idInstruction = idInstruction;
	}

	public String getDescInstruction() {
		return this.descInstruction;
	}

	public void setDescInstruction(String descInstruction) {
		this.descInstruction = descInstruction;
	}

	public Recette getRecette() {
		return this.recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

}