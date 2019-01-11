package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.example.demo.entities.Medecin;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@DiscriminatorValue("MG")
public class MedecinGeneraliste extends Medecin implements Serializable {

	@OneToMany(mappedBy="generaliste")
	@JsonIgnore
	private Collection <Patient> patients;
	
	public MedecinGeneraliste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedecinGeneraliste(String nom, String prenom, Date dateNaissance, String email, byte[] photo,
			String codePublic) {
		super(nom, prenom, dateNaissance, email, photo, codePublic);
		// TODO Auto-generated constructor stub
	}

	public Collection<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Collection<Patient> patients) {
		this.patients = patients;
	}
	

	
}
