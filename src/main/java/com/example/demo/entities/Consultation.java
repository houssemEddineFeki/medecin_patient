package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.entities.Medecin;
@Entity
public class Consultation implements Serializable{

	@Id
	@GeneratedValue
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private  String notes;
	
	@ManyToOne(cascade= CascadeType.ALL)
	private Medecin medecin;
	
	@ManyToOne(cascade= CascadeType.ALL)
	private Patient patient;
	
	public Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Consultation(Date date, String notes) {
		super();
		this.date = date;
		this.notes = notes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
}

