package modele;

import java.io.Serializable;
import javax.persistence.*;
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
	@SequenceGenerator(name="RECETTES_IDRECETTE_GENERATOR", sequenceName="SEQ_RECETTES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECETTES_IDRECETTE_GENERATOR")
	@Column(name="ID_RECETTE", unique=true, nullable=false, precision=8)
	private long idRecette;

	@Column(name="DESCRIPTION_RECETTE", nullable=false, length=1000)
	private String descriptionRecette;

	@Column(name="DUREE_RECETTE", nullable=false, precision=6)
	private int dureeRecette;

	@Column(name="NOM_RECETTE", nullable=false, length=100)
	private String nomRecette;

	//bi-directional many-to-one association to Usager
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_USAGER", nullable=false)
	private Usager usager;
	
	//bi-directional many-to-one association to Instruction
	@OneToMany(mappedBy="recette")
	private List<Instruction> instructions;

	//bi-directional many-to-one association to Mesure
	@OneToMany(mappedBy="recette")
	private List<Mesure> mesures;

	//bi-directional many-to-one association to TypesRecette
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_TYPE", nullable=false)
	private TypesRecette typesRecette;

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

	public int getDureeRecette() {
		return this.dureeRecette;
	}

	public void setDureeRecette(int dureeRecette) {
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

	public TypesRecette getTypesRecette() {
		return this.typesRecette;
	}

	public void setTypesRecette(TypesRecette typesRecette) {
		this.typesRecette = typesRecette;
	}

	public Usager getUsager() {
		return this.usager;
	}

	public void setUsager(Usager usager) {
		this.usager = usager;
	}
	
}