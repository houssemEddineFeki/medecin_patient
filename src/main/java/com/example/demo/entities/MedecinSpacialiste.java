package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.example.demo.entities.Medecin;
@Entity
@DiscriminatorValue("MS")
public class MedecinSpacialiste extends Medecin implements Serializable {
 
	private String specialite;
	
 @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
// @ManyToMany(cascade=CascadeType.ALL) default fetch strategy is lazy
 private Collection<Patient> patients;

public MedecinSpacialiste() {
	super();
	// TODO Auto-generated constructor stub
}

public MedecinSpacialiste(String nom, String prenom, Date dateNaissance, String email,  byte[] photo,
		String codePublic, String specialite) {
	super(nom, prenom, dateNaissance, email, photo, codePublic);
	this.specialite=specialite;
	// TODO Auto-generated constructor stub
}

public String getSpecialite() {
	return specialite;
}

public void setSpecialite(String specialite) {
	this.specialite = specialite;
}

public Collection<Patient> getPatients() {
	return patients;
}

public void setPatients(Collection<Patient> patients) {
	this.patients = patients;
}

 
}
