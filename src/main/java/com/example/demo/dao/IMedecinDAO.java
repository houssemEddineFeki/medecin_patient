package com.example.demo.dao;

import java.util.List;

import com.example.demo.entities.Medecin;

public interface IMedecinDAO {
	public void addMedecin(Medecin obj);

	public void deleteMedecin(Long id);

	public void updateMedecin(Medecin obj);

	public Medecin findMedecinByID(Long id);

	public List<Medecin> findAll();
}
