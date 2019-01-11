package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
	@Query("select m from Medecin m where m.nom like :x")
	public List<Medecin> chercher(@Param("x") String mc);
}
