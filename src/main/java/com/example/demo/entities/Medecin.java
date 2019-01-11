package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_med",discriminatorType=DiscriminatorType.STRING, length=2)
public class Medecin implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	private String prenom;
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	private String email;
	@Lob
	private byte[] photo;
	private String codePublic;
	
	@OneToMany(mappedBy="medecin")
	@JsonIgnore
	private Collection<Consultation>consultations;
	
	public Medecin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Medecin(String nom, String prenom, Date dateNaissance, String email,  byte[] photo,
			String codePublic) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
	
		this.photo = photo;
		this.codePublic = codePublic;
	}
	
	public Collection<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(Collection<Consultation> consultations) {
		this.consultations = consultations;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodePublic() {
		return codePublic;
	}
	public void setCodePublic(String codePublic) {
		this.codePublic = codePublic;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	

}
