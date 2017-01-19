package modele;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the RECETTES database table.
 * 
 */
@Entity
@Table(name="RECETTES")
@NamedQuery(name="Recette.findAll", query="SELECT r FROM Recette r")
public class Recette implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_RECETTE", unique=true, nullable=false, precision=8)
	private long idRecette;

	@Column(name="DESCRIPTION_RECETTE", nullable=false, length=1000)
	private String descriptionRecette;

	@Column(name="DUREE_RECETTE", nullable=false, precision=6)
	private BigDecimal dureeRecette;

	@Column(name="NOM_RECETTE", nullable=false, length=100)
	private String nomRecette;

	//bi-directional many-to-one association to Instruction
	@OneToMany(mappedBy="recette")
	private List<Instruction> instructions;

	//bi-directional many-to-one association to Mesure
	@OneToMany(mappedBy="recette")
	private List<Mesure> mesures;

	public Recette() {
	}

	public long getIdRecette() {
		return this.idRecette;
	}

	public void setIdRecette(long idRecette) {
		this.idRecette = idRecette;
	}

	public String getDescriptionRecette() {
		return this.descriptionRecette;
	}

	public void setDescriptionRecette(String descriptionRecette) {
		this.descriptionRecette = descriptionRecette;
	}

	public BigDecimal getDureeRecette() {
		return this.dureeRecette;
	}

	public void setDureeRecette(BigDecimal dureeRecette) {
		this.dureeRecette = dureeRecette;
	}

	public String getNomRecette() {
		return this.nomRecette;
	}

	public void setNomRecette(String nomRecette) {
		this.nomRecette = nomRecette;
	}

	public List<Instruction> getInstructions() {
		return this.instructions;
	}

	public void setInstructions(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public Instruction addInstruction(Instruction instruction) {
		getInstructions().add(instruction);
		instruction.setRecette(this);

		return instruction;
	}

	public Instruction removeInstruction(Instruction instruction) {
		getInstructions().remove(instruction);
		instruction.setRecette(null);

		return instruction;
	}

	public List<Mesure> getMesures() {
		return this.mesures;
	}

	public void setMesures(List<Mesure> mesures) {
		this.mesures = mesures;
	}

	public Mesure addMesure(Mesure mesure) {
		getMesures().add(mesure);
		mesure.setRecette(this);

		return mesure;
	}

	public Mesure removeMesure(Mesure mesure) {
		getMesures().remove(mesure);
		mesure.setRecette(null);

		return mesure;
	}

}