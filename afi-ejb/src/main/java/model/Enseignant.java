package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


@Entity
@Table(name="enseignant")
public class Enseignant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="code_ens")
	private String codeEns;

	private String email;

	private String grade;

	private String nom;

	private String prenom;

	private int tarifL1;

	private int tarifL2;

	private int tarifL3;
	
	private int tarifL1FC;

	private int tarifL2FC;

	private int tarifL3FC;

	private int tarifM1;

	private int tarifM2;
	
	private int tarifL1BE;

	private int tarifL2BE;

	private int tarifL3BE;
	
	private int tarifM1BE;

	private int tarifM2BE;

	private String tel;
	
	private String pwd;

	//bi-directional many-to-one association to Ec
	@OneToMany(mappedBy="enseignant", fetch=FetchType.EAGER)
	private List<Ec> ecs;
	
	@Transient
	private long montantGlobal;

	private boolean actived;
	
	public Enseignant() {
		// TODO Auto-generated constructor stub
	}
	
	public Enseignant(String codeEns, String email, String grade, String nom,
			String prenom, int tarifL1, int tarifL2, int tarifL3, int tarifM1,
			int tarifM2, String tel, String pwd) {
		super();
		this.codeEns = codeEns;
		this.email = email;
		this.grade = grade;
		this.nom = nom;
		this.prenom = prenom;
		this.tarifL1 = tarifL1;
		this.tarifL2 = tarifL2;
		this.tarifL3 = tarifL3;
		this.tarifM1 = tarifM1;
		this.tarifM2 = tarifM2;
		this.tel = tel;
		this.pwd = pwd;
	}
	
	public Enseignant(String codeEns, String email, String grade, String nom,
			String prenom, int tarifL1, int tarifL2, int tarifL3, int tarifM1,
			int tarifM2, String tel, String pwd, boolean actived) {
		super();
		this.codeEns = codeEns;
		this.email = email;
		this.grade = grade;
		this.nom = nom;
		this.prenom = prenom;
		this.tarifL1 = tarifL1;
		this.tarifL2 = tarifL2;
		this.tarifL3 = tarifL3;
		this.tarifM1 = tarifM1;
		this.tarifM2 = tarifM2;
		this.tel = tel;
		this.pwd = pwd;
		this.actived = actived;
	}
	public Enseignant(String codeEns, String email, String grade, String nom,
			String prenom, int tarifL1, int tarifL2, int tarifL3, int tarifM1,
			int tarifM2, String tel, String pwd, boolean actived, int tarifL1FC, int tarifL2FC, int tarifL3FC, int tarifL1BE, int tarifL2BE, int tarifL3BE, int tarifM1BE,
			int tarifM2BE) {
		super();
		this.codeEns = codeEns;
		this.email = email;
		this.grade = grade;
		this.nom = nom;
		this.prenom = prenom;
		this.tarifL1 = tarifL1;
		this.tarifL2 = tarifL2;
		this.tarifL3 = tarifL3;
		this.tarifM1 = tarifM1;
		this.tarifM2 = tarifM2;
		this.tel = tel;
		this.pwd = pwd;
		this.actived = actived;
		this.tarifL1FC = tarifL1FC;
		this.tarifL2FC = tarifL2FC;
		this.tarifL3FC = tarifL3FC;
		this.tarifL1BE = tarifL1BE;
		this.tarifL2BE = tarifL2BE;
		this.tarifL3BE = tarifL3BE;
		this.tarifM1BE = tarifM1BE;
		this.tarifM2BE =tarifM2BE;
	}

	public String getCodeEns() {
		return codeEns;
	}

	public void setCodeEns(String codeEns) {
		this.codeEns = codeEns;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getTarifL1() {
		return tarifL1;
	}

	public void setTarifL1(int tarifL1) {
		this.tarifL1 = tarifL1;
	}

	public int getTarifL2() {
		return tarifL2;
	}

	public void setTarifL2(int tarifL2) {
		this.tarifL2 = tarifL2;
	}

	public int getTarifL3() {
		return tarifL3;
	}

	public void setTarifL3(int tarifL3) {
		this.tarifL3 = tarifL3;
	}

	public int getTarifL1FC() {
		return tarifL1FC;
	}

	public void setTarifL1FC(int tarifL1FC) {
		this.tarifL1FC = tarifL1FC;
	}

	public int getTarifL2FC() {
		return tarifL2FC;
	}

	public void setTarifL2FC(int tarifL2FC) {
		this.tarifL2FC = tarifL2FC;
	}

	public int getTarifL3FC() {
		return tarifL3FC;
	}

	public void setTarifL3FC(int tarifL3FC) {
		this.tarifL3FC = tarifL3FC;
	}

	public int getTarifM1() {
		return tarifM1;
	}

	public void setTarifM1(int tarifM1) {
		this.tarifM1 = tarifM1;
	}

	public int getTarifM2() {
		return tarifM2;
	}

	public void setTarifM2(int tarifM2) {
		this.tarifM2 = tarifM2;
	}

	
	public int getTarifL1BE() {
		return tarifL1BE;
	}

	public void setTarifL1BE(int tarifL1BE) {
		this.tarifL1BE = tarifL1BE;
	}

	public int getTarifL2BE() {
		return tarifL2BE;
	}

	public void setTarifL2BE(int tarifL2BE) {
		this.tarifL2BE = tarifL2BE;
	}

	public int getTarifL3BE() {
		return tarifL3BE;
	}

	public void setTarifL3BE(int tarifL3BE) {
		this.tarifL3BE = tarifL3BE;
	}

	public int getTarifM1BE() {
		return tarifM1BE;
	}

	public void setTarifM1BE(int tarifM1BE) {
		this.tarifM1BE = tarifM1BE;
	}

	public int getTarifM2BE() {
		return tarifM2BE;
	}

	public void setTarifM2BE(int tarifM2BE) {
		this.tarifM2BE = tarifM2BE;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<Ec> getEcs() {
		return ecs;
	}

	public void setEcs(List<Ec> ecs) {
		this.ecs = ecs;
	}

	public long getMontantGlobal() {
		return montantGlobal;
	}

	public void setMontantGlobal(long montantGlobal) {
		this.montantGlobal = montantGlobal;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	@Override
	public String toString() {
		return "Enseignant [codeEns=" + codeEns + ", email=" + email
				+ ", grade=" + grade + ", nom=" + nom + ", prenom=" + prenom
				+ ", tarifL1=" + tarifL1 + ", tarifL2=" + tarifL2
				+ ", tarifL3=" + tarifL3 + ", tarifM1=" + tarifM1
				+ ", tarifM2=" + tarifM2 + ", tel=" + tel + ", pwd=" + pwd
				+ ", actived=" + actived + "]";
	}
	
}
