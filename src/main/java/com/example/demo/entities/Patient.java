package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Patient implements Serializable {
	@javax.persistence.Id
	@GeneratedValue
	private Long Id;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Lob
	private byte[] photo;
	private String email;
	private String  tel;
	private String numCnam;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private MedecinGeneraliste generaliste;
	
	@ManyToMany(mappedBy="patients")
	@JsonIgnore
	private Collection<MedecinSpacialiste>  specialistes;
	
	@OneToMany(mappedBy="patient")
	@JsonIgnore
	private Collection<Consultation>consultations;
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Patient(String nom, String prenom, Date dateNaissance, byte[] photo, String email, String tel,
			String numCnam) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.photo = photo;
		this.email = email;
		this.tel = tel;
		this.numCnam = numCnam;
	}


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
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


	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getNumCnam() {
		return numCnam;
	}


	public void setNumCnam(String numCnam) {
		this.numCnam = numCnam;
	}


	public MedecinGeneraliste getGeneraliste() {
		return generaliste;
	}


	public void setGeneraliste(MedecinGeneraliste generaliste) {
		this.generaliste = generaliste;
	}


	public Collection<MedecinSpacialiste> getSpecialistes() {
		return specialistes;
	}


	public void setSpecialistes(Collection<MedecinSpacialiste> specialistes) {
		this.specialistes = specialistes;
	}
	
	

}
